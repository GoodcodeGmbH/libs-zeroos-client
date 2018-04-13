/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.goodcode.libs.zeroos.client;

import ch.goodcode.libs.logging.LogBuffer;
import ch.goodcode.libs.zeroos.client.managers.FilsesystemManager;
import ch.goodcode.libs.zeroos.client.managers.IPManager;
import ch.goodcode.libs.zeroos.client.managers.InfoManager;
import ch.goodcode.libs.zeroos.client.managers.JobManager;
import ch.goodcode.libs.zeroos.client.managers.ProcessManager;
import java.util.HashMap;
import redis.clients.jedis.Jedis;

/**
 *
 * @author Paolo Domenighetti
 */
abstract class BaseClient {

    protected final LogBuffer log;
    public final Jedis jedis;

    public final long timeout;
    public final InfoManager info;
    public final JobManager job;
    public final ProcessManager process;
    public final FilsesystemManager filesystem;
    public final IPManager ip;

    public BaseClient(LogBuffer log, long timeout) {
        this.log = log;
        this.jedis = new Jedis(""); // <Zero-os node IP address in the ZeroTier network>
        this.timeout = timeout;
        this.info = new InfoManager(log, jedis);
        this.job = new JobManager(log, jedis);
        this.process = new ProcessManager(log, jedis);
        this.filesystem = new FilsesystemManager(log, jedis);
        this.ip = new IPManager(log, jedis);
    }

    /**
     * Implements the low level command call, this needs to build the command
     * structure and push it on the correct queue. :param command: Command name
     * to execute supported by the node (ex: core.system, info.cpu, etc...)
     * check documentation for list of built in commands :param arguments: A
     * dict of required command arguments depends on the command name. :param
     * queue: command queue (commands on the same queue are executed
     * sequentially) :param max_time: kill job server side if it exceeded this
     * amount of seconds :param stream: If True, process stdout and stderr are
     * pushed to a special queue (stream:<id>) so client can stream output
     * :param tags: job tags :param id: job id. Generated if not supplied
     * :return: Response object
     */
    public abstract Response raw(String command, HashMap<String, String> arguments, String queue, boolean stream, long max_time, String id, String... tags);

    /**
     * Same as self.raw except it do a response.get() waiting for the command
     * execution to finish and reads the result :param command: Command name to
     * execute supported by the node (ex: core.system, info.cpu, etc...) check
     * documentation for list of built in commands
     *
     * :param arguments: A dict of required command arguments depends on the
     * command name. :param tags: job tags :param id: job id. Generated if not
     * supplied :return: Result object
     */
    public void sync(String command, HashMap<String, String> arguments, String id, String... tags) {

    }

    /**
     *
     * @param command
     * @param arguments
     * @param id
     * @param tags
     */
    public String json(String command, HashMap<String, String> arguments, String id, String... tags) {

    }
    
    /**
     * 
     * @param command
     * @param arguments 
     */
    public String json(String command, HashMap<String, String> arguments) {

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
