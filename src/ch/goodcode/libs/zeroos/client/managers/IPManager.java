/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.goodcode.libs.zeroos.client.managers;

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
    
    public IPManager(Jedis jedis) {
        super(jedis);
        bridge = new IPBridgeManager(jedis);
        link = new IPLinkManager(jedis);
        addr = new IPAddrManager(jedis);
        route = new IPRouteManager(jedis);
    }
    
}
