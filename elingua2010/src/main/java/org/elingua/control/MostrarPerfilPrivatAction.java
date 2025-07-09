package org.elingua.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.elingua.model.Basics;
import org.elingua.model.Sessio;
import org.elingua.model.Usuaris;
import org.elingua.model.managerMostrarPerfil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * Classe MostrarPerfilPrivatAction que executa una lògica de negoci en particular en funció de la sol·licitud i els paràmetres d'entrada. 
 * 
 * @author Marina Martin
 * @version 1.0
 */
public class MostrarPerfilPrivatAction extends ActionSupport {
	/**Constructor per defecte */
	public MostrarPerfilPrivatAction(){
		
	}
	/**
	 * Acció que mostra el perfil privat de l'usuari.
	 * Aquest mètode sobrecarrega el mètode execute de ActionSupport.
	 * 
     * @return Retorna {@link #SUCCESS}
     */
	public String execute()  {
		/*carreguem el manager de mostrar el perfil privat de l'usuari*/
		managerMostrarPerfil mmp = getManager();
		/*cerquem i guardem les dades de l'usuari que ha iniciat sessió*/
		usuaris = mmp.cercarUsuari(nomUsuari);
		basics = mmp.cercarDades();
		llistaIdiSap = new ArrayList();
		llistaIdiSap.add(getText("perfilPrivat.llenguesSelec"));
		/*guardem la llista d'idiomes que l'usuari coneix*/
		Iterator cercarIdiSapIterator = mmp.cercarIdiSap().iterator();
		while(cercarIdiSapIterator.hasNext()){
			String idiSap = (String) cercarIdiSapIterator.next();
			llistaIdiSap.add(idiSap);
		}
		/*guardem la llista d'idiomes que l'usuari vol aprendre*/
		llistaIdiEst = new ArrayList();
		llistaIdiEst.add(getText("perfilPrivat.llenguesSelec"));
		Iterator cercarIdiEstIterator = mmp.cercarIdiEst().iterator();
		while(cercarIdiEstIterator.hasNext()){
			String idiEst = (String) cercarIdiEstIterator.next();
			llistaIdiEst.add(idiEst);
		}
		/*carreguem la llista d'idiomes disponibles*/
		idiomesLlista = mmp.carregarIdiomes();
		/*carreguem la segona contrasenya introduïda*/
		contrasenya2 = usuaris.getPsswd();
		/*carreguem l'objecte sessió associat a l'usuari*/
		Map session = ActionContext.getContext().getSession();
		Sessio sesio = (Sessio) session.get("usuari");
		String usua = sesio.getNomUsuari();
		/*guardem a la sessio del admin els idiomes que sap i apren l'usuari que estem modificant*/
		if(usua.equals("admin")){
			sesio.setIdiomesSap(llistaIdiSap);
			sesio.setIdiomesApren(llistaIdiEst);
		}
		/*carreguem els textos dels radio button per seleccionar el sexe*/
		sexesList.put("1",getText("perfilPrivat.sexeHome"));
		sexesList.put("2",getText("perfilPrivat.sexeDona"));
		
		/*carreguem els textos dels radio button per seleccionarl el tipus d'usuari*/
		tipusUsu.put("basic",getText("perfilPrivat.basic"));
		tipusUsu.put("collaborador",getText("perfilPrivat.collaborador"));
		/*retornem la cadena de control*/
		return "SUCCESS";
	}
	
	/**El nom d'usuari del perfil que s'està modificant */
	private String nomUsuari;
	/**El objecte de tipus Usuaris que emmagatzema les dades de l'usuari */
	private Usuaris usuaris;
	/**El objecte de tipus Basics que emmagatzema les dades de l'usuari bàsic */
	private Basics basics;
	/**Llista d'idiomes que l'usuari coneix */
	private List<String> llistaIdiSap;
	/**Llista d'idiomes que l'usuari estudia */
	private List<String> llistaIdiEst;
	/**La llista d'idiomes disponibles */
	private List<String> idiomesLlista;
	/**La segona contrasenya introduïda */
	private String contrasenya2;
	/**Cadena que emmagatzema si el perfil el modifica l'administrador */
	private String admin;
	/**Els textos del radio button per seleccionar el sexe */
	private Map<String,String> sexesList = new HashMap();
	/**Els textos del radio button per seleccionar el tipus d'usuari */
	private Map<String,String> tipusUsu = new HashMap();
	
	/**
	 * Mètode que dona accès a la propietat tipusUsu.
	 * @return Retorna els textos del radio button per seleccionar el tipus d'usuari.
	 */
	public Map<String, String> getTipusUsu() {
		return tipusUsu;
	}
	/**
	 * Mètode que estableix la propietat tipusUsu.
	 * @param tipusUsu Els textos del radio button per seleccionar el tipus d'usuari.
	 */
	public void setTipusUsu(Map<String, String> tipusUsu) {
		this.tipusUsu = tipusUsu;
	}
	/**
	 * Mètode que dona accès a la propietat sexesList.
	 * @return Retorna els textos del radio button per seleccionar el sexe.
	 */
	public Map<String, String> getSexesList() {
		return sexesList;
	}
	/**
	 * Mètode que estableix la propietat sexesList.
	 * @param sexesList Els textos del radio button per seleccionar el sexe.
	 */
	public void setSexesList(Map<String, String> sexesList) {
		this.sexesList = sexesList;
	}
	/**
	 * Mètode que dona accès a la propietat contrasenya2.
	 * @return Retorna la segona contrasenya introduïda.
	 */
	public String getContrasenya2() {
		return contrasenya2;
	}
	/**
	 * Mètode que estableix la propietat contrasenya2.
	 * @param contrasenya2 La segona contrasenya introduïda.
	 */
	public void setContrasenya2(String contrasenya2) {
		this.contrasenya2 = contrasenya2;
	}
	/**
	 * Mètode que dona accès a la propietat admin.
	 * @return Retorna la cadena que emmagatzema si el perfil el modifica l'administrador.
	 */
	public String getAdmin() {
		return admin;
	}
	/**
	 * Mètode que estableix la propietat admin.
	 * @param admin La cadena que emmagatzema si el perfil el modifica l'administrador.
	 */
	public void setAdmin(String admin) {
		this.admin = admin;
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
	 * Mètode que dona accès a la propietat nomUsuari.
	 * @return Retorna el nom d'usuari del perfil que s'està modificant.
	 */
	public String getNomUsuari() {
		return nomUsuari;
	}
	/**
	 * Mètode que estableix la propietat nomUsuari.
	 * @param nomUsuari El nom d'usuari del perfil que s'està modificant.
	 */
	public void setNomUsuari(String nomUsuari) {
		this.nomUsuari = nomUsuari;
	}
	/**
	 * Mètode que dona accès a la capa de control.
	 * @return Un objecte de tipus managerMostrarPerfil.
	 */
	public managerMostrarPerfil getManager(){
		return new managerMostrarPerfil();
	}
}