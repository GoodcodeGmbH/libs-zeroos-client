/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.goodcode.libs.zeroos.client.managers;

import ch.goodcode.libs.zeroos.client.JythonController;

/**
 *
 * @author Paolo Domenighetti
 */
public class InfoManager extends AbstractManager {

    public InfoManager(JythonController PY, String ENTITY_VARNAME) {
        super(PY, ENTITY_VARNAME);
    }
    
    public String nic() {
        PY.rawAssign("info", TARGET_ENTITY_VARNAME+".info.nic()");
        return PY.rawGet("info");
    }
    
    public String cpu() {
        PY.rawAssign("info", TARGET_ENTITY_VARNAME+".info.cpu()");
        return PY.rawGet("info");
    }
    
    public String mem() {
        PY.rawAssign("info", TARGET_ENTITY_VARNAME+".info.mem()");
        return PY.rawGet("info");
    }
    
    public String disk() {
        PY.rawAssign("info", TARGET_ENTITY_VARNAME+".info.disk()");
        return PY.rawGet("info");
    }
    
    public String os() {
        PY.rawAssign("info", TARGET_ENTITY_VARNAME+".info.os()");
        return PY.rawGet("info");
    }
    
    public String port() {
        PY.rawAssign("info", TARGET_ENTITY_VARNAME+".info.port()");
        return PY.rawGet("info");
    }
    
    public String version() {
        PY.rawAssign("info", TARGET_ENTITY_VARNAME+".info.version()");
        return PY.rawGet("info");
    }
    
}
