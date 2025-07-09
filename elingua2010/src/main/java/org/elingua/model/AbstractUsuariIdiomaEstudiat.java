package org.elingua.model;

/**
 * La entitat AbstractUsuariIdiomaEstudiat proporciona la base de la definició de la persistencia de l'entitat UsuariIdiomaEstudiat.
 * 
 * @author Marina Martin
 * @see org.elingua.model.UsuariIdiomaEstudiat
 */

public abstract class AbstractUsuariIdiomaEstudiat implements
		java.io.Serializable {

	/**Propietats de AbstractUsuariIdiomaEstudiat */

	private Integer idUsuariIdiomaEstudiat;
	private Idiomes idiomes;
	private Usuaris usuaris;

	

	/** Constructor per defecte */
	public AbstractUsuariIdiomaEstudiat() {
	}

	/** Constructor amb totes les propietats */
	public AbstractUsuariIdiomaEstudiat(Idiomes idiomes, Usuaris usuaris) {
		this.idiomes = idiomes;
		this.usuaris = usuaris;
	}

	/**
	 * Mètode que dona accès a la propietat idUsuariIdiomaEstudiat.
	 * @return Retorna l'identificador de l'idioma que està estudiant.
	 */

	public Integer getIdUsuariIdiomaEstudiat() {
		return this.idUsuariIdiomaEstudiat;
	}
	/**
	 * Mètode que estableix la propietat idUsuariIdiomaEstudiat.
	 * @param idUsuariIdiomaEstudiat L'identificador de l'idioma que està estudiant.
	 */
	public void setIdUsuariIdiomaEstudiat(Integer idUsuariIdiomaEstudiat) {
		this.idUsuariIdiomaEstudiat = idUsuariIdiomaEstudiat;
	}
	/**
	 * Mètode que dona accès a la propietat idiomes.
	 * @return Retorna l'idioma que l'usuari està estudiant.
	 */
	public Idiomes getIdiomes() {
		return this.idiomes;
	}
	/**
	 * Mètode que estableix la propietat idiomes.
	 * @param idiomes L'idioma que l'usuari està estudiant.
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

}