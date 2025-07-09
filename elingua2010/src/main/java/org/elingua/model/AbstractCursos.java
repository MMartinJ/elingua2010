package org.elingua.model;

import java.util.HashSet;
import java.util.Set;

/**
 * La entitat AbstractCursos proporciona la base de la definició de la persistencia de l'entitat Cursos.
 * 
 * @author Marina Martin
 * @see org.elingua.model.Cursos
 */

public abstract class AbstractCursos implements java.io.Serializable {

	/**Propietats de AbstractCursos */

	private Integer idCurs;
	private Idiomes idiomes;
	private Usuaris usuaris;
	private String titol;
	private String contingut;
	private Set historialCursVisitats = new HashSet(0);

	

	/** Constructor per defecte */
	public AbstractCursos() {
	}

	/** Constructor amb les propietats obligatòries */
	public AbstractCursos(Idiomes idiomes, Usuaris usuaris, String titol) {
		this.idiomes = idiomes;
		this.usuaris = usuaris;
		this.titol = titol;
	}

	/** Constructor amb totes les propietats */
	public AbstractCursos(Idiomes idiomes, Usuaris usuaris, String titol,
			String contingut) {
		this.idiomes = idiomes;
		this.usuaris = usuaris;
		this.titol = titol;
		this.contingut = contingut;
		
	}

	/**
	 * Mètode que dona accès a la propietat idCurs.
	 * @return Retorna l'identificador del curs.
	 */

	public Integer getIdCurs() {
		return this.idCurs;
	}
	/**
	 * Mètode que estableix la propietat idCurs.
	 * @param idCurs L'identificador del curs.
	 */
	public void setIdCurs(Integer idCurs) {
		this.idCurs = idCurs;
	}
	/**
	 * Mètode que dona accès a la propietat idiomes.
	 * @return Retorna l'idioma del curs.
	 */
	public Idiomes getIdiomes() {
		return this.idiomes;
	}
	/**
	 * Mètode que estableix la propietat idiomes.
	 * @param idiomes L'idioma del curs.
	 */
	public void setIdiomes(Idiomes idiomes) {
		this.idiomes = idiomes;
	}
	/**
	 * Mètode que dona accès a la propietat usuaris.
	 * @return Retorna un objecte de tipus Usuaris.
	 */
	public Usuaris getUsuaris() {
		return this.usuaris;
	}
	/**
	 * Mètode que estableix la propietat usuaris.
	 * @param usuaris Un objecte de tipus Usuaris.
	 */
	public void setUsuaris(Usuaris usuaris) {
		this.usuaris = usuaris;
	}
	/**
	 * Mètode que dona accès a la propietat titol.
	 * @return Retorna el titol del curs.
	 */
	public String getTitol() {
		return this.titol;
	}
	/**
	 * Mètode que estableix la propietat titol.
	 * @param titol El titol del curs.
	 */
	public void setTitol(String titol) {
		this.titol = titol;
	}
	/**
	 * Mètode que dona accès a la propietat contingut.
	 * @return Retorna el contingut del curs.
	 */
	public String getContingut() {
		return this.contingut;
	}
	/**
	 * Mètode que estableix la propietat contingut.
	 * @param contingut El contingut del curs.
	 */
	public void setContingut(String contingut) {
		this.contingut = contingut;
	}
	/**
	 * Mètode que dona accès a la propietat historialCursVisitats.
	 * @return Retorna el historial dels cursos visitats.
	 */
	public Set getHistorialCursVisitats() {
		return this.historialCursVisitats;
	}
	/**
	 * Mètode que estableix la propietat historialCursVisitats.
	 * @param historialCursVisitats El historial dels cursos visitats.
	 */
	public void setHistorialCursVisitats(Set historialCursVisitats) {
		this.historialCursVisitats = historialCursVisitats;
	}

}