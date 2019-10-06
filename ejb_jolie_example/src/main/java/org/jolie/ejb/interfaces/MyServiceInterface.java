/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jolie.ejb.interfaces;

import java.io.IOException;

import javax.ejb.Local;
import javax.ejb.Remote;

import org.jolie.ejb.Types.GreetingsRequest;
import org.jolie.ejb.Types.GreetingsResponse;

import jolie.runtime.FaultException;

/**
 *
 * @author bmasc
 */

@Remote
public interface MyServiceInterface {
    public GreetingsResponse greetings(GreetingsRequest request) throws FaultException, IOException, InterruptedException, Exception;
}
