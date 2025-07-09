package org.elingua.control;


import java.util.Map;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.elingua.model.Sessio;
import org.elingua.model.managerSessio;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * Classe SessioAction que executa una lògica de negoci en particular en funció de la sol·licitud i els paràmetres d'entrada. 
 * 
 * @author Marina Martin
 * @version 1.0
 */
public class SessioAction  extends ActionSupport {
	/**
	 * Acció que logueja a l'usuari i crea una nova sessió.
	 * Aquest mètode sobrecarrega el mètode execute de ActionSupport.
	 * 
     * @return Retorna {@link #SUCCESS}
     */
	public String execute()  {
		/*carreguem el manager sessió de l'usuari*/
		managerSessio ml = getManager();
		/*creem la sessió de l'usuari*/
		Sessio sessio = ml.crearSessio(getNomUsuari());
		Map session = ActionContext.getContext().getSession();
	    session.put("usuari",sessio);
	    /*si som l'Administrador redirigim cap a la pantalla d'Administració*/
		if(nomUsuari.equals("admin") || nomUsuari.equals("ADMIN")){
			/*retorna la cadena de control*/
			return "ADMIN";
		}
		/*retorna la cadena de control*/
		return "SUCCESS";
	}
	/**
	 * Acció que deslogueja a l'usuari i destrueix la seva sessió.
	 * @return Una cadena associada a un Result d'Struts2.
	 */
	@SkipValidation
	public String desloguejar() throws Exception {
		/*destruïm la sessió*/
	    Map session = ActionContext.getContext().getSession();
	    session.remove("usuari");
	    /*retornem la cadena de control*/
	    return "SUCCESS";
	}
	
	/**El nom d'usuari introduït al login*/
	private String nomUsuari; 
	/**La contrasenya introduïda al login*/
	private String contrasenya; 
	
	/**
	 * Mètode que dona accès a la propietat nomUsuari.
	 * @return Retorna el nom d'usuari introduït al login.
	 */
	public String getNomUsuari() {
			return nomUsuari;
	}
	/**
	 * Mètode que estableix la propietat nomUsuari.
	 * @param nomUsuari El nom d'usuari introduït al login.
	 */
	public void setNomUsuari(String nomUsuari) {
		this.nomUsuari = nomUsuari;
	}
	/**
	 * Mètode que dona accès a la propietat contrasenya.
	 * @return Retorna la contrasenya introduïda al login.
	 */
	public String getContrasenya() {
		return contrasenya;
	}
	/**
	 * Mètode que estableix la propietat contrasenya.
	 * @param contrasenya La contrasenya introduïda al login.
	 */
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	/**Mètode que valida les dades introduïdes al login */
	public void validate(){
		/*carreguem el manager de sessió de l'usuari*/
		managerSessio ml = getManager();
		
		if(getNomUsuari().length() != 0 && getContrasenya().length() != 0){
			/*Comprovar que l'usuari existeix*/
			if ( ml.usuariCheck(getNomUsuari(),getContrasenya())){	
				/*si no existeix mostrem un missatge d'error*/
				addFieldError("nomUsuari", getText( "usuari.noexisteix"));
			}
		}
	}
	public managerSessio getManager(){
		return new managerSessio();
	}
}
