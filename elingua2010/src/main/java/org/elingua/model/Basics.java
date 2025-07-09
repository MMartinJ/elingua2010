package org.elingua.model;

import java.util.Date;

/**
 * Entitat Basics.
 * 
 * @author Marina Martin
 */
public class Basics extends AbstractBasics implements java.io.Serializable {

	

	/** Constructor per defecte */
	public Basics() {
	}

	/** Constructor amb les propietats obligatòries */
	public Basics(Usuaris usuaris, String nom, String cognom1, String cognom2,
			String sexe, String email) {
		super(usuaris, nom, cognom1, cognom2, sexe, email);
	}

	/** Constructor amb totes les propietats */
	public Basics(Usuaris usuaris, String nom, String cognom1, String cognom2,
			String sexe, Date dataNaix, String email) {
		super(usuaris, nom, cognom1, cognom2, sexe, dataNaix, email);
	}

}
