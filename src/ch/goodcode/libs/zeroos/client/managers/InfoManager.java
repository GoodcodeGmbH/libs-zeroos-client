/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.goodcode.libs.zeroos.client.managers;

import ch.goodcode.libs.logging.LogBuffer;
import ch.goodcode.libs.zeroos.client.ZeroOSClient;
import java.util.HashMap;
import redis.clients.jedis.Jedis;

/**
 *
 * @author Paolo Domenighetti
 */
public class InfoManager extends AbstractClientWrap {

    public InfoManager(LogBuffer log, ZeroOSClient backref) {
        super(log, backref);
    }

    public String cpu() {
        return backref.json("info.cpu", new HashMap<String, String>());
    }

    public String nic() {
        return backref.json("info.nic", new HashMap<String, String>());
    }

    public String mem() {
        return backref.json("info.mem", new HashMap<String, String>());
    }

    public String disk() {
        return backref.json("info.disk", new HashMap<String, String>());
    }

    public String os() {
        return backref.json("info.os", new HashMap<String, String>());
    }

    public String port() {
        return backref.json("info.port", new HashMap<String, String>());
    }

    public String version() {
        return backref.json("info.version", new HashMap<String, String>());
    }

}
