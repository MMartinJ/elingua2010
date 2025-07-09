package org.elingua.model;

/**
 * La entitat AbstractAdministradors proporciona la base de la definició de la persistencia de l'entitat Administradors.
 * 
 * @author Marina Martin
 * @see org.elingua.model.Administradors
 */

public abstract class AbstractAdministradors implements java.io.Serializable {

	/**Propietats de AbstractAdministradors */

	private Integer idAdministrador;
	private Usuaris usuaris;

	

	/** Constructor per defecte */
	public AbstractAdministradors() {
	}

	/** Constructor amb totes les propietats */
	public AbstractAdministradors(Usuaris usuaris) {
		this.usuaris = usuaris;
	}

	/**
	 * Mètode que dona accès a la propietat idAdministrador.
	 * @return Retorna l'identificador de l'administrador.
	 */

	public Integer getIdAdministrador() {
		return this.idAdministrador;
	}
	/**
	 * Mètode que estableix la propietat idAdministrador.
	 * @param idAdministrador L'identificador de l'administrador.
	 */
	public void setIdAdministrador(Integer idAdministrador) {
		this.idAdministrador = idAdministrador;
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