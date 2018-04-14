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
public class ProcessManager extends AbstractManager {

    public ProcessManager(JythonController PY, String TARGET_ENTITY_VARNAME) {
        super(PY, TARGET_ENTITY_VARNAME);
    }
 
    /**
     * 
     * @return 
     */
    public String list() throws PythonClientException {
        PY.rawAssign("lista", TARGET_ENTITY_VARNAME+".process.list()");
        return PY.rawGet("lista");
    }
    
    /**
     * Do not kill 0-core!
     * @param pid
     * @return 
     */
    public String kill(String pid) throws PythonClientException {
        PY.rawAssign("res", TARGET_ENTITY_VARNAME+".process.kill('"+pid+"')");
        return PY.rawGet("res");
    }
}
