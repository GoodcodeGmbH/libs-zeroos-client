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
public class IPLinkManager extends AbstractJedisWrap {
    
    public IPLinkManager(Jedis jedis) {
        super(jedis);
    }
    
}