package org.jolie.DepotHandler.Types;

public class DeliveryAddress implements java.io.Serializable {
  String street ;
  String streetNumber;
  String zipCode;
  
  public void street (String street) {
	  this.street = street;
  }
  public void streetNumber(String streetNumber) {
	  this.streetNumber = streetNumber;
  }
  
  public void zipCode(String zipCode) {
	  this.zipCode = zipCode;
  }
  
  @Override
  public String toString() {
	  StringBuilder sb = new StringBuilder();
	  sb.append(this.street).append("\n").append(this.streetNumber).append("\n").append(this.zipCode);
	  return sb.toString();
  }
}
