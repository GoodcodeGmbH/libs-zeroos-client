/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.goodcode.libs.zeroos.client;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

/**
 *
 * @author Paolo Domenighetti
 */
public class JythonController {

    private final PythonInterpreter PYTHON = new PythonInterpreter();
    private final String zeroCoreHostAddr;
    private final String password;
    private final int timeout;

    public JythonController(String zeroCoreHostAddr, String password) {
        this.zeroCoreHostAddr = zeroCoreHostAddr;
        this.password = password;
        timeout = 100;
    }

    public void initialize() throws PythonClientException {
        PYTHON.exec("from zeroos.core0.client import Client");
        PYTHON.exec("cl = Client(host='" + zeroCoreHostAddr + "', password='" + password + "')");
        PYTHON.exec("cl.ping()");
        PYTHON.exec("cl.timeout = " + timeout);
    }

    public String rawGet(String var) throws PythonClientException {
        PyObject x = PYTHON.get(var);
        return x.asString();
    }

    public String process(String appendedPythonExecCommand) throws PythonClientException {
        PYTHON.exec("x = cl." + appendedPythonExecCommand);
        PyObject x = PYTHON.get("x");
        return x.asString();
    }

    public String process(String appendedPythonExecCommand, String... execs) throws PythonClientException {
        for (String exec : execs) {
            PYTHON.exec(exec);
        }
        PYTHON.exec("x = cl." + appendedPythonExecCommand);
        PyObject x = PYTHON.get("x");
        return x.asString();
    }

    public String processOnVar(String var, String appendedPythonExecCommand) throws PythonClientException {
        PYTHON.exec("y = " + var + "." + appendedPythonExecCommand);
        PyObject x = PYTHON.get("y");
        return x.asString();
    }

    public String processOnVar(String var, String appendedPythonExecCommand, String... execs) throws PythonClientException {
        for (String exec : execs) {
            PYTHON.exec(exec);
        }
        PYTHON.exec("y = " + var + "." + appendedPythonExecCommand);
        PyObject x = PYTHON.get("y");
        return x.asString();
    }

    public void rawAssign(String var, String expr) throws PythonClientException {
        PYTHON.exec(var + " = " + expr);
    }

    public void dispose() throws PythonClientException {
        // only log
    }
}
