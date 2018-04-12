/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.goodcode.libs.zeroos.client;

import java.util.HashMap;

/**
 *
 * @author Paolo Domenighetti
 */
public class Return {
    
    private HashMap<String,Object> payload;
    private Object data;
    private String id;

    public HashMap<String, Object> getPayload() {
        return payload;
    }

    public Object getData() {
        return data;
    }

    public String getId() {
        return id;
    }
    
    /**
     *  For example, if a job returns a json object the self.level will be 20 and the data will contain the serialized
        json object, other levels exists for yaml, toml, etc... it really depends on the running job
        return: python primitive (str, number, dict or array)
     * @return 
     */
    public int level() {
        return (Integer) payload.get("level");
    }
    
    /**
     * 
     * @return a unix timestamp in seconds (not millis)
     */
    public long starttime() {
        return ((Long) payload.get("starttime")) / 1000L;
    }
    
    /**
     * 
     * @return a unix timestamp in seconds (not millis)
     */
    public long time() {
        return ((Long) payload.get("time")) / 1000L;
    }
    
    /**
     * 
     * @return str one of [SUCCESS, ERROR, KILLED, TIMEOUT, UNKNOWN_CMD, DUPLICATE_ID]
     */
    public String state() {
        return (String) payload.get("state");
    }
    
    /**
     * The job stdout
     * 
     * @return 
     */
    public String stdout() {
        String[] streams = (String[]) payload.get("streams");
        if(streams.length >= 1) {
            return streams[0];
        } else {
            return "";
        }
    }
    
    /**
     * The job stderr
     * 
     * @return 
     */
    public String stderr() {
        String[] streams = (String[]) payload.get("streams");
        if(streams.length >= 2) {
            return streams[1];
        } else {
            return "";
        }
    }
    
    /**
     *  Exit code of the job, this can be either one of the http codes, of (if the value > 1000)
        is the exit code of the underlaying process
        if code > 1000:
            exit_code = code - 1000
     * @return 
     */
    public int code() {
        return (Integer) payload.get("code");
    }
}
