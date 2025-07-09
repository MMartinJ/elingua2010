package org.elingua.model;



import org.elingua.DAO.UsuarisDAO;
import org.elingua.DAO.IdiomesDAO;
import org.elingua.model.Idiomes;
import org.elingua.model.Usuaris;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe de la capa model que fa d'intermediari entre AdministrarAction i les DAO corresponents.  
 * @author Marina Martin
 * @version 1.0
 * @see org.elingua.control.AdministrarAction
 */

public class managerAdministrar {
	
	/**Constructor per defecte */
	public managerAdministrar(){
	}
	/**
	 * Carrega els idiomes disponibles per a que l'administrador els gestioni.
	 * @return Els idiomes disponibles. 
	 */
	public List<String> carregarIdiomes(){
		/*Creem la DAO d'idiomes*/
		IdiomesDAO dao = new IdiomesDAO();		
		/*guardem la llista de tots els registres de la taula d'idiomes*/ 
		List<Idiomes> idiomesObj = dao.findAll();		
		/*tanquem la sessió*/
		dao.getSession().close();
		/*creem una llista per guardar els noms del idiomes*/
		List<String> idiomes = new ArrayList<String>();		
		Iterator<Idiomes> ite = idiomesObj.iterator();
		/*recorrem la llista dels idiomes*/
		while(ite.hasNext()){
			String idiomaNom = ite.next().getNom();
			/*guardem a la llista els noms del idiomes*/
			idiomes.add(idiomaNom);			
		}
		/*retornem la llista dels idiomes*/
		return idiomes;		
	}
	/**
	 * Els usuaris registrats es llisten a l'administrador per a que els gestioni.
	 * @return La llista d'usuaris registrats amb les seves dades. 
	 */
	public List<List> llistarUsuaris(){
		/*creem una llista de llistes per guardar les dades dels usuaris*/
		List<List> usuaris = new ArrayList();		
		/*creem una DAO d'usuaris*/
		UsuarisDAO usuarisDao = new UsuarisDAO();
		/*guardem en una llista tots el registres de la taula usuaris*/
		List<Usuaris> usuarisList = usuarisDao.findAll();
		Iterator usuarisListIterator = usuarisList.iterator();
		/*recorrem la llista d'usuaris*/
		while(usuarisListIterator.hasNext()){
			/*creem una llista que emmagatzema les dades d'un usuari*/
			List<String> camps = new ArrayList();
			/*guardem el registre convertit en un objecte Usuaris*/
			Usuaris usuari = (Usuaris) usuarisListIterator.next();
			/*no llistem l'usuari administrador*/
			if(!usuari.getNomUsuari().equals("admin")){
				/*guardem les dades en la llista*/
				camps.add(usuari.getNomUsuari());
				camps.add(usuari.getTipus());
				camps.add(usuari.getNomUsuari());
				camps.add(usuari.getNomUsuari());
				/*finalment guardem la llista de dades dins una llista d'usuaris*/
				usuaris.add(camps);
			}
		}
		/*retornem una llista de llistes amb les dades dels usuaris*/
		return usuaris;
	}
	/**
	 * Mètode que permet a l'administrador eliminar un usuari pel seu nom d'usuari.
	 * @param nomUsuari El nom de l'usuari per eliminar.
	 */
	public void eliminarUsuaris(String nomUsuari){
		/*creem una DAO d'usuaris*/
		UsuarisDAO usuarisDao = new UsuarisDAO();
		/*recuperem el registre mitjançant el nom de l'usuari*/
		List<Usuaris> usuarisList = usuarisDao.findByNomUsuari(nomUsuari);
		Iterator usuarisListIterator = usuarisList.iterator();
		/*convertim el registre en un objecte de tipus Usuaris*/
		Usuaris usuari = (Usuaris) usuarisListIterator.next();
		/*comencem la transacció*/
		Transaction tx = usuarisDao.getSession().beginTransaction();		
		/*eliminem l'usuari*/
		usuarisDao.delete(usuari);		
		/*acabem la transacció (es realitzen els canvis a la base de dades)*/
		tx.commit();		
		/*tanquem la sessió (lliberem les conexions)*/
		usuarisDao.getSession().close();	
	}
	/**
	 * Mètode que permet a l'administrador afegir un nou idioma.
	 * @param nomIdioma El nom de l'idioma que volem afegir.
	 */
	public void afegeixIdioma(String nomIdioma){
		/*creem un nou objecte idioma amb el nom de l'idioma*/
		Idiomes idioma = new Idiomes(nomIdioma);
		/*creem una DAO d'idiomes*/
		IdiomesDAO idiomesDao = new IdiomesDAO();
		/*comencem la transacció*/
		Transaction tx = idiomesDao.getSession().beginTransaction();
		/*guardem el nou objecte idioma a la base de dades*/
		idiomesDao.save(idioma);
		/*acabem la transacció (es realitzen els canvis a la base de dades)*/
		tx.commit();
		/*tanquem la sessió (lliberem les conexions)*/
		idiomesDao.getSession().close();
	}
	/**
	 * Mètode que permet a l'administrador eliminar un idioma seleccionat.
	 * @param nomIdiomaEliminar El nom de l'idioma que volem eliminar.
	 */
	public void eliminarIdioma(String nomIdiomaEliminar){
		/*creem una DAO d'idiomes*/
		IdiomesDAO idiomesDao = new IdiomesDAO();
		/*recuperem el registre mitjançant el nom de l'idioma*/
		List<Idiomes> idiomesList= idiomesDao.findByNom(nomIdiomaEliminar);
		Iterator idiomesListIterator = idiomesList.iterator();
		/*guardem el registre com un objecte de tipus idiomes*/
		Idiomes idiomes = (Idiomes) idiomesListIterator.next();
		/*comencem la transacció*/
		Transaction tx = idiomesDao.getSession().beginTransaction();
		/*eliminem el registre mitjançant el objecte que hem recuperat*/
		idiomesDao.delete(idiomes);
		/*acabem la transacció (es realitzen els canvis a la base de dades)*/
		tx.commit();
		/*tanquem la sessió (lliberem les conexions)*/
		idiomesDao.getSession().close();
	}
	public boolean checkIdioma(String nomIdioma){
		/*creem una DAO d'idiomes*/
		IdiomesDAO idiomesDao = new IdiomesDAO();
		/*recuperem el registre mitjançant el nom de l'idioma*/
		List<Idiomes> idiomesList= idiomesDao.findByNom(nomIdioma);
		Iterator idiomesListIterator = idiomesList.iterator();
		/*comprovem si l'idioma existeix*/
		if(idiomesListIterator.hasNext()){
			return true;
		}
		return false;
	}
}
