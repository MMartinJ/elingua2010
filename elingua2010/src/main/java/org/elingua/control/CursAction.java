package org.elingua.control;


import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.elingua.model.Sessio;
import org.elingua.model.managerCurs;

/**
 * Classe CursAction que executa una lògica de negoci en particular en funció de la sol·licitud i els paràmetres d'entrada. 
 * 
 * @author Marina Martin
 * @version 1.0
 */
public class CursAction  extends ActionSupport implements Preparable {
	
	
	private static final long serialVersionUID = 1L;
	/**Constructor per defecte*/
	public CursAction(){
		
	}
	
	/**
	 * Implementació per defecte que no fa res y retorna la cadena "SUCCESS".
	 * Aquest mètode sobrecarrega el mètode execute de ActionSupport.
	 * 
     *
     * @return Retorna {@link #SUCCESS}
     */
	public String execute()  {
		return "SUCCESS";
	}
	
	
	
	/**Contingut del curs */
	private String cnt;
	/**Títol del curs */
	private String titol;
	/**Idioma del curs */
	private String idiomaSele;
	/**Llista d'idiomes disponibles */
	private List<String> idiomesLlista;
	/**Llista de cursos disponibles */
	private List<List> cursosList;
	/**Identificador únic del curs */
	private String id;
	/**El nom d'usuari del creador del curs */
	private String usuari;
	/**L'idioma seleccionat per la internacionalització */
	private String meuLocale;
	
	
	
	/**
	 * Mètode que dona accès a la propietat meuLocale.
	 * @return Retorna l'idioma seleccionat per la internacionalització.
	 */
	public String getMeuLocale() {
		return meuLocale;
	}
	/**
	 * Mètode que estableix la propietat meuLocale.
	 * @param meuLocale L'idioma seleccionat per la internacionalització.
	 */
	public void setMeuLocale(String meuLocale) {
		this.meuLocale = meuLocale;
	}
	/**
	 * Mètode que dona accès a la propietat idiomesLlista.
	 * @return Retorna la llista d'idiomes disponibles
	 */
	public List<String> getIdiomesLlista() {
		return idiomesLlista;
	}
	/**
	 * Mètode que estableix la propietat idiomesLlista.
	 * @param idiomesLlista La llista d'idiomes disponibles.
	 */
	public void setIdiomesLlista(List<String> idiomesLlista) {
		this.idiomesLlista = idiomesLlista;
	}
	/**
	 * Mètode que dona accès a la propietat usuari.
	 * @return Retorna el nom d'usuari del creador del curs.
	 */
	public String getUsuari() {
		return usuari;
	}
	/**
	 * Mètode que estableix la propietat usuari.
	 * @param usuari El nom d'usuari del creador del curs.
	 */
	public void setUsuari(String usuari) {
		this.usuari = usuari;
	}
	/**
	 * Mètode que dona accès a la propietat id.
	 * @return Retorna l'identificador únic del curs.
	 */
	public String getId() {
		return id;
	}
	/**
	 * Mètode que estableix la propietat id.
	 * @param id L'identificador únic del curs.
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Mètode que dona accès a la propietat cnt.
	 * @return Retorna el contingut del curs.
	 */
	public String getCnt() {
		return cnt;
	}
	/**
	 * Mètode que estableix la propietat cnt.
	 * @param cnt El contingut del curs.
	 */
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	/**
	 * Mètode que dona accès a la propietat titol.
	 * @return Retorna el títol del curs.
	 */
	public String getTitol() {
		return titol;
	}
	/**
	 * Mètode que estableix la propietat titol.
	 * @param titol El títol del curs.
	 */
	public void setTitol(String titol) {
		this.titol = titol;
	}
	/**
	 * Mètode que dona accès a la propietat idiomaSele.
	 * @return Retorna l'idioma del curs.
	 */
	public String getIdiomaSele() {
		return idiomaSele;
	}
	/**
	 * Mètode que estableix la propietat idiomaSele.
	 * @param idiomaSele L'idioma del curs.
	 */
	public void setIdiomaSele(String idiomaSele) {
		this.idiomaSele = idiomaSele;
	}
	/**
	 * Mètode que dona accès a la propietat cursosList.
	 * @return Retorna la llista de cursos disponibles
	 */
	public List<List> getCursosList() {
		return cursosList;
	}
	/**
	 * Mètode que estableix la propietat cursosList.
	 * @param cursosList La llista de cursos disponibles.
	 */
	public void setCursosList(List<List> cursosList) {
		this.cursosList = cursosList;
	}
	/**
	 * Mètode que dona accès a la capa de control.
	 * @return Un objecte de tipus managerCurs.
	 */
	public managerCurs getManager(){
		
		return new managerCurs();
		
	}
	/**
	 * Acció que mostra la pantalla d'un curs concret.
	 * @return Una cadena associada a un Result d'Struts2.
	 */
	@SkipValidation
	public String mostrarCurs() {
		/*agafem l'identificador del curs*/
		int id = Integer.valueOf(getId());
		/*carreguem les dades del curs*/
		List<String> resultat =	getManager().carregarCurs(id);
		/*les guardem*/
		setIdiomaSele(resultat.get(0));
		setTitol(resultat.get(1));
		setCnt(resultat.get(2));
		setUsuari(resultat.get(3));
		//Estadistiques
		EstadistiquesAction estAct = new EstadistiquesAction();
		/*guardem el curs visitat*/
		estAct.guardarCursVisitat(id);
		/*retornem la cadena de control*/
		return "MOSTRAR";
	}
	/**
	 * Acció que mostra la pantalla d'editar un curs.
	 * @return Una cadena associada a un Result d'Struts2.
	 */
	@SkipValidation
	public String mostrarEditarCurs() {
		/*agafem l'identificador del curs*/
		int id = Integer.valueOf(getId());
		/*carreguem les dades del curs*/
		List<String> resultat =	getManager().carregarCurs(id);
		/*les guardem*/
		setIdiomaSele(resultat.get(0));
		setTitol(resultat.get(1));
		setCnt(resultat.get(2));
		setUsuari(resultat.get(3));
		/*definim l'idioma de l'editor*/
		setMeuLocale(getLocale().toString());
		/*retornem la cadena de control*/
		return "MOSTRAREDITAR";
	}
	/**
	 * Acció que mostra la pantalla d'un nou curs.
	 * @return Una cadena associada a un Result d'Struts2.
	 */
	public String crearCurs() {
		/*carreguem l'objecte sessió associat a l'usuari*/
		Map session = ActionContext.getContext().getSession();
		Sessio sesio = (Sessio) session.get("usuari");
		/*enregistrem el curs i ens retorna l'identificador del curs*/
		int idCurs = getManager().enregistrarCurs(sesio.getIdUsuari(),getCnt(),getTitol(),getIdiomaSele());
		/*guardem l'identificador retornat*/
		setId(Integer.toString(idCurs));
		/*guardem l'autor del curs*/
		setUsuari(sesio.getNomUsuari());
		//estadistiques
		EstadistiquesAction estAct = new EstadistiquesAction();
		estAct.guardarCursCreat(getUsuari());
		/*retornem la cadena de control*/
		return "CREAR";
	}
	/**
	 * Acció que edita l'informació d'un curs.
	 * @return Una cadena associada a un Result d'Struts2.
	 */
	public String editarCurs() {
		/*carreguem l'identificador del curs*/
		int id = Integer.valueOf(getId());
		/*editem l'informació del curs*/
		getManager().editarCurs(id,getCnt(),getTitol());
		/*carreguem l'informació del curs creat*/
		List<String> resultat =	getManager().carregarCurs(id);
		/*guardem l'autor i l'idioma del curs*/
		setIdiomaSele(resultat.get(0));
		setUsuari(resultat.get(3));
		/*retornem la cadena de control*/
		return "EDITAR";
	}
	/**
	 * Acció que llista els cursos.
	 * @return Una cadena associada a un Result d'Struts2.
	 */
	@SkipValidation
	public String llistarCursos() {
		/*llistem els cursos disponibles*/
		setCursosList(getManager().llistarCursos());
		/*retornem la cadena de control*/
		return "LLISTAR";
	}
	/**
	 * Acció que elimina un curs.
	 * @return Una cadena associada a un Result d'Struts2.
	 */
	@SkipValidation
	public String eliminarCurs() {
		/*carreguem l'identificador del curs*/
		int id = Integer.valueOf(getId());
		/*eliminem el curs*/
		getManager().eliminarCurs(id);
		/*retornem la cadena de control*/
		return "ELIMINAR";
	}
	/**
	 * Acció que mostra la pantalla cursos.
	 * @return Una cadena associada a un Result d'Struts2.
	 */
	@SkipValidation
	public String mostrar() {
		/*definim l'idioma de l'editor*/
		setMeuLocale(getLocale().toString());
		/*retornem la cadena de control*/
		return "MOSTRAR";
	}
	/**
	 * Carrega el necesari abans de mostrar la pantalla de curs.
	 * Aquest mètode implementa el mètode prepare de la interfície Preparable.
	 */
	public void prepare() {
		/*carreguem la llista d'idiomes disponibles*/
		idiomesLlista = getManager().carregarIdiomes();
	}
	


}
