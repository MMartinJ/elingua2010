package org.elingua.control;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.elingua.model.Sessio;
import org.elingua.model.managerMissatge;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * Classe MissatgeAction que executa una lògica de negoci en particular en funció de la sol·licitud i els paràmetres d'entrada. 
 * 
 * @author Marina Martin
 * @version 1.0
 */
public class MissatgeAction extends ActionSupport{
	/**
	 * Acció que guarda el missatge.
	 * Aquest mètode sobrecarrega el mètode execute de ActionSupport.
	 * 
     * @return Retorna {@link #SUCCESS}
     */
	public String execute()  {
		/*carreguem el manager de missatges i guardem el missatge*/
		getManager().guardarMissatge(getDestinatari(),getAssumpte(),getMissatge());
		//Estadistiques
		EstadistiquesAction estAct = new EstadistiquesAction();
		/*carreguem l'objecte sessió associat a l'usuari*/
		Map session = ActionContext.getContext().getSession();
		Sessio user = (Sessio) session.get("usuari");
		String nomUsuari = user.getNomUsuari();
		/*guardem l'autor del missatge*/
		estAct.guardarMissatgeEnviat(nomUsuari);
		return "SUCCESS";
	}
	
	/**El assumpte del missatge */
	private String assumpte;
	/**El contingut del missatge */
	private String missatge;
	/**El destinatari del missatge */
	private String destinatari;
	
	/**
	 * Mètode que dona accès a la propietat destinatari.
	 * @return Retorna el destinatari del missatge.
	 */
	public String getDestinatari() {
		return destinatari;
	}
	/**
	 * Mètode que estableix la propietat destinatari.
	 * @param destinatari El destinatari del missatge.
	 */
	public void setDestinatari(String destinatari) {
		this.destinatari = destinatari;
	}
	/**
	 * Mètode que dona accès a la propietat assumpte.
	 * @return Retorna el assumpte del missatge.
	 */
	public String getAssumpte() {
		return assumpte;
	}
	/**
	 * Mètode que estableix la propietat assumpte.
	 * @param assumpte El assumpte del missatge.
	 */
	public void setAssumpte(String assumpte) {
	this.assumpte = assumpte;
	}
	/**
	 * Mètode que dona accès a la propietat missatge.
	 * @return Retorna el contingut del missatge.
	 */
	public String getMissatge() {
	return missatge;
	}
	/**
	 * Mètode que estableix la propietat missatge.
	 * @param missatge El contingut del missatge.
	 */
	public void setMissatge(String missatge) {
	this.missatge = missatge;

	}
	
	/**
	 * Acció que mostra els missatges si n'hi ha.
	 * @return Retorna una cadena associada a un Result d'Struts2.
	 */
	@SkipValidation
	public String llegirMissatge(){
		/*carreguem l'objecte sessió associat a l'usuari*/
		Map session = ActionContext.getContext().getSession();
		Sessio user = (Sessio) session.get("usuari");
		String nomUsuari = user.getNomUsuari();
		/*carreguem les dades del missatge*/
		List<String> missatge = getManager().agafarMissatge(nomUsuari);
		Iterator<String> ite = missatge.iterator();
		/*guardem les dades del missatge*/
		setDestinatari(ite.next());
		setAssumpte(ite.next());
		String missat = ite.next();
		/*si no hi ha missatges es retorna el text de "no hi ha missatges"*/
		if(missat.equals("No hi ha missatges.")){
			/*extreu el text dels fitxers d'internacionalització*/
			setMissatge(getText("missatge.noHiHa"));
		}
		/*si troba un missatge el carrega*/
		else{
			setMissatge(missat);
		}
		/*retorna la cadena de control*/
		return "SUCCESS";
		
	}
	/**
	 * Acció que mostra la pantalla d'enviar missatge.
	 * @return Una cadena associada a un Result d'Struts2.
	 */
	@SkipValidation
	public String mostrarEnviarMissatge(){
		/*retorna la cadena de control*/
		return "MOSTRA";
	}
	/**
	 * Mètode que dona accès a la capa de control.
	 * @return Un objecte de tipus managerMissatge.
	 */
	public managerMissatge getManager(){
		return new managerMissatge();		
	}
}