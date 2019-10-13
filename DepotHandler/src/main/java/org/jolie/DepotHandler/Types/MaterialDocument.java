package org.jolie.DepotHandler.Types;

public class MaterialDocument implements java.io.Serializable {
	String deliveryName;
	DeliveryAddress deliveryAddress;
    
	
	public void deliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.deliveryName).append("\n");
        return sb.toString();

	}
}
