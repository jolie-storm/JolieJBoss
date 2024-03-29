package org.jolie.ejb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.jolie.ejb.Types.GreetingsRequest;
import org.jolie.ejb.Types.GreetingsResponse;
import org.jolie.ejb.interfaces.MyServiceInterface;

import jolie.Interpreter;
import jolie.net.CommMessage;
import jolie.net.LocalCommChannel;
import jolie.runtime.FaultException;
import jolie.runtime.Value;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bmasc
 */

@Stateless
public class MyServiceImpl implements MyServiceInterface{
    private Interpreter interpreter;
    public MyServiceImpl (){
    	System.out.println(this.getClass().getProtectionDomain().getCodeSource().getLocation());
        String jh = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath().substring(1)+"/jolie_local_copy/";
        String jolieServiceLocation = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath().substring(1)+"/jolie/";
        String arg[] = {
            "-l",
            "./lib/*;"+ jh+"lib;"+jh+"javaServices\\*;"+ jh + "extensions\\*",
            "-i",
            jh + "/include",
            jolieServiceLocation + "my_service.ol"
        };
        
        try {
        	System.out.println(this.getClass().getClassLoader().toString());
            interpreter = new Interpreter(arg, MyServiceImpl.class.getClassLoader(), null);
            Exception e = interpreter.start().get();
            if ( e != null )
                throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public GreetingsResponse greetings(GreetingsRequest arg0) throws FaultException, IOException, InterruptedException, Exception {
        Value v = Value.create();
        v.setFirstChild( "name", "balint" );
        v.setFirstChild("surname","maschio");
        CommMessage request = CommMessage.createRequest( "greetings", "/", v );
        LocalCommChannel c = interpreter.commCore().getLocalCommChannel();
        c.send( request );
        CommMessage response = c.recvResponseFor( request ).get();
        if ( response.isFault() ) {
            System.out.println("thrown response.fault()");
            throw response.fault();
        }
        GreetingsResponse gres = new GreetingsResponse();
        gres.setGreetings(response.value().getFirstChild( "greetings" ).strValue());
    	return gres;
    }


    
}
