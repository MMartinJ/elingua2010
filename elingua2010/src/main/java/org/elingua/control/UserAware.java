package org.elingua.control;

import org.elingua.model.Sessio;


/**
 * Interfície per a les accions que poden tenir injectat un usuari. 
 * @author Marina Martin
 * @version 1.0
 */

public interface UserAware {
	
	public void setUser( Sessio usuari );
	
}