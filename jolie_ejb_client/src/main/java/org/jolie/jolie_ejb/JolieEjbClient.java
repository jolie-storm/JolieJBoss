
package org.jolie.jolie_ejb;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jolie.DepotHandler.DepotHandler;
import org.jolie.DepotHandler.Interfaces.DepotInterface;
import org.jolie.DepotHandler.Types.MaterialDocument;
import org.wildfly.naming.client.WildFlyInitialContextFactory;

import jolie.runtime.JavaService;
import jolie.runtime.Value;
import jolie.runtime.embedding.RequestResponse;

public class JolieEjbClient extends JavaService{
	
	@RequestResponse
	
	public Value ouputMaterialDocument ( Value request) {
		Value returnValue = Value.create();
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, WildFlyInitialContextFactory.class.getName());
		properties.put(Context.PROVIDER_URL, "remote+http://localhost:8080");
		properties.put(Context.SECURITY_PRINCIPAL, "admin");
		properties.put(Context.SECURITY_CREDENTIALS, "admin123");
		properties.put("jboss.naming.client.ejb.context", true);
        InitialContext ctx;
		try {
			ctx = new InitialContext(properties);
			ctx.
			DepotInterface depotHandler = (DepotInterface) ctx.lookup("ejb:ear-jolie-example-ear-test-jolie/DepotHandler-0.0.1/DepotHandler!org.jolie.DepotHandler.Interfaces.DepotInterface");
		    MaterialDocument md = new MaterialDocument();
		    md.deliveryName("Balint");
			depotHandler.ouputMaterialDocument(md);
		} catch (NamingException e) {
			e.printStackTrace();
		}
      
        
		return returnValue;
	}
	

}
