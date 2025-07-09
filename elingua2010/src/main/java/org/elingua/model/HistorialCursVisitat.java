package org.elingua.model;

/**
 * Entitat HistorialCursVisitat
 * 
 * @author Marina Martin
 */
public class HistorialCursVisitat extends AbstractHistorialCursVisitat
		implements java.io.Serializable {


	/** Constructor per defecte */
	public HistorialCursVisitat() {
	}

	/** Constructor amb totes les propietats */
	public HistorialCursVisitat(Cursos cursos, Usuaris usuaris) {
		super(cursos, usuaris);
	}

}
