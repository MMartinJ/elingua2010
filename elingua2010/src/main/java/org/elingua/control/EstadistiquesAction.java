package org.elingua.control;

import java.util.Date;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.elingua.model.managerEstadistiques;
/**
 * Classe EstadistiquesAction que executa una lògica de negoci en particular en funció de la sol·licitud i els paràmetres d'entrada. 
 * 
 * @author Marina Martin
 * @version 1.0
 */

public class EstadistiquesAction  extends ActionSupport {
	
	
	private static final long serialVersionUID = 1L;
	/**Constructor per defecte*/
	public EstadistiquesAction(){
		
	}
	/**
	 * Implementació per defecte que no fa res y retorna la cadena "SUCCESS".
	 * Aquest mètode sobrecarrega el mètode execute de ActionSupport.
	 * 
     *
     * @return Retorna {@link #SUCCESS}
     */
	public String execute()  {
		/*retorna la cadena de control*/
		return "SUCCESS";
	}
	
	
	/**La data en la que l'usuari s'ha enregistrat */
	private String dataLogin;
	/**El nombre de cursos creats per l'usuari */
	private int cursosCreats;
	/**El nombre de cursos visitats per l'usuari */
	private int cursosVisitats;
	/**El nombre de missatges enviats per l'usuari */
	private int missatgesEnviats;
	/**El nombre de missatges llegits per l'usuari */
	private int missatgesLlegits;
	
	/**
	 * Mètode que dona accès a la propietat dataLogin.
	 * @return Retorna la data en la que l'usuari s'ha enregistrat.
	 */
	public String getDataLogin() {
		return dataLogin;
	}
	/**
	 * Mètode que estableix la propietat dataLogin.
	 * @param dataLogin La data en la que l'usuari s'ha enregistrat.
	 */
	public void setDataLogin(String dataLogin) {
		this.dataLogin = dataLogin;
	}
	/**
	 * Mètode que dona accès a la propietat cursosCreats.
	 * @return Retorna el nombre de cursos creats per l'usuari.
	 */
	public int getCursosCreats() {
		return cursosCreats;
	}
	/**
	 * Mètode que estableix la propietat cursosCreats.
	 * @param cursosCreats El nombre de cursos creats per l'usuari.
	 */
	public void setCursosCreats(int cursosCreats) {
		this.cursosCreats = cursosCreats;
	}
	/**
	 * Mètode que dona accès a la propietat cursosVisitats.
	 * @return Retorna el nombre de cursos visitats per l'usuari.
	 */
	public int getCursosVisitats() {
		return cursosVisitats;
	}
	/**
	 * Mètode que estableix la propietat cursosVisitats.
	 * @param cursosVisitats El nombre de cursos visitats per l'usuari.
	 */
	public void setCursosVisitats(int cursosVisitats) {
		this.cursosVisitats = cursosVisitats;
	}
	/**
	 * Mètode que dona accès a la propietat missatgesEnviats.
	 * @return Retorna el nombre de missatges enviats per l'usuari.
	 */
	public int getMissatgesEnviats() {
		return missatgesEnviats;
	}
	/**
	 * Mètode que estableix la propietat missatgesEnviats.
	 * @param missatgesEnviats El nombre de missatges enviats per l'usuari.
	 */
	public void setMissatgesEnviats(int missatgesEnviats) {
		this.missatgesEnviats = missatgesEnviats;
	}
	/**
	 * Mètode que dona accès a la propietat missatgesLlegits.
	 * @return Retorna el nombre de missatges llegits per l'usuari.
	 */
	public int getMissatgesLlegits() {
		return missatgesLlegits;
	}
	/**
	 * Mètode que estableix la propietat missatgesLlegits.
	 * @param missatgesLlegits El nombre de missatges llegits per l'usuari.
	 */
	public void setMissatgesLlegits(int missatgesLlegits) {
		this.missatgesLlegits = missatgesLlegits;
	}
	/**
	 * Mètode d'estadístiques que guarda la data de registre.
	 * @param nomUsuari El nom de l'usuari.
	 * @param data La data en la que l'usuari s'enregistra.
	 */
	public void guardarDataRegistre(String nomUsuari,Date data){
		managerEstadistiques me = getManager();
		me.guardarDataRegistre(nomUsuari,data);
	}
	/**
	 * Mètode d'estadístiques que guarda el nombre de cursos creats.
	 * @param nomUsuari El nom de l'usuari.
	 */
	public void guardarCursCreat(String nomUsuari){
		managerEstadistiques me = getManager();
		me.guardarCursCreat(nomUsuari);
		
	}
	/**
	 * Mètode d'estadístiques que guarda el nombre de cursos visitats.
	 * @param curs El curs que es visita.
	 */
	public void guardarCursVisitat(int curs){
		managerEstadistiques me = getManager();
		me.guardarCursVisitat(curs);
	}
	/**
	 * Mètode d'estadístiques que guarda el nombre de missatges enviats.
	 * @param nomUsuari El nom de l'usuari.
	 */
	public void guardarMissatgeEnviat(String nomUsuari){
		managerEstadistiques me = getManager();
		me.guardarMissatgeEnviat(nomUsuari);
	}
	/**
	 * Mètode d'estadístiques que guarda el nombre de missatges llegits.
	 */
	public void guardarMissatgeLlegit(){
		managerEstadistiques me = getManager();
		me.guardarMissatgeLlegit();
	}
	/**Mostra les dades a la pantalla d'estadístiques */
	@SkipValidation
	public String mostrarEstadistiques(){
		/*carreguem el manager d'estadístiques*/
		managerEstadistiques me = getManager();
		/*carreguem totes les dades de les estadístiques*/
		setDataLogin(me.carregarData());
		setCursosCreats(me.carregarCursosCreats());
		setCursosVisitats(me.carregarCursosVisitats());
		setMissatgesEnviats(me.carregarMissatgesEnviats());
		setMissatgesLlegits(me.carregarMissatgesLlegits());
		/*retorna la cadena de control*/
		return "MOSTRAR";
	}
	/**
	 * Mètode que dona accès a la capa de control.
	 * @return Un objecte de tipus managerEstadistiques.
	 */
	public managerEstadistiques getManager(){
		return new managerEstadistiques();
	}
	
}
