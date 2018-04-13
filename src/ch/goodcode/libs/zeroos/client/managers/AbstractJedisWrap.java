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
public abstract class AbstractJedisWrap {
    
    protected final LogBuffer log;
    protected final Jedis jedis;

    public AbstractJedisWrap(LogBuffer log, Jedis jedis) {
        this.log = log;
        this.jedis = jedis;
    }

    
    
}
