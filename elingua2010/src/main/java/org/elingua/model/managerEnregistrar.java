package org.elingua.model;


import org.elingua.DAO.BasicsDAO;
import org.elingua.DAO.CollaboradorsDAO;
import org.elingua.DAO.UsuariIdiomaEstudiatDAO;
import org.elingua.DAO.UsuariIdiomaParlatDAO;
import org.elingua.DAO.UsuarisDAO;
import org.elingua.DAO.IdiomesDAO;
import org.elingua.model.Basics;
import org.elingua.model.Collaboradors;
import org.elingua.model.Idiomes;
import org.elingua.model.Sessio;
import org.elingua.model.UsuariIdiomaEstudiat;
import org.elingua.model.UsuariIdiomaParlat;
import org.elingua.model.Usuaris;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * Classe de la capa model que fa d'intermediari entre EnregistrarAction i ModificarPerfilAction  i les DAO corresponents.  
 * @author Marina Martin
 * @version 1.0
 * @see org.elingua.control.ModificarPerfilAction
 * @see org.elingua.control.EnregistrarAction
 *
 */
public class managerEnregistrar {
	/**Dades de l'usuari*/
	Usuaris usuari;
	/**Dades de l'usuari bàsic*/
	Basics basic;
	/**Llista d'idiomes estudiats*/
	List<String> idiomesEst;
	/**Llista d'idiomes parlats*/
	List<String> idiomesParl;
	/**Constructor de managerEnregistrar*/
	public managerEnregistrar(Usuaris usuari,Basics basic,List<String> idiomesParl,List<String> idiomesEst){
		this.usuari = usuari;
		this.basic = basic;
		this.idiomesEst = idiomesEst;
		this.idiomesParl = idiomesParl;
		
	}
	/**
	 * Mètode per enregistrar un nou usuari a la web.
	 */
	public void enregistrar(){
		/*creem el DAO de usuaris*/
		UsuarisDAO dao1 = new UsuarisDAO();
		/*comencem la transacció*/
		Transaction tx1 = dao1.getSession().beginTransaction();
		/*guardem l'usuari*/
		dao1.save(usuari);
		/*acabem la transacció (es realitzen els canvis a la base de dades)*/
		tx1.commit();		
		/*tanquem la sessió (lliberem les conexions)*/
		dao1.getSession().close();
		
		/*creem la DAO de Basics*/
		BasicsDAO dao2 = new BasicsDAO();
		/*a l'objecte basics guardem l'usuari al que fa referència*/
		basic.setUsuaris(usuari);		
		/*comencem la transacció*/
		Transaction tx2 = dao2.getSession().beginTransaction();		
		/*guardem les dades de l'usuari bàsic*/
		dao2.save(basic);		
		/*acabem la transacció (es realitzen els canvis a la base de dades)*/
		tx2.commit();		
		/*tanquem la sessió (lliberem les conexions)*/
		dao2.getSession().close();
		
		/*creem la DAO d'idiomes*/
		IdiomesDAO dao3 = new IdiomesDAO();
		/*creem la DAO de idiomes estudiats per l'usuari*/		
		UsuariIdiomaEstudiatDAO dao4 = new UsuariIdiomaEstudiatDAO();		
		Iterator<String> ite = idiomesEst.iterator();
		/*recorrem la llista d'idiomes per estudiar*/
		while(ite.hasNext()){			
			/*comencem la transacció*/
			Transaction tx3 = dao3.getSession().beginTransaction();
			List idioma = dao3.findByNom(ite.next());
			Iterator<Idiomes> ite2 = idioma.iterator();
			/*creem un objecte amb l'usuari i l'idioma que vol estudiar*/
			UsuariIdiomaEstudiat usuariEst = new UsuariIdiomaEstudiat(ite2.next(),usuari);
			/*acabem la transacció (es realitzen els canvis a la base de dades)*/
			tx3.commit();
			/*tanquem la sessió (lliberem les conexions)*/
			dao3.getSession().close();
			/*comencem la transacció*/
			Transaction tx4 = dao4.getSession().beginTransaction();
			/*guardem el registre a la taula d'idiomes que l'usuari vol estudiar*/
			dao4.save(usuariEst);
			/*acabem la transacció (es realitzen els canvis a la base de dades)*/
			tx4.commit();
			/*tanquem la sessió (lliberem les conexions)*/
			dao4.getSession().close();			
		}
		
		/*creem la DAO d'idiomes que parla l'usuari*/		
		UsuariIdiomaParlatDAO dao5 = new UsuariIdiomaParlatDAO();		
		Iterator<String> ite3 = idiomesParl.iterator();
		/*recorrem la llista d'idiomes que parla l'usuari*/
		while(ite3.hasNext()){		
			/*comencem la transacció*/
			Transaction tx3 = dao3.getSession().beginTransaction();
			List idioma = dao3.findByNom(ite3.next());
			Iterator<Idiomes> ite4 = idioma.iterator();
			Idiomes idi = ite4.next();
			/*creem un objecte amb l'usuari i l'idioma que parla*/
			UsuariIdiomaParlat usuariPar = new UsuariIdiomaParlat(idi,usuari);
			/*acabem la transacció (es realitzen els canvis a la base de dades)*/
			tx3.commit();
			/*tanquem la sessió (lliberem les conexions)*/
			dao3.getSession().close();
			/*comencem la transacció*/
			Transaction tx4 = dao4.getSession().beginTransaction();
			/*guardem els idiomes parlats*/
			dao5.save(usuariPar);
			/*acabem la transacció (es realitzen els canvis a la base de dades)*/
			tx4.commit();
			/*tanquem la sessió (lliberem les conexions)*/
			dao4.getSession().close();
			
		}
		
		
		
	}
	/**
	 * Permet trobar un usuari donat el seu nom d'usuari. Si no el troba retorna null.
	 * @param inputnom El nom de l'usuari a cercar.
	 * @return El nom de l'usuari o null si no hi ha cap.
	 */
	public boolean cercarUsuariPerNom(String inputnom){
		/*creem la DAO d'usuaris*/
		UsuarisDAO dao = new UsuarisDAO();
		/*recuperem la llista d'usuari per nom d'usuari*/
		List<Usuaris> usuari = dao.findByNomUsuari(inputnom);
		/*tanquem la sessió (lliberem les conexions)*/
		dao.getSession().close();		
		Iterator<Usuaris> ite = usuari.iterator();
		/*recorrem la llista d'usuaris, si en troba un llavors retorna true*/
		while(ite.hasNext()){
			return true;
		}
		/*si no en troba cap retorna false*/
		return false;

		
		
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
		/*recorrem la llista dels idiomes*/
		while(ite.hasNext()){
			/*guardem el nom de l'idioma a la llista*/
			idiomes.add(ite.next().getNom());
		}
		/*retornem la llista amb els noms dels idiomes*/
		return idiomes;
		
	}
	/**
	 * Mètode utilitzat per ModificarPerfilAction per modificar el perfil de l'usuari.
	 * @param nomUsuari El nom de l'usuari que vol modificar el perfil.
	 * @see org.elingua.control.ModificarPerfilAction
	 */
	public void modificarPerfil(String nomUsuari){
		/*creem la DAO d'usuaris*/
		UsuarisDAO dao1 = new UsuarisDAO();		
		/*recuperem el registre mitjançant el nom de l'usuari*/	
		List<Usuaris> usuList = dao1.findByNomUsuari(nomUsuari);
		Iterator usuListIterator = usuList.iterator();
		/*guardem el registre en un objecte de tipus Usuaris*/
		Usuaris usu = (Usuaris) usuListIterator.next();
		/*guardem els canvis en la privacitat i el password*/
		usu.setPrivacitat(usuari.getPrivacitat());
		usu.setPsswd(usuari.getPsswd());
		/*comencem la transacció*/
		Transaction tx1 = dao1.getSession().beginTransaction();
		/*guardem el objecte usuari*/
		dao1.save(usu);
		/*acabem la transacció (es realitzen els canvis a la base de dades)*/
		tx1.commit();
		/*tanquem la sessió (lliberem les conexions)*/
		dao1.getSession().close();
		/*si volem que l'usuari sigui col·laborador*/
		if(usuari.getTipus().equals("collaborador")){
			/*si l'usuari es bàsic el fem colaborador */
			if(!usuari.getTipus().equals(usu.getTipus())){
				basicACollaborador(nomUsuari);				
			}
			/*si ja es col·laborador, l'actualitzem*/
			else{
				actualitzaCollaborador(nomUsuari);				
			}			
		}
		/*si l'usuari vlem que sigui bàsic*/
		else{
			/*si l'usuari es col·laborador, el fem bàsic*/
			if(!usuari.getTipus().equals(usu.getTipus())){				
				collaboradorABasic(nomUsuari);				
			}
			/*si l'usuari ja es bàsic, l'actualitzem*/
			else{
				actualitzaBasic(nomUsuari);				
			}						
		}
		/*invoquem als mètodes que modifiquen els idiomes parlats i estudiats*/		
		modificarIdiomesEstudiats(nomUsuari);
		modificarIdiomesParlats(nomUsuari);
		
		/*invoquem el mètode que modifica l'objecte sessió de l'usuari*/
		modificarSessio();
		
	}
	/**
	 * L'utilitza el mètode modificarPerfil per modificar els idiomes que estudia l'usuari.
	 * @param nomUsuari El nom de l'usuari al que volem modificar els idiomes que estudia.
	 */
	public void modificarIdiomesEstudiats(String nomUsuari){
		
		/*creem la DAO d'usuaris*/
		UsuarisDAO dao1 = new UsuarisDAO();		
		/*recuperem els registres mitjançant el nom de l'usuari*/
		List<Usuaris> usuList = dao1.findByNomUsuari(nomUsuari);
		Iterator usuListIterator = usuList.iterator();
		/*guardem el registre en un objecte de tipus Usuaris*/
		Usuaris usu = (Usuaris) usuListIterator.next();
		
		/*recuperem la llista dels idiomes estudiats*/
		Set<UsuariIdiomaEstudiat> usuIdiEstList = usu.getUsuariIdiomaEstudiats();		
		Iterator it2  = usuIdiEstList.iterator();
		/*creem la DAO d'idiomes estudiats per l'usuari*/
		UsuariIdiomaEstudiatDAO dao2 = new UsuariIdiomaEstudiatDAO();
		/*recorrem la llista dels idiomes estudiats*/
		while(it2.hasNext()){
			UsuariIdiomaEstudiat usuIdiEst = (UsuariIdiomaEstudiat) it2.next();
			Transaction tx3 = dao2.getSession().beginTransaction();
			/*esborrem un per un els idiomes*/
			dao2.delete(usuIdiEst);
			tx3.commit();
		}
		/*creem una DAO d'idiomes*/
		IdiomesDAO dao3 = new IdiomesDAO();				
		Iterator it3 = idiomesEst.iterator();
		/*recorrem la llista d'idiomes*/
		while(it3.hasNext()){
			List<Idiomes> idiList = dao3.findByNom(it3.next());
			Iterator it4 = idiList.iterator();
			Idiomes idi = (Idiomes) it4.next();
			UsuariIdiomaEstudiat usuIdiEstSel = new UsuariIdiomaEstudiat(idi,usu);
			Transaction tx2 = dao2.getSession().beginTransaction();
			/*guardem els nous idiomes seleccionats*/
			dao2.save(usuIdiEstSel);
			/*acabem la transacció (es realitzen els canvis a la base de dades)*/
			tx2.commit();
			/*tanquem la sessió (lliberem les conexions)*/
			dao2.getSession().close();			
		}		
		/*tanquem la sessió (lliberem les conexions)*/
		dao3.getSession().close();
		
		
	}
	/**
	 * L'utilitza el mètode modificarPerfil per modificar els idiomes que parla l'usuari.
	 * @param nomUsuari El nom de l'usuari al que volem modificar els idiomes que parla.
	 */
public void modificarIdiomesParlats(String nomUsuari){
		
		/*creem la DAO d'usuaris*/
		UsuarisDAO dao1 = new UsuarisDAO();
				
		/*recuperem els registres mitjanant el nom de l'usuari*/
		List<Usuaris> usuList = dao1.findByNomUsuari(nomUsuari);
		Iterator usuListIterator = usuList.iterator();
		Usuaris usu = (Usuaris) usuListIterator.next();		
		/*recuperem la llista dels idiomes que l'usuari parla*/
		Set<UsuariIdiomaParlat> usuIdiSapList = usu.getUsuariIdiomaParlats();		
		Iterator it2  = usuIdiSapList.iterator();
		/*creem la DAO d'idiomes que parla l'usuari*/		
		UsuariIdiomaParlatDAO dao2 = new UsuariIdiomaParlatDAO();
		/*recorro la llista dels idiomes que parla l'usuari*/
		while(it2.hasNext()){
			UsuariIdiomaParlat usuIdiSap = (UsuariIdiomaParlat) it2.next();
			Transaction tx3 = dao2.getSession().beginTransaction();
			/*eliminem un per un els idiomes que parla l'usuari*/
			dao2.delete(usuIdiSap);
			tx3.commit();
		}
		/*creem la DAO d'idiomes*/
		IdiomesDAO dao3 = new IdiomesDAO();				
		Iterator it3 = idiomesParl.iterator();
		/*recorrem la llista d'idiomes*/
		while(it3.hasNext()){
			List<Idiomes> idiList = dao3.findByNom(it3.next());
			Iterator it4 = idiList.iterator();
			Idiomes idi = (Idiomes) it4.next();
			UsuariIdiomaParlat usuIdiSapSel = new UsuariIdiomaParlat(idi,usu);
			Transaction tx2 = dao2.getSession().beginTransaction();
			/*guardem els idiomes nous que parla l'usuari*/
			dao2.save(usuIdiSapSel);
			/*acabem la transacció (es realitzen els canvis a la base de dades)*/
			tx2.commit();
			/*tanquem la sessió (lliberem les conexions)*/
			dao2.getSession().close();			
		}	
		/*tanquem la sessió (lliberem les conexions)*/
		dao3.getSession().close();		
	}
/**
 * L'utilitza el mètode modificarPerfil per guardar al bean de Sessio
 * l'informació de l'usuari.
 * @see org.elingua.model.Sessio
 */
	public void modificarSessio(){
		/*recuperem l'objecte sessió associat a l'usuari*/
		Map session = ActionContext.getContext().getSession();
		Sessio ses = (Sessio) session.get("usuari");
		/*actualitzem la llista d'idiomes a l'objecte sessió*/		
		ses.setIdiomesSap(idiomesParl);
		ses.setIdiomesApren(idiomesEst);			
		session.put("usuari",ses);		
				
	}
	/**
	 * Permet cambiar el tipus d'usuari de basic a col·laborador.
	 * @param nomUsuari El nom de l'usuari a cambiar a col·laborador.
	 */
	public void basicACollaborador(String nomUsuari){
		/*creem la DAO d'usuaris*/
		UsuarisDAO dao1 = new UsuarisDAO();		
		/*recuperem el registre de l'usuari mitjançant el seu nom*/
		List<Usuaris> usuList = dao1.findByNomUsuari(nomUsuari);
		Iterator usuListIterator = usuList.iterator();
		/*guardem el registre en un objecte de tipus Usuaris*/
		Usuaris usu = (Usuaris) usuListIterator.next();
		/*actualitzem el seu tipus a col·laborador*/		
		usu.setTipus("collaborador");
		/*recuperem les dades en la taula de bàsics*/
		Set<Basics> basList = usu.getBasicses();		
		Iterator it = basList.iterator();
		Basics bas = (Basics) it.next();
		/*creem un objecte col·laboradors que conté les dades que hem recuperat de la taula bàsics*/
		Collaboradors col = new Collaboradors(usu, this.basic.getNom(), this.basic.getCognom1(),this.basic.getCognom2(), this.basic.getSexe(), this.basic.getDataNaix(), this.basic.getEmail());
		/*creem la DAO de basics*/
		BasicsDAO basicsDao = new BasicsDAO();
		/*comencem la transacció*/
		Transaction tx2 = basicsDao.getSession().beginTransaction();
		/*eliminem el registre de la taula de basics*/
		basicsDao.delete(bas);
		/*acabem la transacció (es realitzen els canvis a la base de dades)*/
		tx2.commit();
		/*tanquem la sessió (lliberem les conexions)*/
		basicsDao.getSession().close();
		/*creem la DAO de col·laboradors*/
		CollaboradorsDAO collaboradorsDao = new CollaboradorsDAO();
		/*comencem la transacció*/
		Transaction tx = collaboradorsDao.getSession().beginTransaction();
		/*guardem el nou registre a la taula de collaboradors*/
		collaboradorsDao.save(col);
		/*acabem la transacció (es realitzen els canvis a la base de dades)*/
		tx.commit();
		/*tanquem la sessió (lliberem les conexions)*/
		collaboradorsDao.getSession().close();
		
	}
	/**
	 * Permet cambiar el tipus d'usuari de col·laborador a basic.
	 * @param nomUsuari El nom de l'usuari a col·laborador a basic.
	 */
	public void collaboradorABasic(String nomUsuari){
		/*creem la DAO d'usuaris*/
		UsuarisDAO dao1 = new UsuarisDAO();		
		/*recuperem el registre mitjançant el nom de l'usuari*/
		List<Usuaris> usuList = dao1.findByNomUsuari(nomUsuari);
		Iterator usuListIterator = usuList.iterator();
		Usuaris usu = (Usuaris) usuListIterator.next();
		/*actualitzem l'usuari a tipus bàsic*/
		usu.setTipus("basic");
		/*recuperem les dades del registre de la taula collaboradors*/
		Set<Collaboradors> colList = usu.getCollaboradorses();		
		Iterator it = colList.iterator();
		Collaboradors col = (Collaboradors) it.next();
		/*creem un objecte que serà el nou registre de la taula bàsics amb les dades de la taula collaboradors*/
		Basics bas = new Basics(usu, this.basic.getNom(), this.basic.getCognom1(),this.basic.getCognom2(), this.basic.getSexe(), this.basic.getDataNaix(), this.basic.getEmail());
		/*creem la DAO de basics*/		
		BasicsDAO basicsDao = new BasicsDAO();
		/*comencem la transacció*/
		Transaction tx = basicsDao.getSession().beginTransaction();
		/*guardem el nou registre a la taula de basics*/
		basicsDao.save(bas);
		/*acabem la transacció (es realitzen els canvis a la base de dades)*/
		tx.commit();
		/*tanquem la sessió (lliberem les conexions)*/
		basicsDao.getSession().close();
		/*creem la DAO de collaboradors*/
		CollaboradorsDAO collaboradorsDao = new CollaboradorsDAO();
		/*comencem la transacció*/
		Transaction tx2 = collaboradorsDao.getSession().beginTransaction();
		/*eliminem el registre de la taula de collaboradors*/
		collaboradorsDao.delete(col);
		/*acabem la transacció (es realitzen els canvis a la base de dades)*/
		tx2.commit();
		/*tanquem la sessió (lliberem les conexions)*/
		collaboradorsDao.getSession().close();
		
		
	}
	/**
	 * Permet actualitzar les dades d'un usuari de tipus col·laborador.
	 * @param nomUsuari El nom de l'usuari que volem actualitzar.
	 */
	public void actualitzaCollaborador(String nomUsuari){
		/*creem la DAO d'usuaris*/
		UsuarisDAO dao1 = new UsuarisDAO();
		
		/*recuperem el registre mitjançant el nom d'usuari*/
		List<Usuaris> usuList = dao1.findByNomUsuari(nomUsuari);
		Iterator usuListIterator = usuList.iterator();
		/*guardem el registre en el objecte de tipus Usuaris*/
		Usuaris usu = (Usuaris) usuListIterator.next();
		/*recuperem les dades del registre de la taula collaborador*/
		Set<Collaboradors> colList = usu.getCollaboradorses();		
		Iterator it = colList.iterator();
		Collaboradors col = (Collaboradors) it.next();
		/*actualitzem les dades de la taula collaborador*/
		col.setNom(this.basic.getNom());
		col.setCognom1(this.basic.getCognom1());
		col.setCognom2(this.basic.getCognom2());
		col.setSexe(this.basic.getSexe());
		col.setDataNaix(this.basic.getDataNaix());
		col.setEmail(this.basic.getEmail());
		
	}
	/**
	 * Permet actualitzar les dades d'un usuari de tipus basic.
	 * @param nomUsuari El nom de l'usuari que volem actualitzar.
	 */
	public void actualitzaBasic(String nomUsuari){
		/*creem la DAO d'usuaris*/
		UsuarisDAO dao1 = new UsuarisDAO();
		/*recuperem el registre mitjançant el nom de l'usuari*/
		List<Usuaris> usuList = dao1.findByNomUsuari(nomUsuari);
		Iterator usuListIterator = usuList.iterator();
		/*guardem el registre en un objecte de tipus Usuaris*/
		Usuaris usu = (Usuaris) usuListIterator.next();
		/*recuperem les dades del registre de la taula basics*/
		Set<Basics> basList = usu.getBasicses();		
		Iterator it = basList.iterator();
		/*actualitzem les dades del registre de la taula basics*/
		Basics bas = (Basics) it.next();
		bas.setNom(this.basic.getNom());
		bas.setCognom1(this.basic.getCognom1());
		bas.setCognom2(this.basic.getCognom2());
		bas.setSexe(this.basic.getSexe());
		bas.setDataNaix(this.basic.getDataNaix());
		bas.setEmail(this.basic.getEmail());
	}
		

}
