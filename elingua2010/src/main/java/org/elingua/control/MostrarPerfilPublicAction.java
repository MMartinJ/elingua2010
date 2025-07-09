package org.elingua.control;

import java.util.List;

import org.elingua.model.Basics;
import org.elingua.model.Usuaris;
import org.elingua.model.managerMostrarPerfil;

import com.opensymphony.xwork2.ActionSupport;
/**
 * Classe MostrarPerfilPublicAction que executa una lògica de negoci en particular en funció de la sol·licitud i els paràmetres d'entrada. 
 * 
 * @author Marina Martin
 * @version 1.0
 */
public class MostrarPerfilPublicAction extends ActionSupport {
	/**Constructor per defecte */
	public MostrarPerfilPublicAction(){
				
	}
	/**
	 * Acció que mostra el perfil public de l'usuari.
	 * Aquest mètode sobrecarrega el mètode execute de ActionSupport.
	 * 
     * @return Retorna {@link #SUCCESS}
     */
	public String execute()  {
		/*carreguem el manager de mostrar el perfil públic a l'usuari*/
		managerMostrarPerfil mmp = getManager();
		/*cerquem les dades de l'usuari propietari del perfil*/
		usuaris = mmp.cercarUsuari(usuari);
		basics = mmp.cercarDades();
		llistaIdiSap = mmp.cercarIdiSap();
		llistaIdiEst = mmp.cercarIdiEst();
		/*retornem la cadena de control*/
		return "SUCCESS";
	}
	
	/**El nom d'usuari del propietari del perfil públic */
	private String usuari;
	/**L'objecte de tipus Usuaris que emmagatzema les dades de l'usuari */
	private Usuaris usuaris;
	/**L'objecte de tipus Basics que emmagatzema les dades de l'usuari bàsic */
	private Basics basics;
	/**La llista d'idiomes que l'usuari coneix */
	private List<String> llistaIdiSap;
	/**La llista d'idiomes que l'usuari està estudiant */
	private List<String> llistaIdiEst;
	
	/**
	 * Mètode que dona accès a la propietat llistaIdiSap.
	 * @return Retorna la llista d'idiomes que l'usuari coneix.
	 */
	public List<String> getLlistaIdiSap() {
		return llistaIdiSap;
	}
	/**
	 * Mètode que estableix la propietat llistaIdiSap.
	 * @param llistaIdiSap La llista d'idiomes que l'usuari coneix.
	 */
	public void setLlistaIdiSap(List<String> llistaIdiSap) {
		this.llistaIdiSap = llistaIdiSap;
	}
	/**
	 * Mètode que dona accès a la propietat llistaIdiEst.
	 * @return Retorna la llista d'idiomes que l'usuari estudia.
	 */
	public List<String> getLlistaIdiEst() {
		return llistaIdiEst;
	}
	/**
	 * Mètode que estableix la propietat llistaIdiEst.
	 * @param llistaIdiEst La llista d'idiomes que l'usuari estudia.
	 */
	public void setLlistaIdiEst(List<String> llistaIdiEst) {
		this.llistaIdiEst = llistaIdiEst;
	}
	/**
	 * Mètode que dona accès a la propietat basics.
	 * @return Retorna el objecte de tipus Basics que emmagatzema les dades de l'usuari bàsic.
	 */
	public Basics getBasics() {
		return basics;
	}
	/**
	 * Mètode que estableix la propietat basics.
	 * @param basics El objecte de tipus Basics que emmagatzema les dades de l'usuari bàsic.
	 */
	public void setBasics(Basics basics) {
		this.basics = basics;
	}
	/**
	 * Mètode que dona accès a la propietat usuaris.
	 * @return Retorna el objecte de tipus Usuaris que emmagatzema les dades de l'usuari.
	 */
	public Usuaris getUsuaris() {
		return usuaris;
	}
	/**
	 * Mètode que estableix la propietat usuaris.
	 * @param usuaris El objecte de tipus Usuaris que emmagatzema les dades de l'usuari.
	 */
	public void setUsuaris(Usuaris usuaris) {
		this.usuaris = usuaris;
	}
	/**
	 * Mètode que dona accès a la propietat usuari.
	 * @return Retorna el nom d'usuari del propietari del perfil públic.
	 */
	public String getUsuari() {
		return usuari;
	}
	/**
	 * Mètode que estableix la propietat usuari.
	 * @param usuari El nom d'usuari del propietari del perfil públic.
	 */
	public void setUsuari(String usuari) {
		this.usuari = usuari;
	}
	/**
	 * Mètode que dona accès a la capa de control.
	 * @return Un objecte de tipus managerMostrarPerfil.
	 */
	public managerMostrarPerfil getManager(){
		return new managerMostrarPerfil();
	}
}