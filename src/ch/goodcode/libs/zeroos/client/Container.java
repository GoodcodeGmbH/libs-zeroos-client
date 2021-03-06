/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.goodcode.libs.zeroos.client;

import ch.goodcode.libs.zeroos.client.JythonController;
import ch.goodcode.libs.zeroos.client.PythonClientException;
import ch.goodcode.libs.zeroos.client.ZeroOSException;
import ch.goodcode.libs.zeroos.client.managers.InfoManager;
import ch.goodcode.libs.zeroos.client.managers.ProcessManager;

/**
 *
 * @author Paolo Domenighetti
 */
public class Container {
    
    public final String id;
    public final InfoManager info;
    public final ProcessManager process;
    
    private final JythonController PY;
    private final String VARNAME;

    public Container(String id, JythonController PY) throws PythonClientException, ZeroOSException {
        this.id = id;
        this.PY = PY;
        this.VARNAME = "container_"+id;
        this.info = new InfoManager(PY, VARNAME);
        this.process = new ProcessManager(PY, VARNAME);
        this.PY.rawAssign(VARNAME, "cl.container.client('"+id+"')");
    }

    /**
     * 
     * @param linuxCommand
     * @return 
     */
    public String system(String linuxCommand) throws PythonClientException, ZeroOSException {
        return PY.processOnVar(VARNAME, "system('"+linuxCommand+"').get(60)");
    }
    
}
