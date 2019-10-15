package org.jolie.DepotHandler.Types;

public class MaterialDocument implements java.io.Serializable {
	String deliveryName;
	DeliveryAddress deliveryAddress;
    
	
	public void deliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	
	public void DeliveryAddress (DeliveryAddress deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.deliveryName).append("\n").append(this.deliveryAddress.toString()).append("\n");
        return sb.toString();

	}
}
