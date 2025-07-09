package org.elingua.model;

import java.util.HashSet;
import java.util.Set;

/**
 * La entitat AbstractUsuaris proporciona la base de la definició de la persistencia de l'entitat Usuaris.
 * 
 * @author Marina Martin
 * @see org.elingua.model.Usuaris
 */

public abstract class AbstractUsuaris implements java.io.Serializable {

	/**Propietats de AbstractUsuaris */

	private Integer idUsuari;
	private String nomUsuari;
	private String psswd;
	private String tipus;
	private Boolean privacitat;
	private Set usuariIdiomaEstudiats = new HashSet(0);
	private Set missatgesesForReceptor = new HashSet(0);
	private Set cursoses = new HashSet(0);
	private Set collaboradorses = new HashSet(0);
	private Set missatgesesForEmissor = new HashSet(0);
	private Set administradorses = new HashSet(0);
	private Set usuariIdiomaParlats = new HashSet(0);
	private Set estadistiqueses = new HashSet(0);
	private Set basicses = new HashSet(0);
	private Set historialCursVisitats = new HashSet(0);

	
	/** Constructor per defecte */
	public AbstractUsuaris() {
	}

	/** Constructor amb les propietats obligatòries */
	public AbstractUsuaris(String nomUsuari, String psswd, String tipus) {
		this.nomUsuari = nomUsuari;
		this.psswd = psswd;
		this.tipus = tipus;
	}

	/** Constructor amb totes les propietats */
	public AbstractUsuaris(String nomUsuari, String psswd, String tipus,
			Boolean privacitat, Set usuariIdiomaEstudiats,
			Set missatgesesForReceptor, Set cursoses, Set collaboradorses,
			Set missatgesesForEmissor, Set administradorses,
			Set usuariIdiomaParlats, Set estadistiqueses, Set basicses,
			Set historialCursVisitats) {
		this.nomUsuari = nomUsuari;
		this.psswd = psswd;
		this.tipus = tipus;
		this.privacitat = privacitat;
		this.usuariIdiomaEstudiats = usuariIdiomaEstudiats;
		this.missatgesesForReceptor = missatgesesForReceptor;
		this.cursoses = cursoses;
		this.collaboradorses = collaboradorses;
		this.missatgesesForEmissor = missatgesesForEmissor;
		this.administradorses = administradorses;
		this.usuariIdiomaParlats = usuariIdiomaParlats;
		this.estadistiqueses = estadistiqueses;
		this.basicses = basicses;
		this.historialCursVisitats = historialCursVisitats;
	}

	/**
	 * Mètode que dona accès a la propietat idUsuari.
	 * @return Retorna l'identificador de l'usuari.
	 */

	public Integer getIdUsuari() {
		return this.idUsuari;
	}
	/**
	 * Mètode que estableix la propietat idUsuari.
	 * @param idUsuari L'identificador de l'usuari.
	 */
	public void setIdUsuari(Integer idUsuari) {
		this.idUsuari = idUsuari;
	}
	/**
	 * Mètode que dona accès a la propietat nomUsuari.
	 * @return Retorna el nom de l'usuari.
	 */
	public String getNomUsuari() {
		return this.nomUsuari;
	}
	/**
	 * Mètode que estableix la propietat nomUsuari.
	 * @param nomUsuari El nom de l'usuari.
	 */
	public void setNomUsuari(String nomUsuari) {
		this.nomUsuari = nomUsuari;
	}
	/**
	 * Mètode que dona accès a la propietat psswd.
	 * @return Retorna la contrasenya de l'usuari.
	 */
	public String getPsswd() {
		return this.psswd;
	}
	/**
	 * Mètode que estableix la propietat psswd.
	 * @param psswd La contrasenya de l'usuari.
	 */
	public void setPsswd(String psswd) {
		this.psswd = psswd;
	}
	/**
	 * Mètode que dona accès a la propietat tipus.
	 * @return Retorna el tipus d'usuari.
	 */
	public String getTipus() {
		return this.tipus;
	}
	/**
	 * Mètode que estableix la propietat tipus.
	 * @param tipus El tipus d'usuari.
	 */
	public void setTipus(String tipus) {
		this.tipus = tipus;
	}
	/**
	 * Mètode que dona accès a la propietat privacitat.
	 * @return Retorna la privacitat de l'usuari.
	 */
	public Boolean getPrivacitat() {
		return this.privacitat;
	}
	/**
	 * Mètode que estableix la propietat privacitat.
	 * @param privacitat La privacitat de l'usuari.
	 */
	public void setPrivacitat(Boolean privacitat) {
		this.privacitat = privacitat;
	}
	/**
	 * Mètode que dona accès a la propietat usuariIdiomaEstudiats.
	 * @return Retorna els idiomes estudiats per l'usuari.
	 */
	public Set getUsuariIdiomaEstudiats() {
		return this.usuariIdiomaEstudiats;
	}
	/**
	 * Mètode que estableix la propietat usuariIdiomaEstudiats.
	 * @param usuariIdiomaEstudiats Els idiomes estudiats per l'usuari.
	 */
	public void setUsuariIdiomaEstudiats(Set usuariIdiomaEstudiats) {
		this.usuariIdiomaEstudiats = usuariIdiomaEstudiats;
	}
	/**
	 * Mètode que dona accès a la propietat missatgesesForReceptor.
	 * @return Retorna una llista de missatges per al receptor.
	 */
	public Set getMissatgesesForReceptor() {
		return this.missatgesesForReceptor;
	}
	/**
	 * Mètode que estableix la propietat missatgesesForReceptor.
	 * @param missatgesesForReceptor Llista de missatges per al receptor.
	 */
	public void setMissatgesesForReceptor(Set missatgesesForReceptor) {
		this.missatgesesForReceptor = missatgesesForReceptor;
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
	 * Mètode que dona accès a la propietat collaboradorses.
	 * @return Retorna una llista de col·laboradors.
	 */
	public Set getCollaboradorses() {
		return this.collaboradorses;
	}
	/**
	 * Mètode que estableix la propietat collaboradorses.
	 * @param collaboradorses Llista de col·laboradors.
	 */
	public void setCollaboradorses(Set collaboradorses) {
		this.collaboradorses = collaboradorses;
	}
	/**
	 * Mètode que dona accès a la propietat missatgesesForEmissor.
	 * @return Retorna una llista de missatges de l'emissor.
	 */
	public Set getMissatgesesForEmissor() {
		return this.missatgesesForEmissor;
	}
	/**
	 * Mètode que estableix la propietat missatgesesForEmissor.
	 * @param missatgesesForEmissor Una llista de missatges de l'emissor.
	 */
	public void setMissatgesesForEmissor(Set missatgesesForEmissor) {
		this.missatgesesForEmissor = missatgesesForEmissor;
	}
	/**
	 * Mètode que dona accès a la propietat administradorses.
	 * @return Retorna una llista d'administradors.
	 */
	public Set getAdministradorses() {
		return this.administradorses;
	}
	/**
	 * Mètode que estableix la propietat administradorses.
	 * @param administradorses Una llista d'administradors.
	 */
	public void setAdministradorses(Set administradorses) {
		this.administradorses = administradorses;
	}
	/**
	 * Mètode que dona accès a la propietat usuariIdiomaParlats.
	 * @return Retorna una llista d'idiomes parlats per l'usuari.
	 */
	public Set getUsuariIdiomaParlats() {
		return this.usuariIdiomaParlats;
	}
	/**
	 * Mètode que estableix la propietat usuariIdiomaParlats.
	 * @param usuariIdiomaParlats La llista d'idiomes parlats per l'usuari.
	 */
	public void setUsuariIdiomaParlats(Set usuariIdiomaParlats) {
		this.usuariIdiomaParlats = usuariIdiomaParlats;
	}
	/**
	 * Mètode que dona accès a la propietat estadistiqueses.
	 * @return Retorna una llista d'estadistiques de l'usuari.
	 */
	public Set getEstadistiqueses() {
		return this.estadistiqueses;
	}
	/**
	 * Mètode que estableix la propietat estadistiqueses.
	 * @param estadistiqueses Una llista d'estadistiques de l'usuari.
	 */
	public void setEstadistiqueses(Set estadistiqueses) {
		this.estadistiqueses = estadistiqueses;
	}
	/**
	 * Mètode que dona accès a la propietat basicses.
	 * @return Retorna una llista d'usuaris bàsics.
	 */
	public Set getBasicses() {
		return this.basicses;
	}
	/**
	 * Mètode que estableix la propietat basicses.
	 * @param basicses Una llista d'usuaris bàsics.
	 */
	public void setBasicses(Set basicses) {
		this.basicses = basicses;
	}
	/**
	 * Mètode que dona accès a la propietat historialCursVisitats.
	 * @return Retorna una llista d'historials de cursos visitats.
	 */
	public Set getHistorialCursVisitats() {
		return this.historialCursVisitats;
	}
	/**
	 * Mètode que estableix la propietat historialCursVisitats.
	 * @param historialCursVisitats Una llista d'historials de cursos visitats.
	 */
	public void setHistorialCursVisitats(Set historialCursVisitats) {
		this.historialCursVisitats = historialCursVisitats;
	}

}