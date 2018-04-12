/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.goodcode.libs.zeroos.client;

import ch.goodcode.libs.zeroos.client.managers.FilsesystemManager;
import ch.goodcode.libs.zeroos.client.managers.IPManager;
import ch.goodcode.libs.zeroos.client.managers.InfoManager;
import ch.goodcode.libs.zeroos.client.managers.JobManager;
import ch.goodcode.libs.zeroos.client.managers.ProcessManager;
import redis.clients.jedis.Jedis;

/**
 *
 * @author Paolo Domenighetti
 */
public class BaseClient {

    public final long timeout;
    public final InfoManager info;
    public final JobManager job;
    public final ProcessManager process;
    public final FilsesystemManager filesystem;
    public final IPManager ip;

    public BaseClient(Jedis jedis, long timeout) {
        this.timeout = timeout;
        this.info = new InfoManager(jedis);
        this.job = new JobManager(jedis);
        this.process = new ProcessManager(jedis);
        this.filesystem = new FilsesystemManager(jedis);
        this.ip = new IPManager(jedis);
    }
    
    public void raw() {
        
    }
    
    public void sync() {
        
    }
    
    public void json() {
        
    }
    
    public void ping() {
        
    }
    
    public void system() {
        
    }
    
    public void bash() {
        
    }
    
    public void subscribe() {
        
    }
}
