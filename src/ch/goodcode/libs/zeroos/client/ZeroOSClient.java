/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.goodcode.libs.zeroos.client;

import ch.goodcode.libs.logging.LogBuffer;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

/**
 *
 * @author Paolo Domenighetti
 */
public final class ZeroOSClient {

    private final PythonInterpreter PYTHON = new PythonInterpreter();
    private final String zeroCoreHostAddr;
    private final String password;
    private final LogBuffer LOG;

    public ZeroOSClient(LogBuffer log, String zeroCoreHostAddr, String password) {
        this.zeroCoreHostAddr = zeroCoreHostAddr;
        this.password = password;
        this.LOG = log;
    }

    public void start() {
        PYTHON.exec("from zeroos.core0.client import Client");
        PYTHON.exec("cl = Client(host='" + zeroCoreHostAddr + "', password='" + password + "')");
    }

    private String process(String appendedPythonExecCommand) {
        PYTHON.exec("x = cl." + appendedPythonExecCommand);
        PyObject x = PYTHON.get("x");
        return x.asString();
    }

    public void stop() {

    }

    // ====================================================================================================================
    // ====================================================================================================================
    // Client Managers Wrap APIs
    
    /**
     *
     * @param arg
     * @return
     */
    public String system(String arg) {
        return process("system('" + arg + "').get()");
    }

    /**
     *
     * @param action
     * @return
     */
    public String disk(String action) {
        return process("disk." + action + "()");
    }


    // ====================================================================================================================
    // ====================================================================================================================
    // Client methods Wrap APIs
    
//    public String bash(String action) {
//        return process("disk." + action + "()");
//    }
//
//    public String subscribe(String action) {
//        return process("disk." + action + "()");
//    }

    // ====================================================================================================================
    // ====================================================================================================================
    public static void main(String[] args) {
        //test1();
    }

    private static void test1() {
        PythonInterpreter interp = new PythonInterpreter();
        interp.exec("import sys");
        interp.exec("print sys");
        interp.set("a", new PyInteger(42));
        interp.exec("print a");
        interp.exec("x = 2+2");
        PyObject x = interp.get("x");
        System.out.println("x: " + x);
    }

    private static void test2() {
        LogBuffer log = new LogBuffer("test-log", "C:\\temp", 0, 99);
        ZeroOSClient o = new ZeroOSClient(log, "", "");
        o.start();

        o.stop();
    }
}
