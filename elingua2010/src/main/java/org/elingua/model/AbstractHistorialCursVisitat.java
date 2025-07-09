package org.elingua.model;

/**
 * La entitat AbstractHistorialCursVisitat proporciona la base de la definició de la persistencia de l'entitat HistorialCursVisitat.
 * 
 * @author Marina Martin
 * @see org.elingua.model.HistorialCursVisitat
 */

public abstract class AbstractHistorialCursVisitat implements
		java.io.Serializable {

	/**Propietats de AbstractHistorialCursVisitat */

	private Integer idUsuariCursVisitat;
	private Cursos cursos;
	private Usuaris usuaris;

	

	/** Constructor per defecte */
	public AbstractHistorialCursVisitat() {
	}

	/** Constructor amb totes les propietats */
	public AbstractHistorialCursVisitat(Cursos cursos, Usuaris usuaris) {
		this.cursos = cursos;
		this.usuaris = usuaris;
	}

	/**
	 * Mètode que dona accès a la propietat idUsuariCursVisitat.
	 * @return Retorna l'identificador del curs visitat.
	 */

	public Integer getIdUsuariCursVisitat() {
		return this.idUsuariCursVisitat;
	}
	/**
	 * Mètode que estableix la propietat idUsuariCursVisitat.
	 * @param idUsuariCursVisitat L'identificador del curs visitat.
	 */
	public void setIdUsuariCursVisitat(Integer idUsuariCursVisitat) {
		this.idUsuariCursVisitat = idUsuariCursVisitat;
	}
	/**
	 * Mètode que dona accès a la propietat cursos.
	 * @return Retorna l'objecte de tipus Cursos
	 */
	public Cursos getCursos() {
		return this.cursos;
	}
	/**
	 * Mètode que estableix la propietat cursos.
	 * @param cursos L'objecte de tipus Cursos.
	 */
	public void setCursos(Cursos cursos) {
		this.cursos = cursos;
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