package org.elingua.model;

import java.util.Date;

/**
 * Entitat Col·laboradors.
 * 
 * @author Marina Martin
 */
public class Collaboradors extends AbstractCollaboradors implements
		java.io.Serializable {


	/** Constructor per defecte */
	public Collaboradors() {
	}

	/** Constructor amb les propietats obligatòries */
	public Collaboradors(Usuaris usuaris, String nom, String cognom1,
			String cognom2, String sexe, String email) {
		super(usuaris, nom, cognom1, cognom2, sexe, email);
	}

	/** Constructor amb totes les propietats */
	public Collaboradors(Usuaris usuaris, String nom, String cognom1,
			String cognom2, String sexe, Date dataNaix, String email) {
		super(usuaris, nom, cognom1, cognom2, sexe, dataNaix, email);
	}

}
