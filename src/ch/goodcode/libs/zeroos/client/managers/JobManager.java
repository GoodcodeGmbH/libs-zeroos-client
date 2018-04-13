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
public class JobManager extends AbstractClientWrap {

    public JobManager(LogBuffer log, Jedis jedis) {
        super(log, jedis);
    }
    
    
}
