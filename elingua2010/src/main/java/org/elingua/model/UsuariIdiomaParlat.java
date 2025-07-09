package org.elingua.model;

/**
 * Entitat UsuariIdiomaParlat.
 * 
 * @author Marina Martin
 */
public class UsuariIdiomaParlat extends AbstractUsuariIdiomaParlat implements
		java.io.Serializable {


	/** Constructor per defecte */
	public UsuariIdiomaParlat() {
	}

	/** Constructor amb totes les propietats */
	public UsuariIdiomaParlat(Idiomes idiomes, Usuaris usuaris) {
		super(idiomes, usuaris);
	}

}
