package org.jolie.jolie_ejb;

import org.junit.jupiter.api.Test;

import jolie.runtime.Value;

public class JolieEjbClientTest {
	
    @Test
    public void testOutputMaterialDocument() {
        JolieEjbClient jec = new JolieEjbClient();
        Value v = Value.create();
        v.getFirstChild("address").getFirstChild("street").add(Value.create("Washinton St"));
        v.getFirstChild("address").getFirstChild("streetNumber").add(Value.create("42"));
        v.getFirstChild("address").getFirstChild("zipCode").add(Value.create("AA353"));
        v.getFirstChild("deliveryName").add(Value.create("John Smith"));
    	jec.ouputMaterialDocument(v);
    }
}
