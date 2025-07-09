package org.elingua.model;

import java.util.HashSet;
import java.util.Set;

/**
 * La entitat AbstractIdiomes proporciona la base de la definició de la persistencia de l'entitat Idiomes.
 * 
 * @author Marina Martin
 * @see org.elingua.model.Idiomes
 */

public abstract class AbstractIdiomes implements java.io.Serializable {

	/**Propietats de AbstractIdiomes */

	private Integer idIdioma;
	private String nom;
	private Set usuariIdiomaParlats = new HashSet(0);
	private Set cursoses = new HashSet(0);
	private Set usuariIdiomaEstudiats = new HashSet(0);



	/** Constructor per defecte */
	public AbstractIdiomes() {
	}

	/** Constructor amb les propietats obligatòries */
	public AbstractIdiomes(String nom) {
		this.nom = nom;
	}

	/** Constructor amb totes les propietats */
	public AbstractIdiomes(String nom, Set usuariIdiomaParlats, Set cursoses,
			Set usuariIdiomaEstudiats) {
		this.nom = nom;
		this.usuariIdiomaParlats = usuariIdiomaParlats;
		this.cursoses = cursoses;
		this.usuariIdiomaEstudiats = usuariIdiomaEstudiats;
	}

	/**
	 * Mètode que dona accès a la propietat idIdioma.
	 * @return Retorna l'identificador de l'idioma.
	 */

	public Integer getIdIdioma() {
		return this.idIdioma;
	}
	/**
	 * Mètode que estableix la propietat idIdioma.
	 * @param idIdioma L'identificador de l'idioma.
	 */
	public void setIdIdioma(Integer idIdioma) {
		this.idIdioma = idIdioma;
	}
	/**
	 * Mètode que dona accès a la propietat nom.
	 * @return Retorna el nom de l'idioma.
	 */
	public String getNom() {
		return this.nom;
	}
	/**
	 * Mètode que estableix la propietat nom.
	 * @param nom El nom de l'idioma.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * Mètode que dona accès a la propietat usuariIdiomaParlats.
	 * @return Retorna la llista d'idiomes que l'usuari parla.
	 */
	public Set getUsuariIdiomaParlats() {
		return this.usuariIdiomaParlats;
	}
	/**
	 * Mètode que estableix la propietat usuariIdiomaParlats.
	 * @param usuariIdiomaParlats LLista d'idiomes que l'usuari parla. 
	 */
	public void setUsuariIdiomaParlats(Set usuariIdiomaParlats) {
		this.usuariIdiomaParlats = usuariIdiomaParlats;
	}
	/**
	 * Mètode que dona accès a la propietat cursoses.
	 * @return Retorna una llista de cursos del mateix idioma.
	 */
	public Set getCursoses() {
		return this.cursoses;
	}
	/**
	 * Mètode que estableix la propietat cursoses.
	 * @param cursoses La llista de cursos del mateix idioma.
	 */
	public void setCursoses(Set cursoses) {
		this.cursoses = cursoses;
	}
	/**
	 * Mètode que dona accès a la propietat usuariIdiomaEstudiats.
	 * @return Retorna una llista d'idiomes que l'usuari estudia.
	 */
	public Set getUsuariIdiomaEstudiats() {
		return this.usuariIdiomaEstudiats;
	}
	/**
	 * Mètode que estableix la propietat usuariIdiomaEstudiats.
	 * @param usuariIdiomaEstudiats La llista d'idiomes que l'usuari estudia.
	 */
	public void setUsuariIdiomaEstudiats(Set usuariIdiomaEstudiats) {
		this.usuariIdiomaEstudiats = usuariIdiomaEstudiats;
	}

}