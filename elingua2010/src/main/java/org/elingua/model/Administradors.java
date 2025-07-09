package org.elingua.model;

/**
 * Entitat Administradors.
 * 
 * @author Marina Martin
 */
public class Administradors extends AbstractAdministradors implements
		java.io.Serializable {

	
	/** Constructor per defecte */
	public Administradors() {
	}

	/** Constructor amb totes les propietats */
	public Administradors(Usuaris usuaris) {
		super(usuaris);
	}

}
