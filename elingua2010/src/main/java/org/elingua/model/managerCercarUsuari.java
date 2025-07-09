package org.elingua.model;



import org.elingua.DAO.UsuarisDAO;
import org.elingua.DAO.IdiomesDAO;
import org.elingua.model.Idiomes;
import org.elingua.model.UsuariIdiomaEstudiat;
import org.elingua.model.UsuariIdiomaParlat;
import org.elingua.model.Usuaris;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Classe de la capa model que fa d'intermediari entre CercarUsuariAction i les DAO corresponents.  
 * @author Marina Martin
 * @version 1.0
 * @see org.elingua.control.CercarUsuariAction
 */

public class managerCercarUsuari {
	/**Contructor per defecte*/
	public managerCercarUsuari(){		
		
	}
	/**
	 * Troba les dades dels usuaris mitjançant un idioma que estudia.
	 * @param idiomesSeleEst L'idioma que l'usuari estudia.
	 * @return La llista amb els noms d'usuari.  
	 */
	public List<String> cercarUsuariPerIdiEst(String idiomesSeleEst){
		/*creem una DAO d'idiomes*/
		IdiomesDAO dao2 = new IdiomesDAO();
		/*recuperem el registre mitjançant el nom de l'idioma*/
		List<Idiomes> idiomes = dao2.findByNom(idiomesSeleEst);
		Iterator<Idiomes> ite = idiomes.iterator();
		/*guardem el registre com un objecte de tipus Idiomes*/
		Idiomes idioma = ite.next();
		/*guardem la llista d'usuaris que estudian l'idioma*/
		Set<UsuariIdiomaEstudiat> usuarisSet = idioma.getUsuariIdiomaEstudiats();
		Iterator it2 = usuarisSet.iterator();
		/*creem una llista per guardar els usuaris*/
		List<String> usuaris = new ArrayList();
		/*recorrem la llista d'usuaris*/
		while(it2.hasNext()){
			UsuariIdiomaEstudiat usuarisIdiEst = (UsuariIdiomaEstudiat) it2.next();
			Usuaris usu = usuarisIdiEst.getUsuaris();
			/*comprovem si tenen activat la privadesa*/
			if(usu.getPrivacitat() == false){
				/*si no tenen privadesa llavors els podem llistar*/
				usuaris.add(usu.getNomUsuari());
			}
		}
		/*tanquem la sessió (lliberem les conexions)*/
		dao2.getSession().close();
		/*retornem la llista d'usuaris*/
		return usuaris;
	
	}
	/**
	 * Troba les dades dels usuaris mitjançant un idioma que coneix.
	 * @param idiomesSeleSap L'idioma que l'usuari coneix.
	 * @return La llista amb els noms d'usuari. 
	 */
public List<String> cercarUsuariPerIdiSap(String idiomesSeleSap){
		/*creem una DAO d'idiomes*/
		IdiomesDAO dao = new IdiomesDAO();
		/*recuperem el registre mitjançant el nom de l'idioma*/
		List<Idiomes> idiomes = dao.findByNom(idiomesSeleSap);
		Iterator it = idiomes.iterator();
		/*guardem el registre en un objecte de tipus Idiomes*/
		Idiomes idioma = (Idiomes) it.next();
		/*guardem un llista d'usuaris que parlen l'idioma*/
		Set<UsuariIdiomaParlat> usuaris = idioma.getUsuariIdiomaParlats();
		Iterator it2 = usuaris.iterator();
		/*creem un llista per guardar els usuaris*/
		List<String> resultat = new ArrayList();
		/*recorrem la llista d'usuaris*/
		while(it2.hasNext()){
			UsuariIdiomaParlat usuarisIdiSap = (UsuariIdiomaParlat) it2.next();
			Usuaris usu = usuarisIdiSap.getUsuaris();
			/*comprovem si tenen activat la privadesa*/
			if(usu.getPrivacitat() == false){
				/*si no tenen privadesa llavors els podem llistar*/
				resultat.add(usu.getNomUsuari());
			}
		}
		/*tanquem la sessió (lliberem les conexions)*/
		dao.getSession().close();
		/*retornem la llista d'usuaris*/
		return resultat;
	
	}
/**
 * Permet trobar un usuari donat el seu nom d'usuari. Si no el troba retorna null.
 * @param inputnom El nom de l'usuari a cercar.
 * @return El nom de l'usuari o null si no hi ha cap.
 */
	public String cercarUsuariPerNom(String inputnom){
		/*creem la DAO d'usuaris*/
		UsuarisDAO dao = new UsuarisDAO();		
		/*recuperem el registre mitjançant el nom de l'usuari*/
		List<Usuaris> usuari = dao.findByNomUsuari(inputnom);		
		/*tanquem la sessió (lliberem les conexions)*/
		dao.getSession().close();
		Iterator<Usuaris> ite = usuari.iterator();
		/*recorrem la llista d'usuaris*/
		if(ite.hasNext()){
			Usuaris usu = ite.next();
			/*comprovem si tenen activat la privadesa*/
			if(usu.getPrivacitat() == false){
				/*si no tenen privadesa llavors els podem llistar*/
				return usu.getNomUsuari();
			}
		}
		/*si no trobem cap retornem null*/
		return null;
		
		
	}
	/**
	 * Carrega els idiomes disponibles per a que l'administrador els gestioni.
	 * @return Els idiomes disponibles. 
	 */
	public List<String> carregarIdiomes(){
		/*creem la DAO d'usuaris*/
		IdiomesDAO dao = new IdiomesDAO();		
		/*recuperem tots els registres de la taula idiomes*/
		List<Idiomes> idiomesObj = dao.findAll();		
		/*tanquem la sessió (lliberem les conexions)*/
		dao.getSession().close();
		/*creem la llista on guardarem el nom dels idiomes*/
		List<String> idiomes = new ArrayList<String>();		
		Iterator<Idiomes> ite = idiomesObj.iterator();
		/*recorrem la llista d'idiomes*/
		while(ite.hasNext()){
			/*guardem en la llista el nom dels idiomes trobats*/
			idiomes.add(ite.next().getNom());
		}
		/*la llista amb els noms dels idiomes*/
		return idiomes;
		
	}
}
