package org.elingua.control;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.elingua.model.managerAdministrar;


/**
 * Classe AdministrarAction que executa una lògica de negoci en particular en funció de la sol·licitud i els paràmetres d'entrada. 
 * 
 * @author Marina Martin
 * @version 1.0
 */

public class AdministrarAction  extends ActionSupport implements Preparable {
	
	
	private static final long serialVersionUID = 1L;
	/**Constructor per defecte */
	public AdministrarAction(){
		
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
	
	
	
	
	/**LLista d'idiomes disponibles */
	private List<String> idiomesLlista;
	/**Llista d'usuaris*/
	private List<List> usuarisList;
	/**Nom d'un usuari a modificar */
	private String nomUsuari;
	/**Nom de l'idimoma a modificar */
	private String nomIdioma;
	/**Nom de l'idioma a eliminar */
	private String nomIdiomaEliminar;
	
	
	/**
	 * Mètode que dona accès a la propietat nomIdiomaEliminar.
	 * @return Retorna el nom de l'idioma a eliminar
	 */
	
	public String getNomIdiomaEliminar() {
		return nomIdiomaEliminar;
	}
	/**
	 * Mètode que estableix la propietat nomIdiomaEliminar.
	 * @param nomIdiomaEliminar El nom de l'idioma a eliminar
	 */
	public void setNomIdiomaEliminar(String nomIdiomaEliminar) {
		this.nomIdiomaEliminar = nomIdiomaEliminar;
	}
	/**
	 * Mètode que dona accès a la propietat nomUsuari.
	 * @return Retorna el nom de l'usuari a modificar.
	 */
	public String getNomUsuari() {
		return nomUsuari;
	}
	/**
	 * Mètode que estableix la propietat nomUsuari.
	 * @param nomUsuari El nom de l'usuari a modificar.
	 */
	public void setNomUsuari(String nomUsuari) {
		this.nomUsuari = nomUsuari;
	}
	/**
	 * Mètode que dona accès a la propietat nomIdioma.
	 * @return Retorna el nom de l'idioma a modificar.
	 */
	public String getNomIdioma() {
		return nomIdioma;
	}
	/**
	 * Mètode que estableix la propietat nomIdioma.
	 * @param nomIdioma El nom de l'idioma a modificar.
	 */
	public void setNomIdioma(String nomIdioma) {
		this.nomIdioma = nomIdioma;
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
	 * Mètode que dona accès a la propietat usuarisList.
	 * @return Retorna la llista d'usuaris registrats.
	 */

	public List<List> getUsuarisList() {
		return usuarisList;
	}
	/**
	 * Mètode que estableix la propietat usuarisList.
	 * @param usuarisList La llista d'usuaris registrats.
	 */
	public void setUsuarisList(List<List> usuarisList) {
		this.usuarisList = usuarisList;
	}
	/**Mètode que valida les dades introduïdes al formulari */
	public void validate(){
		if(getManager().checkIdioma(getNomIdioma())){
			addFieldError( "nomIdioma", getText("idioma.existeix") );
		}
	}

	/**
	 * Mètode que dona accès a la capa de control.
	 * @return Un objecte de tipus managerAdministrar.
	 */
	public managerAdministrar getManager(){
		
		return new managerAdministrar();
		
	}
	/**
	 * Acció que llista els usuaris.
	 * @return Una cadena associada a un Result d'Struts2. 
	 */
	@SkipValidation
	public String llistarUsuaris(){
		setUsuarisList(getManager().llistarUsuaris());
		return "LLISTARUSUARI";
	}
	/**
	 * Acció que elimina un usuari.
	 * @return Una cadena associada a un Result d'Struts2. 
	 */
	@SkipValidation
	public String eliminarUsuaris(){
		getManager().eliminarUsuaris(getNomUsuari());
		return "ELIMINARUSUARI";
	}
	/**
	 * Acció que afegeix un idioma.
	 * @return Una cadena associada a un Result d'Struts2. 
	 */
	public String afegeixIdioma(){
		getManager().afegeixIdioma(getNomIdioma());
		return "AFEGEIXIDIOMA";
	}
	/**
	 * Acció que elimina un idioma.
	 * @return Una cadena associada a un Result d'Struts2. 
	 */
	@SkipValidation
	public String eliminarIdioma(){
		getManager().eliminarIdioma(getNomIdiomaEliminar());
		return "ELIMINARIDIOMA";
	}
	/**
	 * Acció que mostra la pantalla d'administrador.
	 * @return Una cadena associada a un Result d'Struts2. 
	 */
	@SkipValidation
	public String mostrar(){
		llistarUsuaris();
		idiomesLlista = getManager().carregarIdiomes();
		return "MOSTRAR";
	}
/**
 * Carrega el necesari abans de mostrar la pantalla d'administradors.
 * Aquest mètode implementa el mètode prepare de la interfície Preparable.
 */
	@SkipValidation
	public void prepare() {
		llistarUsuaris();
		idiomesLlista = getManager().carregarIdiomes();
	}
	


}
