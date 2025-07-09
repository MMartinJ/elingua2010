package org.elingua.model;

import java.util.Set;

/**
 * Cursos entity. @author MyEclipse Persistence Tools
 */
public class Cursos extends AbstractCursos implements java.io.Serializable {


	/** Constructor per defecte */
	public Cursos() {
	}

	/** Constructor amb les propietats obligatòries */
	public Cursos(Idiomes idiomes, Usuaris usuaris, String titol) {
		super(idiomes, usuaris, titol);
	}

	/** Constructor amb totes les propietats */
	public Cursos(Idiomes idiomes, Usuaris usuaris, String titol,
			String contingut) {
		super(idiomes, usuaris, titol, contingut);
	}

}
