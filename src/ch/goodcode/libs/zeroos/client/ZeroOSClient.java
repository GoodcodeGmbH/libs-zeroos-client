/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.goodcode.libs.zeroos.client;

import ch.goodcode.libs.zeroos.client.managers.AggregatorManager;
import ch.goodcode.libs.zeroos.client.managers.BridgeManager;
import ch.goodcode.libs.zeroos.client.managers.BtrfsManager;
import ch.goodcode.libs.zeroos.client.managers.ContainerManager;
import ch.goodcode.libs.zeroos.client.managers.DiskManager;
import ch.goodcode.libs.zeroos.client.managers.KvmManager;
import ch.goodcode.libs.zeroos.client.managers.ZerotierManager;
import redis.clients.jedis.Jedis;

/**
 *
 * @author Paolo Domenighetti
 */
public class ZeroOSClient {
    
    private final Jedis jedis;
    
    public final Nft nft = new Nft();
    public final Config config = new Config();
    
    public final ContainerManager container;
    public final BridgeManager bridge;
    public final DiskManager disk;
    public final BtrfsManager btrfs;
    public final ZerotierManager zerotier;
    public final KvmManager kvm;
    public final AggregatorManager aggregator;

    /**
     * 
     * @param nodeIpInZeroTierNetwork 
     */
    public ZeroOSClient(String nodeIpInZeroTierNetwork) { // <Zero-os node IP address in the ZeroTier network>
        this.jedis = new Jedis(nodeIpInZeroTierNetwork); // TODO better
        container = new ContainerManager(jedis);
        bridge = new BridgeManager(jedis);
        disk = new DiskManager(jedis);
        btrfs = new BtrfsManager(jedis);
        zerotier = new ZerotierManager(jedis);
        kvm = new KvmManager(jedis);
        aggregator = new AggregatorManager(jedis);
    }

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//    }
    
    
    public void raw() {
        
    }
    
    public void responseFor() {
        
    }
    
}
