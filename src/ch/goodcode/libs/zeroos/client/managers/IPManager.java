/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.goodcode.libs.zeroos.client.managers;

import ch.goodcode.libs.logging.LogBuffer;
import redis.clients.jedis.Jedis;

/**
 *
 * @author Paolo Domenighetti
 */
public class IPManager extends AbstractJedisWrap {
    

    public final IPBridgeManager bridge;
    public final IPLinkManager link;
    public final IPAddrManager addr;
    public final IPRouteManager route;
    
    public IPManager(LogBuffer log, Jedis jedis) {
        super(log, jedis);
        bridge = new IPBridgeManager(log, jedis);
        link = new IPLinkManager(log, jedis);
        addr = new IPAddrManager(log, jedis);
        route = new IPRouteManager(log, jedis);
    }
    
}
