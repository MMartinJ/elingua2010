package org.elingua.model;

import java.util.Date;

/**
 * La entitat AbstractCollaboradors proporciona la base de la definició de la persistencia de l'entitat Collaboradors.
 * 
 * @author Marina Martin
 * @see org.elingua.model.Collaboradors
 */

public abstract class AbstractCollaboradors implements java.io.Serializable {

	/**Propietats de AbstractCollaboradors */

	private Integer idCollaborador;
	private Usuaris usuaris;
	private String nom;
	private String cognom1;
	private String cognom2;
	private String sexe;
	private Date dataNaix;
	private String email;


	/** Constructor per defecte */
	public AbstractCollaboradors() {
	}

	/** Constructor amb les propietats obligatòries */
	public AbstractCollaboradors(Usuaris usuaris, String nom, String cognom1,
			String cognom2, String sexe, String email) {
		this.usuaris = usuaris;
		this.nom = nom;
		this.cognom1 = cognom1;
		this.cognom2 = cognom2;
		this.sexe = sexe;
		this.email = email;
	}

	/** Constructor amb totes les propietats */
	public AbstractCollaboradors(Usuaris usuaris, String nom, String cognom1,
			String cognom2, String sexe, Date dataNaix, String email) {
		this.usuaris = usuaris;
		this.nom = nom;
		this.cognom1 = cognom1;
		this.cognom2 = cognom2;
		this.sexe = sexe;
		this.dataNaix = dataNaix;
		this.email = email;
	}

	/**
	 *  Mètode que dona accès a la propietat idCollaborador.
	 * @return Retorna l'dentificador únic de l'usuari col·laborador.
	 */

	public Integer getIdCollaborador() {
		return this.idCollaborador;
	}
	/**
	 * Mètode que estableix la propietat idCollaborador.
	 * @param idCollaborador L'identificador únic de l'usuari col·laborador.
	 */
	public void setIdCollaborador(Integer idCollaborador) {
		this.idCollaborador = idCollaborador;
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
	 * Mètode que dona accès a la propietat nom.
	 * @return Retorna el nom de l'usuari col·laborador.
	 */
	public String getNom() {
		return this.nom;
	}
	/**
	 * Mètode que estableix la propietat nom.
	 * @param nom El nom de l'usuari col·laborador.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * Mètode que dona accès a la propietat cognom1.
	 * @return Retorna el primer cognom de l'usuari col·laborador.
	 */
	public String getCognom1() {
		return this.cognom1;
	}
	/**
	 * Mètode que estableix la propietat cognom1.
	 * @param cognom1 El primer cognom de l'usuari col·laborador.
	 */
	public void setCognom1(String cognom1) {
		this.cognom1 = cognom1;
	}
	/**
	 * Mètode que dona accès a la propietat cognom2.
	 * @return Retorna el segon cognom de l'usuari col·laborador.
	 */
	public String getCognom2() {
		return this.cognom2;
	}
	/**
	 * Mètode que estableix la propietat cognom2.
	 * @param cognom2 El segon cognom de l'usuari col·laborador.
	 */
	public void setCognom2(String cognom2) {
		this.cognom2 = cognom2;
	}
	/**
	 * Mètode que dona accès a la propietat sexe.
	 * @return Retorna el sexe de l'usuari col·laborador.
	 */
	public String getSexe() {
		return this.sexe;
	}
	/**
	 * Mètode que estableix la propietat sexe.
	 * @param sexe El sexe de l'usuari col·laborador.
	 */
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	/**
	 * Mètode que dona accès a la propietat dataNaix.
	 * @return Retorna la data de naixement de l'usuari col·laborador.
	 */
	public Date getDataNaix() {
		return this.dataNaix;
	}
	/**
	 * Mètode que estableix la propietat dataNaix.
	 * @param dataNaix La data de naixement de l'usuari col·laborador.
	 */
	public void setDataNaix(Date dataNaix) {
		this.dataNaix = dataNaix;
	}
	/**
	 * Mètode que dona accès a la propietat email.
	 * @return Retorna el correu de l'usuari col·laborador.
	 */
	public String getEmail() {
		return this.email;
	}
	/**
	 * Mètode que estableix la propietat email.
	 * @param email El correu de l'usuari col·laborador.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}