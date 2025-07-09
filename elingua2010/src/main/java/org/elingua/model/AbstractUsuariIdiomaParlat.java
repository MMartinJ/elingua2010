package org.elingua.model;

/**
 * La entitat AbstractUsuariIdiomaParlat proporciona la base de la definició de la persistencia de l'entitat UsuariIdiomaParlat.
 * 
 * @author Marina Martin
 * @see org.elingua.model.UsuariIdiomaParlat
 */

public abstract class AbstractUsuariIdiomaParlat implements
		java.io.Serializable {

	/**Propietats de AbstractUsuariIdiomaParlat */

	private Integer idUsuariIdiomaParlat;
	private Idiomes idiomes;
	private Usuaris usuaris;

	

	/** Constructor per defecte */
	public AbstractUsuariIdiomaParlat() {
	}

	/** Constructor amb totes les propietats */
	public AbstractUsuariIdiomaParlat(Idiomes idiomes, Usuaris usuaris) {
		this.idiomes = idiomes;
		this.usuaris = usuaris;
	}

	/**
	 * Mètode que dona accès a la propietat idUsuariIdiomaParlat.
	 * @return Retorna l'identificador de l'idioma sap parlar.
	 */

	public Integer getIdUsuariIdiomaParlat() {
		return this.idUsuariIdiomaParlat;
	}
	/**
	 * Mètode que estableix la propietat idUsuariIdiomaParlat.
	 * @param idUsuariIdiomaParlat L'identificador de l'idioma que parla.
	 */
	public void setIdUsuariIdiomaParlat(Integer idUsuariIdiomaParlat) {
		this.idUsuariIdiomaParlat = idUsuariIdiomaParlat;
	}
	/**
	 * Mètode que dona accès a la propietat idiomes.
	 * @return Retorna l'idioma que l'usuari sap parlar.
	 */
	public Idiomes getIdiomes() {
		return this.idiomes;
	}
	/**
	 * Mètode que estableix la propietat idiomes.
	 * @param idiomes L'idioma que l'usuari sap parlar.
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