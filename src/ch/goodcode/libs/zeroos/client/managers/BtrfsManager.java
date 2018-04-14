/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.goodcode.libs.zeroos.client.managers;

import ch.goodcode.libs.zeroos.client.JythonController;
import ch.goodcode.libs.zeroos.client.PythonClientException;
import java.util.Arrays;

/**
 *
 * @author Paolo Domenighetti
 */
public class BtrfsManager extends AbstractManager {

    public BtrfsManager(JythonController PY, String TARGET_ENTITY_VARNAME) {
        super(PY, TARGET_ENTITY_VARNAME);
    }

    public String create(String mydata, String[] devices, String name) throws PythonClientException {
        PY.rawAssign("devices", Arrays.toString(devices));
        PY.rawAssign("res", TARGET_ENTITY_VARNAME + ".btrfs.create('" + mydata + "', devices, '" + name + "', '" + name + "')");
        return PY.rawGet("res");
    }
}
