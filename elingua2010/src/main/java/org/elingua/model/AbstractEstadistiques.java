package org.elingua.model;

import java.util.Date;

/**
 * La entitat AbstractEstadistiques proporciona la base de la definició de la persistencia de l'entitat Estadistiques.
 * 
 * @author Marina Martin
 * @see org.elingua.model.Estadistiques
 */

public abstract class AbstractEstadistiques implements java.io.Serializable {

	/**Propietats de AbstractEstadistiques */

	private Integer idEstadistiques;
	private Usuaris usuaris;
	private Date ultimLog;
	private Integer cursPub;
	private Integer cursCon;
	private Integer msmEnv;
	private Integer msmReb;

	

	/** Constructor per defecte */
	public AbstractEstadistiques() {
	}

	/** Constructor amb les propietats obligatòries */
	public AbstractEstadistiques(Usuaris usuaris) {
		this.usuaris = usuaris;
	}

	/** Constructor amb totes les propietats */
	public AbstractEstadistiques(Usuaris usuaris, Date ultimLog,
			Integer cursPub, Integer cursCon, Integer msmEnv, Integer msmReb) {
		this.usuaris = usuaris;
		this.ultimLog = ultimLog;
		this.cursPub = cursPub;
		this.cursCon = cursCon;
		this.msmEnv = msmEnv;
		this.msmReb = msmReb;
	}

	/**
	 * Mètode que dona accès a la propietat idEstadistiques.
	 * @return Retorna l'identificador de les estadístiques.
	 */

	public Integer getIdEstadistiques() {
		return this.idEstadistiques;
	}
	/**
	 * Mètode que estableix la propietat idEstadistiques.
	 * @param idEstadistiques L'identificador de les estadístiques.
	 */
	public void setIdEstadistiques(Integer idEstadistiques) {
		this.idEstadistiques = idEstadistiques;
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
	 * Mètode que dona accès a la propietat ultimLog.
	 * @return Retorna la data d'alta de l'usuari.
	 */
	public Date getUltimLog() {
		return this.ultimLog;
	}
	/**
	 * Mètode que estableix la propietat ultimLog.
	 * @param ultimLog La data d'alta de l'usuari.
	 */
	public void setUltimLog(Date ultimLog) {
		this.ultimLog = ultimLog;
	}
	/**
	 * Mètode que dona accès a la propietat cursPub.
	 * @return Retorna el nombre de cursos publicats per l'usuari.
	 */
	public Integer getCursPub() {
		return this.cursPub;
	}
	/**
	 * Mètode que estableix la propietat cursPub.
	 * @param cursPub El nombre de cursos publicats per l'usuari.
	 */
	public void setCursPub(Integer cursPub) {
		this.cursPub = cursPub;
	}
	/**
	 * Mètode que dona accès a la propietat cursCon.
	 * @return Retorna el nombre de cursos consultats per l'usuari.
	 */
	public Integer getCursCon() {
		return this.cursCon;
	}
	/**
	 * Mètode que estableix la propietat cursCon.
	 * @param cursCon El nombre de cursos consultats per l'usuari.
	 */
	public void setCursCon(Integer cursCon) {
		this.cursCon = cursCon;
	}
	/**
	 * Mètode que dona accès a la propietat msmEnv.
	 * @return Retorna el nombre de missatges enviats per l'usuari.
	 */
	public Integer getMsmEnv() {
		return this.msmEnv;
	}
	/**
	 * Mètode que estableix la propietat msmEnv.
	 * @param msmEnv El nombre de missatges enviats per l'usuari.
	 */
	public void setMsmEnv(Integer msmEnv) {
		this.msmEnv = msmEnv;
	}
	/**
	 * Mètode que dona accès a la propietat msmReb.
	 * @return Retorna el nombre de missatges rebuts per l'usuari.
	 */
	public Integer getMsmReb() {
		return this.msmReb;
	}
	/**
	 * Mètode que estableix la propietat msmReb.
	 * @param msmReb El nombre de missatges rebuts per l'usuari.
	 */
	public void setMsmReb(Integer msmReb) {
		this.msmReb = msmReb;
	}

}