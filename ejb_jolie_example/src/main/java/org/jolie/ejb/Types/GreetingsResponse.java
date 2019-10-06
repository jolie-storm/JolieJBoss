package org.jolie.ejb.Types;
import java.util.List;
import java.util.ArrayList;
import java.util.Map.Entry;

public class GreetingsResponse implements java.io.Serializable {
	private String greetings;


	public String getGreetings(){
		return greetings;
	}

	public void setGreetings( String value ){
		greetings = value;
	}

}
