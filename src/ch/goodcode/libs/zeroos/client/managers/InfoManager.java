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
public class InfoManager extends AbstractManager {

    public InfoManager(JythonController PY, String ENTITY_VARNAME) {
        super(PY, ENTITY_VARNAME);
    }
    
    public String nic() throws PythonClientException {
        PY.rawAssign("z", TARGET_ENTITY_VARNAME+".info.nic()");
        return PY.rawGet("z");
    }
    
    public String cpu() throws PythonClientException {
        PY.rawAssign("z", TARGET_ENTITY_VARNAME+".info.cpu()");
        return PY.rawGet("z");
    }
    
    public String mem() throws PythonClientException {
        PY.rawAssign("z", TARGET_ENTITY_VARNAME+".info.mem()");
        return PY.rawGet("z");
    }
    
    public String disk() throws PythonClientException {
        PY.rawAssign("z", TARGET_ENTITY_VARNAME+".info.disk()");
        return PY.rawGet("z");
    }
    
    public String os() throws PythonClientException {
        PY.rawAssign("z", TARGET_ENTITY_VARNAME+".info.os()");
        return PY.rawGet("z");
    }
    
    public String port() throws PythonClientException {
        PY.rawAssign("z", TARGET_ENTITY_VARNAME+".info.port()");
        return PY.rawGet("z");
    }
    
    public String version() throws PythonClientException {
        PY.rawAssign("z", TARGET_ENTITY_VARNAME+".info.version()");
        return PY.rawGet("z");
    }
    
}
