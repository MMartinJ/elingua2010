package org.elingua.model;

/**
 * Entitat UsuariIdiomaEstudiat.
 * 
 * @author Marina Martin
 */
public class UsuariIdiomaEstudiat extends AbstractUsuariIdiomaEstudiat
		implements java.io.Serializable {


	/** Constructor per defecte */
	public UsuariIdiomaEstudiat() {
	}

	/** Constructor amb totes les propietats */
	public UsuariIdiomaEstudiat(Idiomes idiomes, Usuaris usuaris) {
		super(idiomes, usuaris);
	}

}
