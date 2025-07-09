package org.elingua.model;

import java.util.Set;

/**
 * Entitat Usuaris.
 * 
 * @author Marina Martin
 */
public class Usuaris extends AbstractUsuaris implements java.io.Serializable {


	/** Constructor per defecte */
	public Usuaris() {
	}

	/** Constructor amb les propietats obligatòries */
	public Usuaris(String nomUsuari, String psswd, String tipus) {
		super(nomUsuari, psswd, tipus);
	}

	/** Constructor amb totes les propietats */
	public Usuaris(String nomUsuari, String psswd, String tipus,
			Boolean privacitat, Set usuariIdiomaEstudiats,
			Set missatgesesForReceptor, Set cursoses, Set collaboradorses,
			Set missatgesesForEmissor, Set administradorses,
			Set usuariIdiomaParlats, Set estadistiqueses, Set basicses,
			Set historialCursVisitats) {
		super(nomUsuari, psswd, tipus, privacitat, usuariIdiomaEstudiats,
				missatgesesForReceptor, cursoses, collaboradorses,
				missatgesesForEmissor, administradorses, usuariIdiomaParlats,
				estadistiqueses, basicses, historialCursVisitats);
	}

}
