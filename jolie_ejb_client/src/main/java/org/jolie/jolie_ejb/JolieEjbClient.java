
package org.jolie.jolie_ejb;


import java.util.Properties;


import javax.naming.Context;
import javax.naming.InitialContext;

import org.jolie.DepotHandler.Interfaces.DepotInterface;
import org.jolie.DepotHandler.Types.DeliveryAddress;
import org.jolie.DepotHandler.Types.MaterialDocument;

import jolie.runtime.CanUseJars;
import jolie.runtime.JavaService;
import jolie.runtime.Value;
import jolie.runtime.embedding.RequestResponse;


@CanUseJars({"DepotHandler.jar", 
			"wildfly-naming-client.jar",
			"wildfly-elytron.jar"} )

public class JolieEjbClient extends JavaService {

	@RequestResponse

	public Value ouputMaterialDocument(Value request) {
		Value returnValue = Value.create() ;
        Properties env = new Properties();  
        env.put(Context.INITIAL_CONTEXT_FACTORY, org.wildfly.naming.client.WildFlyInitialContextFactory.class.getName());  
        env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080"); 
        InitialContext ctx;

		
		try {
			ctx = new InitialContext(env);
			DepotInterface depotHandler = (DepotInterface)ctx.lookup("ejb:ear-jolie-example-ear-test-jolie/DepotHandler-0.0.1/DepotHandler!org.jolie.DepotHandler.Interfaces.DepotInterface");
			MaterialDocument md = new MaterialDocument();
			DeliveryAddress da = new DeliveryAddress();
			da.street(request.getFirstChild("address").getFirstChild("street").strValue());
			da.streetNumber(request.getFirstChild("address").getFirstChild("streetNumber").strValue());
			da.zipCode(request.getFirstChild("address").getFirstChild("zipCode").strValue());
			md.deliveryName(request.getFirstChild("deliveryName").strValue());
			md.DeliveryAddress(da);
			returnValue.add(Value.create(depotHandler.ouputMaterialDocument(md)));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnValue;
	}

}
