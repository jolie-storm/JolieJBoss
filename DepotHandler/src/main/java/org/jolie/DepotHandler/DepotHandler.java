package org.jolie.DepotHandler;

import javax.ejb.Remote;

import org.jolie.DepotHandler.Interfaces.DepotInterface;
import org.jolie.DepotHandler.Types.MaterialDocument;

@Remote
public class DepotHandler implements DepotInterface{

	public String ouputMaterialDocument(MaterialDocument materialDocument) {
		// TODO Auto-generated method stub
		System.out.println(materialDocument.toString());
		return materialDocument.toString();
	}

}
