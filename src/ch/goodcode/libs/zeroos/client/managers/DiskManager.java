/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.goodcode.libs.zeroos.client.managers;

import ch.goodcode.libs.zeroos.client.JythonController;
import ch.goodcode.libs.zeroos.client.PythonClientException;

/**
 *
 * @author Paolo Domenighetti
 */
public class DiskManager extends AbstractManager {
    
    public DiskManager(JythonController PY, String TARGET_ENTITY_VARNAME) {
        super(PY, TARGET_ENTITY_VARNAME);
    }
    
    public String mount(String devicename, String path) throws PythonClientException {
        PY.rawAssign("res", TARGET_ENTITY_VARNAME+".disk.mount('"+devicename+"',"+path+"')");
        return PY.rawGet("res");
    }
    
    public String list() throws PythonClientException {
        PY.rawAssign("res", TARGET_ENTITY_VARNAME+".disk.list()");
        return PY.rawGet("res");
    }
}
