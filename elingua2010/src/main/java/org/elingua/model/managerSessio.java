package org.elingua.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.elingua.DAO.UsuarisDAO;


/**
 * Classe de la capa model que fa d'intermediari entre SessioAction i les DAO corresponents.  
 * @author Marina Martin
 * @version 1.0
 * @see org.elingua.control.SessioAction
 */
public class managerSessio {
	
	Usuaris usuari;
	/**Contructor per defecte*/
	public managerSessio(){
		
	}
	/**
	 * Comprova les dades introduides en el login. 
	 * @param inputnom El nom de l'usuari a loguejar.
	 * @param inputcontrasenya La contrasenya amb la que es logueja.
	 * @return Un booleà que retorna true o false depenent de si les dades son correctes o no.
	 */
	public Boolean usuariCheck(String inputnom,String inputcontrasenya){
		/*creem la DAO d'usuaris*/
		UsuarisDAO dao = new UsuarisDAO();
		
		/*recuperem el registre mitjançant el nom de l'usuari*/
		List usuariList = dao.findByNomUsuari(inputnom);
		
		/*tanquem la sessió (lliberem les conexions)*/
		dao.getSession().close();		
		Iterator<Usuaris> ite = usuariList.iterator();
		/*booleà que ens indica si l'usuari existeix*/
		boolean existeixUsu = false;
		while(ite.hasNext()){
			 usuari = ite.next();
			 /*si existeix l'usuari posem a true*/
			 existeixUsu = true;
		}
		/*comprovem la contrasenya*/
		if(existeixUsu){
			if(usuari.getPsswd().equals(inputcontrasenya)){
				/*les dades son correctes*/
				return false;
			}
			else{
				/*la contrasenya no es correcta*/
				return true;
			}
		}
		else{
			/*no existeix l'usuari*/
			return true;
		}
		
	}
	/**
	 * Mètode que crea un objecte sessió d'un usuari.
	 * @param inputnom El nom de l'usuari del que volem l'objecte de sessió.
	 * @return L'objecte sessió associat a l'usuari.
	 */
	public Sessio crearSessio(String inputnom){
		/*creem la DAO d'usuaris*/
		UsuarisDAO dao = new UsuarisDAO();
		/*recuperem el registre mitjançant el nom de l'usuari*/
		List usuariList = dao.findByNomUsuari(inputnom);
		
		
		/*recuperem l'objecte usuari i treiem el seu id per accedir a les llistes de idiomes*/
		Iterator it = usuariList.iterator();
		Usuaris usu = (Usuaris) it.next();
		int numUsuari = usu.getIdUsuari();
		Set idiomesParlats = usu.getUsuariIdiomaParlats();
		/*accedim a la llista d'idiomes parlats i estudiats*/
		List<String> usuariIdiParlats = new ArrayList<String>();
		Iterator it2 = idiomesParlats.iterator();
		while(it2.hasNext()){
			UsuariIdiomaParlat usuariIdiPar = (UsuariIdiomaParlat) it2.next();
			usuariIdiParlats.add(usuariIdiPar.getIdiomes().getNom());
		}
		Set idiomesApren = usu.getUsuariIdiomaEstudiats();
		List<String> usuariIdiApren = new ArrayList<String>();
		Iterator it3 = idiomesApren.iterator();
		while(it3.hasNext()){
			UsuariIdiomaEstudiat usuariIdiAp = (UsuariIdiomaEstudiat) it3.next();
			usuariIdiApren.add(usuariIdiAp.getIdiomes().getNom());
		}
		/*tanquem la sessió (lliberem les conexions)*/
		dao.getSession().close();
		/*creem un objecte sessio amb les dades que hem recuperat*/
		Sessio sessio = new Sessio(numUsuari,usu.getNomUsuari(),usu.getTipus(),usuariIdiParlats,usuariIdiApren);
		/*retornem l'objecte sessió*/
		return sessio;
				
	}	
}
