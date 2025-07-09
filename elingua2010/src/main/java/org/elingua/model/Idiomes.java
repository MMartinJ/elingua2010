package org.elingua.model;

import java.util.Set;

/**
 * Entitat Idiomes.
 * @author Marina Martin
 */
public class Idiomes extends AbstractIdiomes implements java.io.Serializable {


	/** Constructor per defecte */
	public Idiomes() {
	}

	/** Constructor amb les propietats obligatòries */
	public Idiomes(String nom) {
		super(nom);
	}

	/** Constructor amb totes les propietats */
	public Idiomes(String nom, Set usuariIdiomaParlats, Set cursoses,
			Set usuariIdiomaEstudiats) {
		super(nom, usuariIdiomaParlats, cursoses, usuariIdiomaEstudiats);
	}

}
