package org.elingua.model;

/**
 * La entitat AbstractMissatges proporciona la base de la definició de la persistencia de l'entitat Missatges.
 * 
 * @author Marina Martin
 * @see org.elingua.model.Missatges
 */

public abstract class AbstractMissatges implements java.io.Serializable {

	/**Propietats de AbstractMissatges */

	private Integer idMissatge;
	private Usuaris usuarisByReceptor;
	private Usuaris usuarisByEmissor;
	private String assumpte;
	private String contingut;

	

	/** Constructor per defecte */
	public AbstractMissatges() {
	}

	/** Constructor amb totes les propietats */
	public AbstractMissatges(Usuaris usuarisByReceptor,
			Usuaris usuarisByEmissor, String assumpte, String contingut) {
		this.usuarisByReceptor = usuarisByReceptor;
		this.usuarisByEmissor = usuarisByEmissor;
		this.assumpte = assumpte;
		this.contingut = contingut;
	}

	/**
	 * Mètode que dona accès a la propietat idMissatge.
	 * @return Retorna l'identificador del missatge.
	 */ 

	public Integer getIdMissatge() {
		return this.idMissatge;
	}
	/**
	 * Mètode que estableix la propietat idMissatge.
	 * @param idMissatge L'identificador del missatge.
	 */
	public void setIdMissatge(Integer idMissatge) {
		this.idMissatge = idMissatge;
	}
	/**
	 * Mètode que dona accès a la propietat usuarisByReceptor.
	 * @return Retorna un objecte de tipus Usuaris.
	 */
	public Usuaris getUsuarisByReceptor() {
		return this.usuarisByReceptor;
	}
	/**
	 * Mètode que estableix la propietat usuarisByReceptor.
	 * @param usuarisByReceptor Un Objecte de tipus Usuaris.
	 */
	public void setUsuarisByReceptor(Usuaris usuarisByReceptor) {
		this.usuarisByReceptor = usuarisByReceptor;
	}
	/**
	 * Mètode que dona accès a la propietat usuarisByEmissor.
	 * @return Retorna un objecte de tipus Usuaris.
	 */
	public Usuaris getUsuarisByEmissor() {
		return this.usuarisByEmissor;
	}
	/**
	 * Mètode que estableix la propietat idIdioma.
	 * @param usuarisByEmissor Un Objecte de tipus Usuaris.
	 */
	public void setUsuarisByEmissor(Usuaris usuarisByEmissor) {
		this.usuarisByEmissor = usuarisByEmissor;
	}
	/**
	 * Mètode que dona accès a la propietat assumpte.
	 * @return Retorna el assumpte del missatge.
	 */
	public String getAssumpte() {
		return this.assumpte;
	}
	/**
	 * Mètode que estableix la propietat assumpte.
	 * @param assumpte El assumpte del missatge.
	 */
	public void setAssumpte(String assumpte) {
		this.assumpte = assumpte;
	}
	/**
	 * Mètode que dona accès a la propietat contingut.
	 * @return Retorna el contingut del misssatge.
	 */
	public String getContingut() {
		return this.contingut;
	}
	/**
	 * Mètode que estableix la propietat contingut.
	 * @param contingut El contingut del missatge.
	 */
	public void setContingut(String contingut) {
		this.contingut = contingut;
	}

}