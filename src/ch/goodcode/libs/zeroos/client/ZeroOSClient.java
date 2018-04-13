/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.goodcode.libs.zeroos.client;

import ch.goodcode.libs.logging.LogBuffer;
import ch.goodcode.libs.utils.dataspecs.EJSONArray;
import ch.goodcode.libs.utils.dataspecs.EJSONObject;
import ch.goodcode.libs.zeroos.client.managers.AggregatorManager;
import ch.goodcode.libs.zeroos.client.managers.BridgeManager;
import ch.goodcode.libs.zeroos.client.managers.BtrfsManager;
import ch.goodcode.libs.zeroos.client.managers.ContainerManager;
import ch.goodcode.libs.zeroos.client.managers.DiskManager;
import ch.goodcode.libs.zeroos.client.managers.KvmManager;
import ch.goodcode.libs.zeroos.client.managers.ZerotierManager;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Paolo Domenighetti
 */
public final class ZeroOSClient extends BaseClient {
    
    
    public final Nft nft = new Nft();
    public final Config config = new Config();
    
    public final ContainerManager container;
    public final BridgeManager bridge;
    public final DiskManager disk;
    public final BtrfsManager btrfs;
    public final ZerotierManager zerotier;
    public final KvmManager kvm;
    public final AggregatorManager aggregator;


    public ZeroOSClient(LogBuffer log, String zeroTierHost, String password) { 
        super(log, 0L);
        container = new ContainerManager(log, jedis);
        bridge = new BridgeManager(log, jedis);
        disk = new DiskManager(log, jedis);
        btrfs = new BtrfsManager(log, jedis);
        zerotier = new ZerotierManager(log, jedis);
        kvm = new KvmManager(log, jedis);
        aggregator = new AggregatorManager(log, jedis);
    }

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//    }
    
    
    /**
     *  Implements the low level command call, this needs to build the command structure
        and push it on the correct queue.
        :param command: Command name to execute supported by the node (ex: core.system, info.cpu, etc...)
                        check documentation for list of built in commands
        :param arguments: A dict of required command arguments depends on the command name.
        :param queue: command queue (commands on the same queue are executed sequentially)
        :param max_time: kill job server side if it exceeded this amount of seconds
        :param stream: If True, process stdout and stderr are pushed to a special queue (stream:<id>) so
            client can stream output
        :param tags: job tags
        :param id: job id. Generated if not supplied
        :return: Response object
     */
    @Override
    public Response raw(String command, HashMap<String,String> arguments, String queue, boolean stream, long max_time, String id, String... tags) {
        if(id == null) {
            id = "TODO generate";
        }
        
        EJSONObject payload = new EJSONObject();
        payload.putString("id", id);
        payload.putString("queue", queue);
        payload.putLong("max_time", max_time);
        payload.putBoolean("stream", stream);
        
        EJSONArray tagsa = new EJSONArray();
        for (String tag : tags) {
            tagsa.addString(tag);
        }
        payload.putArray("tags", tagsa);
        
        EJSONObject args = new EJSONObject();
        for (Map.Entry<String, String> entry : arguments.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            args.putString(key, value);
        }
        payload.putObject("arguments", args);
        
        String flag = "result:"+id+":flag";
        jedis.rpush("core:default", payload.toJSONString());
        
        String brpoplpush = jedis.brpoplpush(flag, flag, 10);
        if(brpoplpush == null || brpoplpush.equals("")) {
            // TODO log timeout in submit
            return null;
        }
        
        Response r = new Response(jedis, id);
        return r;
    }
    
    
    
}
