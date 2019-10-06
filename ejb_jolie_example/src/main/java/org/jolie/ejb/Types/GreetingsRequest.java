/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jolie.ejb.Types;

/**
 *
 * @author bmasc
 */
public class GreetingsRequest implements java.io.Serializable {
    	private String surname;
	private String name;
        
        public void surname(String value){
           this.surname = value;
        }
        
        public void name (String value){
           this.name = value;
        }
}
