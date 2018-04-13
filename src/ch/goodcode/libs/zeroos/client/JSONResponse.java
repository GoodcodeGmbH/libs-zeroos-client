/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.goodcode.libs.zeroos.client;

import redis.clients.jedis.Jedis;

/**
 *
 * @author Paolo Domenighetti
 */
public class JSONResponse extends Response {

    public JSONResponse(Jedis jedis, String id) {
        super(jedis, id);
    }

    @Override
    public void get() {
        super.get(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
