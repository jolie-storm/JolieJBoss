package org.jolie.DepotHandler.Interfaces;

import javax.ejb.Remote;

import org.jolie.DepotHandler.Types.MaterialDocument;

@Remote
public interface DepotInterface {
   public String ouputMaterialDocument(MaterialDocument materialDocument);
}
