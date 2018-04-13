/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.goodcode.libs.zeroos.client;

import java.util.List;
import redis.clients.jedis.Jedis;

/**
 *
 * @author Paolo Domenighetti
 */
public class Response {

    protected final Jedis jedis;
    protected final String id;
    private String queue;

    public Response(Jedis jedis, String id) {
        this.jedis = jedis;
        this.id = id;
        this.queue = "result:" + id;
    }

    /**
     *
     * @return
     */
    public String id() {
        return id;
    }

    /**
     * 
     * @return 
     */
    public boolean exists() {
        return jedis.exists(queue+":flag");
    }

    /**
     * 
     * @return 
     */
    public boolean running() {
        if(exists()) {
            return jedis.ttl(queue+":flag") == 0;
        } else {
            return false;
        }
    }

    /**
     * Runtime copy of job messages.
     * 
     * This required the 'stream` flag to be set to True otherwise it will
        not be able to copy any output, while it will block until the process exits.
        :note: This function will block until it reaches end of stream or the process is no longer running.
        :param callback: callback method that will get called for each received message
                         callback accepts 3 arguments
                         - level int: the log message levels, refer to the docs for available levels
                                      and their meanings
                         - message str: the actual output message
                         - flags int: flags associated with this message
                                      - 0x2 means EOF with success exit status
                                      - 0x4 means EOF with error
                                      for example (eof = flag & 0x6) eof will be true for last message u will ever
                                      receive on this callback.
                         Note: if callback is none, a default callback will be used that prints output on stdout/stderr
                         based on level.
        :return: None
     */
    public void stream() {
        boolean stream = true;
        while (stream) {            
            List<String> data = jedis.blpop(20, queue);
            if(data == null || data.isEmpty()) {
                break;
            } else {
                String payload = data.get(1);
            }
        }
    }

    /**
     * Waits for a job to finish (max of given timeout seconds) and return job results. When a job exits get() will
        keep returning the same result until zero-os doesn't remember the job anymore (self.exists == False)
        :notes: the timeout here is a client side timeout, it's different than the timeout given to the job on start
        (like in system method) witch will cause the job to be killed if it exceeded this timeout.
        :param timeout: max time to wait for the job to finish in seconds
        :return: Return object
     */
    public void get() {

    }
}
