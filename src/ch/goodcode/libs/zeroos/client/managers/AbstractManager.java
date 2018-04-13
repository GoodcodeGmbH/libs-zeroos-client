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
public class AbstractManager {
    
    protected final JythonController PY;
    protected final String TARGET_ENTITY_VARNAME;

    public AbstractManager(JythonController PY, String TARGET_ENTITY_VARNAME) {
        this.PY = PY;
        this.TARGET_ENTITY_VARNAME = TARGET_ENTITY_VARNAME;
    }

    
    
}
