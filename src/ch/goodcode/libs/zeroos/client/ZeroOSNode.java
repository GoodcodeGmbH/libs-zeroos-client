/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.goodcode.libs.zeroos.client;

import ch.goodcode.libs.logging.LogBuffer;
import ch.goodcode.libs.zeroos.client.managers.BtrfsManager;
import ch.goodcode.libs.zeroos.client.managers.DiskManager;
import ch.goodcode.libs.zeroos.client.managers.FilesystemManager;
import ch.goodcode.libs.zeroos.client.model.Container;
import java.util.HashMap;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

/**
 *
 * @author Paolo Domenighetti
 */
public final class ZeroOSNode {
    
    public final FilesystemManager filesystem;
    public final DiskManager disk;
    public final BtrfsManager btrfs;
    
    private final HashMap<String, Container> containers = new HashMap<>();

    private final JythonController PY;
    private final LogBuffer LOG;

    public ZeroOSNode(LogBuffer log, String zeroCoreNodeAddr, String password) {
        this.LOG = log;
        this.PY = new JythonController(zeroCoreNodeAddr, password);
        this.filesystem = new FilesystemManager(PY, "cl");
        this.disk = new DiskManager(PY, "cl");
        this.btrfs = new BtrfsManager(PY, "cl");
    }

    public void start() {

    }
    
    public void stop() {

    }

    // ====================================================================================================================
    // ====================================================================================================================
    // Model APIs
    
    /**
     * 
     * @param flist a gig official flist with .flist extension
     * @param nicZerotierId id
     * @param storage ardb://hub.gig.tech:16379
     * @return 
     */
    public String createDefaultContainer(String flist, String nicZerotierId, String storage) {
        PY.rawAssign("nic", "[{'type':'default'}, {'type': 'zerotier', 'id': '"+nicZerotierId+"'}]");
        PY.rawAssign("cid", "cl.container.create('https://hub.gig.tech/gig-official-apps/"+flist+"', nics=nic, storage='"+storage+"').get(60)");
        return PY.rawGet("cid");
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public Container getContainer(String id) {
        if(!containers.containsKey(id)) {
            containers.put(id, new Container(id, PY));
        }
        return containers.get(id);
    }


    // ====================================================================================================================
    // ====================================================================================================================
    public static void main(String[] args) {
        //test1();
    }

    private static void test1() {
        PythonInterpreter interp = new PythonInterpreter();
        interp.exec("import sys");
        interp.exec("print sys");
        interp.set("a", new PyInteger(42));
        interp.exec("print a");
        interp.exec("x = 2+2");
        PyObject x = interp.get("x");
        System.out.println("x: " + x);
    }

    private static void test2() {
        LogBuffer log = new LogBuffer("test-log", "C:\\temp", 0, 99);
        ZeroOSNode o = new ZeroOSNode(log, "", "");
        o.start();

        
        
        o.stop();
    }
}
