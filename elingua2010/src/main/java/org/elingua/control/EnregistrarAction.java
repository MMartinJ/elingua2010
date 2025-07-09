package org.elingua.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.elingua.model.Basics;
import org.elingua.model.Usuaris;
import org.elingua.model.managerEnregistrar;

/**
 * Classe EnregistrarAction que executa una lògica de negoci en particular en funció de la sol·licitud i els paràmetres d'entrada. 
 * 
 * @author Marina Martin
 * @version 1.0
 */

public class EnregistrarAction  extends ActionSupport implements Preparable {
	
	
	private static final long serialVersionUID = 1L;

	/**Constructor per defecte*/
	public EnregistrarAction(){
		/*carreguem la llista d'idiomes seleccionats*/
		selLlista = new ArrayList<String>();
		/*guardem el primer ítem per defecte ("llegües seleccionades")*/
		selLlista.add(getText("perfilPrivat.llenguesSelec"));
		
	}
	/**
	 * Acció que enregistra l'usuari.
	 * Aquest mètode sobrecarrega el mètode execute de ActionSupport.
	 * 
     *
     * @return Retorna {@link #SUCCESS}
     */
	public String execute()  {
		/*enregistrem l'usuari a la base de dades*/
		getManager().enregistrar();
		//estadistiques
		EstadistiquesAction estAct = new EstadistiquesAction();
		/*guardem la data de registre de l'usuari*/
	    estAct.guardarDataRegistre(usuari.getNomUsuari(),new Date());
	    /*retornem la cadena de control*/
		return "SUCCESS";
	}
	
	
	
	/**Un objecte de tipus Usuaris que emmagatzema l'informació de l'usuari */
	private Usuaris usuari; 
	/**Un objecte de tipus Basics que emmagatzema l'informació de l'usuari bàsic */
	private Basics basic;
	/**La segona contrasenya introduïda */
	private String contrasenya2;
	/**La llista d'idiomes disponibles */
	private List<String> idiomesLlista;
	/**L'informació per defecte en el quadre d'idiomes seleccionats */
	private List<String> selLlista;
	/**Llista dels idiomes seleccionats que coneix l'usuari */
	private List<String> idiomesSele;
	/**Llista dels idiomes seleccionats que vol apendre l'usuari */
	private List<String> idiomesSeleApren;
	/**Els textos del radio button per seleccionar el sexe */
	private Map<String,String> sexesList = new HashMap();
	
	
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
	 * Mètode que dona accès a la propietat idiomesSeleApren.
	 * @return Retorna la llista dels idiomes seleccionats que coneix l'usuari.
	 */
	public List<String> getIdiomesSeleApren() {
		return idiomesSeleApren;
	}
	/**
	 * Mètode que estableix la propietat idiomesSeleApren.
	 * @param idiomesSeleApren La llista dels idiomes seleccionats que coneix l'usuari.
	 */
	public void setIdiomesSeleApren(List<String> idiomesSeleApren) {
		this.idiomesSeleApren = idiomesSeleApren;
	}
	/**
	 * Mètode que dona accès a la propietat selLlista.
	 * @return Retorna l'informació per defecte en el quadre d'idiomes seleccionats.
	 */
	public List<String> getSelLlista() {
		return selLlista;
	}
	/**
	 * Mètode que estableix la propietat selLlista.
	 * @param selLlista L'informació per defecte en el quadre d'idiomes seleccionats
	 */
	public void setSelLlista(List<String> selLlista) {
		this.selLlista = selLlista;
	}
	/**
	 * Mètode que dona accès a la propietat idiomesSele.
	 * @return Retorna la llista dels idiomes seleccionats que coneix l'usuari.
	 */
	public List<String> getIdiomesSele() {
		return idiomesSele;
	}
	/**
	 * Mètode que estableix la propietat idiomesSele.
	 * @param idiomesSele Llista dels idiomes seleccionats que coneix l'usuari.
	 */
	public void setIdiomesSele(List<String> idiomesSele) {
		this.idiomesSele = idiomesSele;
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
	 * Mètode que dona accès a la propietat contrasenya2.
	 * @return Retorna la segona contrasenya introduïda
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
	 * Mètode que dona accès a la propietat usuari.
	 * @return Retorna un objecte de tipus Usuaris.
	 */
	public Usuaris getUsuari() {
		return usuari;
	}
	/**
	 * Mètode que estableix la propietat usuari.
	 * @param usuari El objecte de tipus Usuaris.
	 */
	public void setUsuari(Usuaris usuari) {
		this.usuari = usuari;
	}
	/**
	 * Mètode que dona accès a la propietat basic.
	 * @return Retorna un objecte de tipus Basics.
	 */
	public Basics getBasic() {
		return basic;
	}
	/**
	 * Mètode que estableix la propietat basic.
	 * @param basic El objecte de tipus Basics.
	 */
	public void setBasic(Basics basic) {
		this.basic = basic;
	}

	/**Mètode que valida les dades introduïdes al formulari */
	public void validate(){
		
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
		if (!getUsuari().getPsswd().equals(contrasenya2) ){			
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
		/*carreguem el manager de enregistrar*/
		managerEnregistrar mr = getManager();
		/*comprovem que no existeixi un altre usuari amb el mateix nom*/
		if ( mr.cercarUsuariPerNom(getUsuari().getNomUsuari())){
			/*si en trobem un, llavors mostrem un missatge d'error*/
			addFieldError("usuari.nom", getText( "usuari.exists"));
		} 
		
	
	}
	/**
	 * Mètode que dona accès a la capa de control.
	 * @return Un objecte de tipus managerEnregistrar.
	 */
	public managerEnregistrar getManager(){
		return new managerEnregistrar(getUsuari(),getBasic(),getIdiomesSele(),getIdiomesSeleApren());
	}
	/**
	 * Acció que mostra la pantalla d'enregistrament.
	 * @return Una cadena associada a un Result d'Struts2.
	 */
	@SkipValidation
	public String mostrar() {
		/*carreguem els textos dels radio button per seleccionar el sexe*/
		sexesList.put("1",getText("perfilPrivat.sexeHome"));
		sexesList.put("2",getText("perfilPrivat.sexeDona"));
		
		return "MOSTRAR";
	}
	/**
	 * Carrega el necessari abans de mostrar la pantalla d'enregistrament.
	 * Aquest mètode implementa el mètode prepare de la interfície Preparable.
	 */
	public void prepare() {
		/*carreguem els idiomes disponibles*/
		idiomesLlista = getManager().carregarIdiomes();
		/*carreguem els textos dels radio button per seleccionar el sexe*/
		sexesList.put("1",getText("perfilPrivat.sexeHome"));
		sexesList.put("2",getText("perfilPrivat.sexeDona"));
		/*carreguem la llista d'idiomes seleccionats*/
		selLlista = new ArrayList<String>();
		/*guardem el primer ítem per defecte ("llegües seleccionades")*/
		selLlista.add(getText("perfilPrivat.llenguesSelec"));
		
	}
	


}
