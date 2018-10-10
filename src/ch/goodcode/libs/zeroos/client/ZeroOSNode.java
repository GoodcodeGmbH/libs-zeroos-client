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
import java.util.HashMap;

/**
 *
 * @author Paolo Domenighetti
 */
public final class ZeroOSNode {
    
    public static final String STATUS_ONLINE = "ONLINE";
    public static final String STATUS_HEALTHY = "HEALTHY";
    public static final String STATUS_UNKNOWN = "UNKNOWN";
    public static final String STATUS_ERROR = "ERROR";
    
    public final FilesystemManager filesystem;
    public final DiskManager disk;
    public final BtrfsManager btrfs;
    
    private final HashMap<String, Container> containers = new HashMap<>();

    private final String UID;
    private final JythonController PY;
    private final LogBuffer LOG;
    private String status;

    /**
     * 
     * @param uid
     * @param log
     * @param zeroCoreNodeAddr
     * @param password 
     */
    public ZeroOSNode(String uid, LogBuffer log, String zeroCoreNodeAddr, String password) {
       this.UID = uid;
        if(log == null) {
            log = new LogBuffer("autogen-"+this.getClass().getCanonicalName(), "C:\\temp", 0, 99);
        }
        this.LOG = log;
        this.PY = new JythonController(zeroCoreNodeAddr, password);
        this.filesystem = new FilesystemManager(PY, "cl");
        this.disk = new DiskManager(PY, "cl");
        this.btrfs = new BtrfsManager(PY, "cl");
    }

    public void prepare() throws PythonClientException, ZeroOSException {
        // TODO ...
        this.PY.initialize();
    }
    
    public void cleanup() throws PythonClientException, ZeroOSException {
        this.PY.dispose();
        // TODO ...
    }

    // ====================================================================================================================
    // ====================================================================================================================
    // Model APIs
    
    /**
     * 
     * @param flist a gig official flist with .flist extension
     * @param nicZerotierId id of the nic adapter
     * @param storage eg. ardb://hub.gig.tech:16379
     * @return the ID of the newly created 
     * @throws ch.goodcode.libs.zeroos.client.ZeroOSException 
     * @throws ch.goodcode.libs.zeroos.client.PythonClientException 
     */
    public String createDefaultContainer(String flist, String nicZerotierId, String storage) throws ZeroOSException, PythonClientException {
        PY.rawAssign("nic", "[{'type':'default'}, {'type': 'zerotier', 'id': '"+nicZerotierId+"'}]");
        PY.rawAssign("cid", "cl.container.create('https://hub.gig.tech/gig-official-apps/"+flist+"', nics=nic, storage='"+storage+"').get(60)");
        return PY.rawGet("cid");
    }
    
    /**
     * 
     * @param id
     * @return the container with given ID or null if no container with such ID exists
     * @throws ch.goodcode.libs.zeroos.client.ZeroOSException
     * @throws ch.goodcode.libs.zeroos.client.PythonClientException
     */
    public Container getContainer(String id) throws ZeroOSException, PythonClientException {
        if(!containers.containsKey(id)) {
            containers.put(id, new Container(id, PY));
        }
        return containers.get(id);
    }


    // ====================================================================================================================
    // ====================================================================================================================

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
  
}
