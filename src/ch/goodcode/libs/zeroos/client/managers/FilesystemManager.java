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
public class FilesystemManager extends AbstractManager {
    
    public FilesystemManager(JythonController PY, String TARGET_ENTITY_VARNAME) {
        super(PY, TARGET_ENTITY_VARNAME);
    }
    
    public String list(String path) {
        if(path == null) {
            path = "/";
        }
        PY.rawAssign("res", TARGET_ENTITY_VARNAME+".filesystem.list('"+path+"')");
        return PY.rawGet("res");
    }
    
    public String mkdir(String path) {
        PY.rawAssign("res", TARGET_ENTITY_VARNAME+".filesystem.mkdir('"+path+"')");
        return PY.rawGet("res");
    }
    
    public String upload_file(String remotePath, String myPath) {
        PY.rawAssign("res", TARGET_ENTITY_VARNAME+".filesystem.upload_file('"+remotePath+"','"+myPath+"')");
        return PY.rawGet("res");
    }
}
