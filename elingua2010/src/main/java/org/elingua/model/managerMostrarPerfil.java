package org.elingua.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.elingua.DAO.*;
import org.elingua.model.*;
/**
 * Classe de la capa model que fa d'intermediari entre MostrarPerfilPublicAction i MostrarPerfilPrivatAction i les DAO corresponents.  
 * @author Marina Martin
 * @version 1.0
 * @see org.elingua.control.MostrarPerfilPublicAction
 * @see org.elingua.control.MostrarPerfilPrivatAction
 */
public class managerMostrarPerfil {
	String usuari;
	/**
	 * Troba un usuari mitjançant el seu nom d'usuari.
	 * @param usuari El nom de l'usuari que cerquem.
	 * @return El objecte Usuaris asociat a l'usuari.
	 */
	public Usuaris cercarUsuari(String usuari){
		 this.usuari = usuari;
		/*creem la DAO d'usuaris*/
		UsuarisDAO dao = new UsuarisDAO();
		/*recuperem el registre mitjançant el nom de l'usuari*/
		List<Usuaris> usuariList = dao.findByNomUsuari(usuari);
		/*tanquem la sessió (lliberem les conexions)*/
		dao.getSession().close();		
		Iterator<Usuaris> ite = usuariList.iterator();
		/*retornem l'usuari trobat*/
		return (Usuaris) ite.next();		
		
	}
	/**
	 * Troba les dades del perfil de l'usuari. 
	 * @return Les dades del perfil de l'usuari logejat.
	 */
	public Basics cercarDades(){
		 
		/*creem la DAO d'usuaris*/
		UsuarisDAO dao = new UsuarisDAO();
		
		/*recuperem el registre mitjançant el nom de l'usuari*/
		List<Usuaris> usuariList = dao.findByNomUsuari(usuari);		
		Iterator<Usuaris> ite = usuariList.iterator();		
		Usuaris usu = (Usuaris) ite.next();
		
		Basics bas;
		/*si l'usuari es de tipus bàsic*/
		if(usu.getTipus().equals("basic")){
			/*recuperem el registre de la taula basics*/
			Set basList = usu.getBasicses();
			
			Iterator<Basics> ite2 = basList.iterator();
			
			bas = ite2.next();
		}
		/*si es un usuari de tipus col·laborador*/
		else{
			/*recuperem el registre de la taula collaboradors*/
			Set basList = usu.getCollaboradorses();			
			Iterator<Collaboradors> ite2 = basList.iterator();			
			Collaboradors col = ite2.next();			
			bas = new Basics(usu, col.getNom(), col.getCognom1(),
					col.getCognom2(), col.getSexe(), col.getDataNaix(), col.getEmail());
		}		
		/*tanquem la sessió (lliberem les conexions)*/
		dao.getSession().close();
		/*retornem les dades de l'usuari*/
		return bas;		
		
	}
	/**
	 * Troba els idiomes que l'usuari coneix.
	 * @return La llista amb els idiomes que l'usuari coneix.
	 */
	public List<String> cercarIdiSap(){
		/*creem la dAO d'usuaris*/
		UsuarisDAO dao = new UsuarisDAO();
		/*recuperem el registre mitjançant el nom de l'usuari*/
		List<Usuaris> usuariList = dao.findByNomUsuari(usuari);				
		Iterator<Usuaris> ite = usuariList.iterator();
		/*recuperem la llista d'idiomes parlats per l'usuari*/
		Set usuIdiSapList = ite.next().getUsuariIdiomaParlats();		
		Iterator<UsuariIdiomaParlat> ite2 = usuIdiSapList.iterator();		
		List<String> resultat = new ArrayList();
		/*recorrem la llista*/
		while(ite2.hasNext()){
			UsuariIdiomaParlat usuIdiSap = ite2.next();
			/*guadem el nom de l'idioma a la llista*/
			resultat.add(usuIdiSap.getIdiomes().getNom());
		}
		/*tanquem la sessió (lliberem les conexions)*/		
		dao.getSession().close();
		/*retornem la llista d'idiomes que parla*/
		return resultat;
		
		
	}
	/**
	 * Troba els idiomes que l'usuari estudia.
	 * @return La llista amb els idiomes que l'usuari estudia.
	 */
	public List<String> cercarIdiEst(){
		/*creem la DAO d'usuaris*/
		UsuarisDAO dao = new UsuarisDAO();
		/*recuperem el registre mitjançant el nom de l'usuari*/
		List<Usuaris> usuariList = dao.findByNomUsuari(usuari);		
		Iterator<Usuaris> ite = usuariList.iterator();
		/*recuperem els idiomes que està estudiant l'usuari*/
		Set usuIdiEstList = ite.next().getUsuariIdiomaEstudiats();		
		Iterator<UsuariIdiomaEstudiat> ite2 = usuIdiEstList.iterator();		
		List<String> resultat = new ArrayList();
		/*recorrem la llista d'idiomes que està estudiant*/
		while(ite2.hasNext()){
			UsuariIdiomaEstudiat usuIdiEst = ite2.next();
			/*guardem el nom de l'idioma a la llista*/
			resultat.add(usuIdiEst.getIdiomes().getNom());
		}		
		/*tanquem la sessió (lliberem les conexions)*/
		dao.getSession().close();
		/*retornem la llista amb els noms dels idiomes que està estudiant*/
		return resultat;
		
		
	}
	/**
	 * Carrega els idiomes disponibles per a que l'usuari pugui triar.
	 * @return Els idiomes disponibles. 
	 */
	public List<String> carregarIdiomes(){
		/*creem la DAO d'idiomes*/
		IdiomesDAO dao = new IdiomesDAO();
		/*recuperem tots els registres de la taula idiomes*/
		List<Idiomes> idiomesObj = dao.findAll();
		/*tanquem la sessió (lliberem les conexions)*/
		dao.getSession().close();
		/*creem una llista per guardar el nom dels idiomes*/
		List<String> idiomes = new ArrayList<String>();		
		Iterator<Idiomes> ite = idiomesObj.iterator();
		/*recorrem la llista d'idiomes*/
		while(ite.hasNext()){
			idiomes.add(ite.next().getNom());
		}
		/*retornem la llista dels idiomes*/
		return idiomes;
		
	}
	/**
	 * Troba els idiomes que l'usuari coneix.
	 * @param usua El nom de l'usuari del que volem l'informació.
	 * @return La llista amb els idiomes que l'usuari coneix.
	 */
	public List<String> cercarIdiSap(String usua){
		/*creem la dao d'usuaris*/
		UsuarisDAO dao = new UsuarisDAO();
		
		/*recuperem el registre mitjançant el nom de l'usuari*/
		List<Usuaris> usuariList = dao.findByNomUsuari(usua);		
		Iterator<Usuaris> ite = usuariList.iterator();
		/*recuperem la llista dels idiomes parlats per l'usuari*/
		Set usuIdiSapList = ite.next().getUsuariIdiomaParlats();		
		Iterator<UsuariIdiomaParlat> ite2 = usuIdiSapList.iterator();		
		List<String> resultat = new ArrayList();
		/*recorrem la llista d'idiomes parlats*/
		while(ite2.hasNext()){
			UsuariIdiomaParlat usuIdiSap = ite2.next();
			/*guardem el nom dels idiomes*/
			resultat.add(usuIdiSap.getIdiomes().getNom());
		}
		/*tanquem la sessió (lliberem les conexions)*/
		dao.getSession().close();
		/*retornem la llista amb el nom dels idiomes que l'usuari parla*/
		return resultat;
		
		
	}
	/**
	 * Troba els idiomes que l'usuari estudia.
	 * @param usua El nom de l'usuari del que volem l'informació.
	 * @return La llista amb els idiomes que l'usuari estudia.
	 */
	public List<String> cercarIdiEst(String usua){
		/*creem la DAO d'usuaris*/
		UsuarisDAO dao = new UsuarisDAO();
		
		/*recuperem el registre mitjançant el nom de l'usuari*/
		List<Usuaris> usuariList = dao.findByNomUsuari(usua);		
		Iterator<Usuaris> ite = usuariList.iterator();
		/*recuperem la llista d'idiomes estudiats per l'usuari*/
		Set usuIdiEstList = ite.next().getUsuariIdiomaEstudiats();		
		Iterator<UsuariIdiomaEstudiat> ite2 = usuIdiEstList.iterator();		
		List<String> resultat = new ArrayList();
		/*recorrem la llista d'idiomes estudiats*/
		while(ite2.hasNext()){
			UsuariIdiomaEstudiat usuIdiEst = ite2.next();
			/*guardem el nom dels idiomes*/
			resultat.add(usuIdiEst.getIdiomes().getNom());
		}
		/*tanquem la sessió (lliberem les conexions)*/
		dao.getSession().close();
		/*retornem la llista amb el nom dels idiomes que l'usuari està estudiant*/
		return resultat;
		
		
	}
	
}
