package org.elingua.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import org.elingua.model.Basics;
import org.elingua.model.Sessio;
import org.elingua.model.Usuaris;
import org.elingua.model.managerEnregistrar;
import org.elingua.model.managerMostrarPerfil;

/**
 * Classe ModificarPerfilAction que executa una lògica de negoci en particular en funció de la sol·licitud i els paràmetres d'entrada. 
 * 
 * @author Marina Martin
 * @version 1.0
 */
public class ModificarPerfilAction  extends ActionSupport implements Preparable {
	
	
	private static final long serialVersionUID = 1L;

	/**Constructor per defecte */
	public ModificarPerfilAction(){
		
	}
	/**
	 * Acció que modifica el perfil de l'usuari.
	 * Aquest mètode sobrecarrega el mètode execute de ActionSupport.
	 * 
     * @return Retorna {@link #SUCCESS}
     */
	public String execute()  {
		/*carreguem el nom de l'usuari*/
		setNomUsuari(usuaris.getNomUsuari());
		/*modifiquem el perfil de l'usuari*/
		getManager().modificarPerfil(getNomUsuari());
		/*si som l'Administrador redirigim cap a la pantalla d'Administració*/
		if(getAdmin().equals("admin")){
			/*retornem la cadena de control*/
			return "ADMIN";
		}
		/*retornem la cadena de control*/
		return "SUCCESS";
	}
	
	/**El objecte de tipus Usuaris que emmagatzema les dades de l'usuari */
	private Usuaris usuaris; 
	/**El objecte de tipus Basics que emmagatzema les dades de l'usuari bàsic */
	private Basics basics;
	/**La segona contrasenya introduïda */
	private String contrasenya2;
	/**El nom d'usuari del perfil que s'està modificant */
	private String nomUsuari;
	/**Llista dels idiomes seleccionats que coneix l'usuari */
	private List<String> idiomesSele;
	/**Llista dels idiomes seleccionats que vol apendre l'usuari */
	private List<String> idiomesSeleApren;
	/**Cadena que emmagatzema si el perfil el modifica l'administrador */
	private String admin;
	/**La llista d'idiomes disponibles */
	private List<String> idiomesLlista;
	/**Llista d'idiomes que l'usuari coneix */
	private List<String> llistaIdiSap;
	/**Llista d'idiomes que l'usuari estudia */
	private List<String> llistaIdiEst;
	/**Els textos del radio button per seleccionar el sexe */
	private Map<String,String> sexesList = new HashMap();
	/**Els textos del radio button per seleccionar el tipus d'usuari */
	private Map<String,String> tipusUsu = new HashMap();
	
	/**
	 * Mètode que dona accès a la propietat llistaIdiSap.
	 * @return Retorna una llista d'idiomes que l'usuari sap.
	 */
	public List<String> getLlistaIdiSap() {
		return llistaIdiSap;
	}
	/**
	 * Mètode que estableix la propietat llistaIdiSap.
	 * @param llistaIdiSap Una llista d'idiomes que l'usuari sap.
	 */
	public void setLlistaIdiSap(List<String> llistaIdiSap) {
		this.llistaIdiSap = llistaIdiSap;
	}
	/**
	 * Mètode que dona accès a la propietat llistaIdiEst.
	 * @return Retorna una llista d'idiomes que l'usuari està estudiant.
	 */
	public List<String> getLlistaIdiEst() {
		return llistaIdiEst;
	}
	/**
	 * Mètode que estableix la propietat llistaIdiEst.
	 * @param llistaIdiEst Una llista d'idiomes que l'usuari està estudiant.
	 */
	public void setLlistaIdiEst(List<String> llistaIdiEst) {
		this.llistaIdiEst = llistaIdiEst;
	}
	/**
	 * Mètode que dona accès a la propietat idiomesLlista.
	 * @return Retorna una llista d'idiomes disponibles.
	 */
	public List<String> getIdiomesLlista() {
		return idiomesLlista;
	}
	/**
	 * Mètode que estableix la propietat idiomesLlista.
	 * @param idiomesLlista Una llista d'idiomes disponibles.
	 */
	public void setIdiomesLlista(List<String> idiomesLlista) {
		this.idiomesLlista = idiomesLlista;
	}
	/**
	 * Mètode que dona accès a la propietat admin.
	 * @return Retorna una cadena que emmagatzema si el perfil el modifica l'administrador.
	 */
	public String getAdmin() {
		return admin;
	}
	/**
	 * Mètode que estableix la propietat admin.
	 * @param admin Una cadena que emmagatzema si el perfil el modifica l'administrador.
	 */
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	/**
	 * Mètode que dona accès a la propietat nomUsuari.
	 * @return Retorn el nom d'usuari del perfil que s'està modificant.
	 */
	public String getNomUsuari() {
		return nomUsuari;
	}
	/**
	 * Mètode que estableix la propietat nomUsuari.
	 * @param nomUsuari El nom d'usuari del perfil que està modificant.
	 */
	public void setNomUsuari(String nomUsuari) {
		this.nomUsuari = nomUsuari;
	}
	/**
	 * Mètode que dona accès a la propietat idiomesSeleApren.
	 * @return Retorna la llista dels idiomes seleccionats que vol apendre l'usuari
	 */
	public List<String> getIdiomesSeleApren() {
		return idiomesSeleApren;
	}
	/**
	 * Mètode que estableix la propietat idiomesSeleApren.
	 * @param idiomesSeleApren La llista del idiomes seleccionats que vol aprendre l'usuari.
	 */
	public void setIdiomesSeleApren(List<String> idiomesSeleApren) {
		this.idiomesSeleApren = idiomesSeleApren;
	}
	/**
	 * Mètode que dona accès a la propietat idiomesSele.
	 * @return Retorna la llista dels idiomes seleccionats que coneix l'usuari
	 */
	public List<String> getIdiomesSele() {
		return idiomesSele;
	}
	/**
	 * Mètode que estableix la propietat idiomesSele.
	 * @param idiomesSele La llista dels idiomes seleccionats que coneix l'usuari.
	 */
	public void setIdiomesSele(List<String> idiomesSele) {
		this.idiomesSele = idiomesSele;
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
	/**Mètode que valida les dades introduïdes al formulari */
	public void validate(){
		/*carreguem el manager d'enregistrar usuari*/
		managerEnregistrar me = getManager();
		/*Comprovem que l'usuari no seleccioni un idioma que parla per estudiar-lo*/
		Iterator idiomesSeleIterator = idiomesSele.iterator();
		Iterator idiomesSeleAprenIterator = idiomesSeleApren.iterator();
		/*recorrem els idiomes que coneix*/
		while(idiomesSeleIterator.hasNext()){
			String idiomesSeleString = (String) idiomesSeleIterator.next();
			/*recorrem els idiomes que vol estudiar*/
			while(idiomesSeleAprenIterator.hasNext()){
				/*comprovem que no siguin el mateix idioma*/
				if(idiomesSeleString.equals(idiomesSeleAprenIterator.next())){
					/*si es el mateix idioma llavors mostrem un error*/
					addFieldError( "idiomesSele", getText("idiomes.mateix") );
				}
			}
		}
		
		/*comprovem que les dues contrasenyes siguin iguals*/
		if (!getUsuaris().getPsswd().equals(contrasenya2) ){			
			addFieldError( "usuari.contrasenya", getText("contrasenya.diferent") );
		}
		/*comprovem si hi ha com a mínim un idioma seleccionat que parla*/
		if (idiomesSele.size() == 0){			
			addFieldError( "idiomesSele", getText("idiomesSele.buit") );
		}
		/*comprovem que com a mínim a seleccionat un idioma per aprendre*/
		if (idiomesSeleApren.size() == 0){			
			addFieldError( "idiomesSeleApren", getText("idiomesSeleApren.buit") );
		}
		
	}
	/**
	 * Mètode que dona accès a la capa de control.
	 * @return Un objecte de tipus managerEnregistrar.
	 */
	public managerEnregistrar getManager(){
		return new managerEnregistrar(getUsuaris(),getBasics(),getIdiomesSele(),getIdiomesSeleApren());
	}
	/**
	 * Carrega el necessari abans de mostrar la pantalla de modificar perfil.
	 * Aquest mètode implementa el mètode prepare de la interfície Preparable.
	 */
	public void prepare() {
		/*carrega la llista d'idiomes disponibles*/
		idiomesLlista = getManager().carregarIdiomes();
		/*carreguem el manager de mostrar perfil*/
		managerMostrarPerfil mmp = new managerMostrarPerfil();
		/*carreguem l'objecte sessió associat a l'usuari*/
		Map session = ActionContext.getContext().getSession();
		Sessio sesio = (Sessio) session.get("usuari");
		/*guardem el nom de l'usuari*/
		String usua = sesio.getNomUsuari();
		/*si es tracta de l'administrador carreguem la llista d'idiomes seleccionats*/
		if(usua.equals("admin")){
			/*quan l'administrador modifica el perfil, la llista d'idiomes seleccionats
			 *es guarda temporalment en el objecte sessió de l'administrador.
			 */
			llistaIdiSap = sesio.getIdiomesSap();
			llistaIdiEst = sesio.getIdiomesApren();
		}
		/*si som un usuari normal*/
		else{
			/*carreguem la llista d'idiomes seleccionats que coneixem*/
			llistaIdiSap = new ArrayList();
			/*introduïm el text per defecte del primer ítem de la llista ("llengües seleccionades")*/
			llistaIdiSap.add(getText("perfilPrivat.llenguesSelec"));
			/*guardem la llista d'idiomes que coneixem*/
			Iterator cercarIdiSapIterator = mmp.cercarIdiSap(usua).iterator();
			while(cercarIdiSapIterator.hasNext()){
				String idiSap = (String) cercarIdiSapIterator.next();
				llistaIdiSap.add(idiSap);
			}
			/*carreguem la llista d'idiomes seleccionats per aprendre*/
			llistaIdiEst = new ArrayList();
			/*introduïm el text per defecte del primer ítem de la llista ("llengües seleccionades")*/
			llistaIdiEst.add(getText("perfilPrivat.llenguesSelec"));
			/*guardem la llista d'idiomes que volem aprendre*/
			Iterator cercarIdiEstIterator = mmp.cercarIdiEst(usua).iterator();
			while(cercarIdiEstIterator.hasNext()){
				String idiEst = (String) cercarIdiEstIterator.next();
				llistaIdiEst.add(idiEst);
			}
		}
		/*carreguem els textos dels radio button per seleccionar el sexe*/
		sexesList.put("1",getText("perfilPrivat.sexeHome"));
		sexesList.put("2",getText("perfilPrivat.sexeDona"));
		
		/*carreguem els textos dels radio button per seleccionarl el tipus d'usuari*/
		tipusUsu.put("basic",getText("perfilPrivat.basic"));
		tipusUsu.put("collaborador",getText("perfilPrivat.collaborador"));
		
	}

}
