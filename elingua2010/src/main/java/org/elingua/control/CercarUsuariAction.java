package org.elingua.control;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.elingua.model.managerCercarUsuari;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
/**
 * Classe CercarUsuariAction que executa una lògica de negoci en particular en funció de la sol·licitud i els paràmetres d'entrada. 
 * 
 * @author Marina Martin
 * @version 1.0
 */
public class CercarUsuariAction extends ActionSupport implements Preparable{
	
	public CercarUsuariAction(){
		usuaris = new ArrayList();
		
	}
	
	/**
	 * Acció que cerca un usuari.
	 * Aquest mètode sobrecarrega el mètode execute de ActionSupport.
	 * 
     * @return Retorna {@link #SUCCESS}
     */
	public String execute()  {
		/*segons el tipus de cerca invoquem un mètode diferent del manager de cercar usuaris*/ 
		/*cerquem per nom d'usuari*/
		if(getCerca().equals("usuari")){
			/*cercem l'usuari*/
			String usu = getManager().cercarUsuariPerNom(getNom());
			/*si trobem l'usuari el guardem a la llista d'usuaris trobats*/
			if(usu != null){
				usuaris.add(usu);
			}
			
		}
		/*tipus de cerca per idioma que estudia*/
		else if(getCerca().equals("idioma")){
			usuaris = getManager().cercarUsuariPerIdiEst(getIdiomaSeleEst());
		}
		/*tipus de cerca per idioma que coneix*/
		else if(getCerca().equals("idioma2")){
			usuaris = getManager().cercarUsuariPerIdiSap(getIdiomaSeleSap());
		}
		
		/*retornem la cadena de control*/
		return "SUCCESS";
	}
	/**LLista d'idiomes disponibles */
	private List<String> idiomesLlista;
	/**Idioma que coneix seleccionat com a criteri de cerca*/
	private String idiomaSeleSap;
	/**Idioma que està estudiant seleccionat com a criteri de cerca*/
	private String idiomaSeleEst;
	/**Cadena amb el criteri de cerca*/
	private String cerca;
	/**El nom del usuari com a criteri de cerca*/
	private String nom;
	/**La llista dels usuaris trobats*/
	private List<String> usuaris;
	/**Paràmetre amb el nom d'usuari del propietari del perfil public*/
	private String usuari;
	
	
	
	/**
	 * Mètode que dona accès a la propietat usuari.
	 * @return Retorna el nom d'usuari del propietari del perfil public.
	 */
	public String getUsuari() {
		return usuari;
	}
	/**
	 * Mètode que estableix la propietat nomIdiomaEliminar.
	 * @param usuari El nom d'usuari del propietari del perfil public.
	 */
	public void setUsuari(String usuari) {
		this.usuari = usuari;
	}

	/**
	 * Mètode que dona accès a la propietat idiomaSeleSap.
	 * @return Retorna l'idioma que està estudiant seleccionat com a criteri de cerca.
	 */
	public String getIdiomaSeleSap() {
		return idiomaSeleSap;
	}

	/**
	 * Mètode que estableix la propietat idiomaSeleSap.
	 * @param idiomaSeleSap L'idioma que està estudiant seleccionat com a criteri de cerca.
	 */
	public void setIdiomaSeleSap(String idiomaSeleSap) {
		this.idiomaSeleSap = idiomaSeleSap;
	}

	/**
	 * Mètode que dona accès a la propietat idiomaSeleEst.
	 * @return Retorna l'idioma que coneix seleccionat com a criteri de cerca.
	 */
	public String getIdiomaSeleEst() {
		return idiomaSeleEst;
	}
	/**
	 * Mètode que estableix la propietat idiomaSeleEst.
	 * @param idiomaSeleEst L'idioma que coneix seleccionat com a criteri de cerca.
	 */

	public void setIdiomaSeleEst(String idiomaSeleEst) {
		this.idiomaSeleEst = idiomaSeleEst;
	}
	/**
	 * Mètode que dona accès a la propietat usuaris.
	 * @return Retorna la llista d'usuaris trobats.
	 */

	public List<String> getUsuaris() {
		return usuaris;
	}

	/**
	 * Mètode que estableix la propietat usuaris.
	 * @param usuaris La llista d'usuaris trobats.
	 */
	public void setUsuaris(List<String> usuaris) {
		this.usuaris = usuaris;
	}

	/**
	 * Mètode que dona accès a la propietat nom.
	 * @return Retorna el nom de l'usuari com a criteri de cerca.
	 */

	public String getNom() {
		return nom;
	}
	/**
	 * Mètode que estableix la propietat nom.
	 * @param nom El nom de l'usuari com a criteri de cerca.
	 */

	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * Mètode que dona accès a la propietat cerca.
	 * @return Retorna una cadena amb el criteri de cerca.
	 */

	public String getCerca() {
		return cerca;
	}

	/**
	 * Mètode que estableix la propietat cerca.
	 * @param cerca Una cadena amb el criteri de cerca.
	 */
	public void setCerca(String cerca) {
		this.cerca = cerca;
	}

	/**
	 * Mètode que dona accès a la propietat idiomesLlista.
	 * @return Retorna la llista d'idiomes disponibles.
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
	 * Acció que mostra la pantalla de cerca.
	 * @return Una cadena associada a un Result d'Struts2.
	 */
	@SkipValidation
	public String mostrar() {
		return "MOSTRAR";
	}
	
	/**
	 * Carrega el necesari abans de mostrar la pantalla de cerca.
	 * Aquest mètode implementa el mètode prepare de la interfície Preparable.
	 */
	public void prepare() {
		idiomesLlista = getManager().carregarIdiomes();
	}
	/**
	 * Mètode que dona accès a la capa de control.
	 * @return Un objecte de tipus managerCercarUsuari.
	 */
	public managerCercarUsuari getManager(){
		
		return new managerCercarUsuari();
		
	}
}