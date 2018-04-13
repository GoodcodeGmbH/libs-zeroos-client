/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.goodcode.libs.zeroos.client.managers;

import ch.goodcode.libs.logging.LogBuffer;
import ch.goodcode.libs.zeroos.client.ZeroOSClient;

/**
 *
 * @author Paolo Domenighetti
 */
public abstract class AbstractClientWrap {
    
    protected final LogBuffer log;
    protected final ZeroOSClient backref;

    public AbstractClientWrap(LogBuffer log, ZeroOSClient backref) {
        this.log = log;
        this.backref = backref;
    }
    
}
