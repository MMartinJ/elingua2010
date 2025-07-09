package org.elingua.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.elingua.DAO.*;
import org.elingua.control.EstadistiquesAction;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
/**
 * Classe de la capa model que fa d'intermediari entre MissatgeAction i les DAO corresponents.  
 * @author Marina Martin
 * @version 1.0
 * @see org.elingua.control.MissatgeAction
 */
public class managerMissatge {
	/**
	 * Desa el missatge que un usuari envia a un altre.
	 * @param destinatari El destinatari del missatge.
	 * @param assumpte El assumpte del missatge.
	 * @param missatge El contingut del missatge.
	 */
	public void guardarMissatge(String destinatari, String assumpte,String missatge){
		/*guardem un objecte Usuaris amb el destinatari*/
		Usuaris desti = cercarUsuari(destinatari);
		/*recuperem el objecte sessió associat a l'usuari*/
		Map session = ActionContext.getContext().getSession();
		Sessio user = (Sessio) session.get("usuari");
		/*guardem el nom de l'usuari que ha enviat el missatge*/
		Usuaris emissor = cercarUsuari(user.getNomUsuari());
		/*creem un objecte amb les dades del missatge*/
		Missatges mail = new Missatges(desti,emissor,assumpte,missatge);
		/*creem una DAO de missatges*/
		MissatgesDAO dao1 = new MissatgesDAO();
		/*comencem la transacció*/
		Transaction tx1 = dao1.getSession().beginTransaction();
		/*guardem el missatge*/
		dao1.save(mail);
		/*acabem la transacció (es realitzen els canvis a la base de dades)*/
		tx1.commit();
		/*tanquem la sessió (lliberem les conexions)*/
		dao1.getSession().close();
		
		
	}
	/**
	 * Troba un usuari mitjançant el seu nom d'usuari.
	 * @param usuari El nom de l'usuari que cerquem.
	 * @return El objecte Usuaris asociat a l'usuari.
	 */
	public Usuaris cercarUsuari(String usuari){
		
		/*creem una DAO d'usuaris*/
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
	 * Recupera el missatge pendent de llegir de l'usuari. 
	 * @param nomUsuari El nom de l'usuari que té un missatge.
	 * @return Una llista de dades del missatge. Si no en troba retorna un missatge predeterminat.
	 */
	public List<String> agafarMissatge(String nomUsuari){
		/*creem la DAO d'usuaris*/
		UsuarisDAO dao = new UsuarisDAO();
		
		/*recuperem el registre mitjançant el nom de l'usuari*/
		List<Usuaris> usuariList = dao.findByNomUsuari(nomUsuari);		
		Iterator<Usuaris> ite = usuariList.iterator();
		/*recuperem els missatges que té pendents de llegir l'usuari*/
		Set missatgesList = ite.next().getMissatgesesForReceptor();		
		Iterator<Missatges> ite2 = missatgesList.iterator();
		/*creem una llista que guardarà les dades del missatge*/
		List<String> missatges = new ArrayList<String>();
		if(ite2.hasNext()){
			Missatges missatge = ite2.next();
			/*guardem les dades del missatge*/
			missatges.add(missatge.getUsuarisByEmissor().getNomUsuari());			
			missatges.add(missatge.getAssumpte());			
			missatges.add(missatge.getContingut());
			/*creem la DAO de missatges*/
			MissatgesDAO dao2 =  new MissatgesDAO();
			/*comencem la transacció*/
			Transaction tx1 = dao2.getSession().beginTransaction();
			/*eliminem el missatge una vegada ja carregat*/
			dao2.delete(missatge);
			/*acabem la transacció (es realitzen els canvis a la base de dades)*/
			tx1.commit();
			/*tanquem la sessió (lliberem les conexions)*/
			dao2.getSession().close();
			//Estadistiques
			EstadistiquesAction estAct = new EstadistiquesAction();
			/*invoquem al mètode d'estadistiques per que augmenti el nombre de missatges llegits*/
			estAct.guardarMissatgeLlegit();
			
		}
		else{
			/*si no hi ha missatges retornem aquest missatge per defecte*/
			missatges.add("");
			missatges.add("");
			missatges.add("No hi ha missatges.");
		}
		/*tanquem la sessió (lliberem les conexions)*/
		dao.getSession().close();
		/*retornem les dades del missatge*/
		return missatges;
	}
	
	
}
