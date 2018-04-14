/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.goodcode.libs.zeroos.client;

import ch.goodcode.libs.logging.LogBuffer;
import ch.goodcode.libs.zeroos.client.model.ZeroOSNode;
import ch.goodcode.libs.zeroos.client.model.NodesTopology;
import java.util.HashMap;

/**
 *
 * @author Paolo Domenighetti
 */
public class ZeroOSNodeController implements Runnable {
    
    private boolean on = true;
    private final LogBuffer LOG;

    public ZeroOSNodeController(LogBuffer LOG) {
        this.LOG = LOG;
    }
    
    /*
    
    */
    private final HashMap<String, ZeroOSNode> MAIN_NODES = new HashMap<>();
    
    /*
    
    */
    private final HashMap<String, NodesTopology> TOPOLOGIES = new HashMap<>();
    
//      public static void main(String[] args) {
//        //test1();
//    }
//
//    private static void test1() {
//        PythonInterpreter interp = new PythonInterpreter();
//        interp.exec("import sys");
//        interp.exec("print sys");
//        interp.set("a", new PyInteger(42));
//        interp.exec("print a");
//        interp.exec("x = 2+2");
//        PyObject x = interp.get("x");
//        System.out.println("x: " + x);
//    }
//
//    private static void test2() {
//        LogBuffer log = new LogBuffer("test-log", "C:\\temp", 0, 99);
//        ZeroOSNode o = new ZeroOSNode("test-node", log, "", "");
//        o.prepare();
//    }

    @Override
    public void run() {
        while(on) {
            
        }
    }
    
    public void shutdown() {
        on = false;
    }
}
