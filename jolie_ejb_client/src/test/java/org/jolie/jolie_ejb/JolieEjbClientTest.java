package org.jolie.jolie_ejb;

import org.junit.jupiter.api.Test;

import jolie.runtime.Value;

public class JolieEjbClientTest {
	
    @Test
    public void testOutputMaterialDocument() {
        JolieEjbClient jec = new JolieEjbClient();
        Value v = Value.create();
    	jec.ouputMaterialDocument(v);
    }
}
