package org.elingua.model;


import org.elingua.DAO.CursosDAO;
import org.elingua.DAO.EstadistiquesDAO;
import org.elingua.DAO.HistorialCursVisitatDAO;
import org.elingua.DAO.UsuarisDAO;
import org.elingua.model.Cursos;
import org.elingua.model.Estadistiques;
import org.elingua.model.HistorialCursVisitat;
import org.elingua.model.Sessio;
import org.elingua.model.Usuaris;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;


import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Classe de la capa model que fa d'intermediari entre EstadistiquesAction i les DAO corresponents.  
 * @author Marina Martin
 * @version 1.0
 * @see org.elingua.control.EstadistiquesAction
 */
public class managerEstadistiques {
	/**Contructor per defecte*/
	public managerEstadistiques(){
		
	}
	/**
	 * Mètode que desa la data en la que l'usuari s'ha registrat.
	 * @param nomUsuari El nom de l'usuari.
	 * @param data La data actual.
	 */
	public void guardarDataRegistre(String nomUsuari,Date data){
		/*creem la DAO d'usuaris*/
		UsuarisDAO usuDao = new UsuarisDAO();
		
		/*recuperem el registre mitjançant el nom de l'usuari*/
		List<Usuaris> usuariList =  usuDao.findByNomUsuari(nomUsuari);
		Iterator usuariListIterator = usuariList.iterator();
		Usuaris usuari = (Usuaris) usuariListIterator.next();
		/*creem un nou objecte estadistiques amb els valors per defecte*/
		Estadistiques estadistiques = new Estadistiques(usuari);
		estadistiques.setUltimLog(data);
		estadistiques.setCursPub(0);
		estadistiques.setCursCon(0);
		estadistiques.setMsmEnv(0);
		estadistiques.setMsmReb(0);
		/*creem una DAO d'estadístiques*/
		EstadistiquesDAO estDao = new EstadistiquesDAO();
		/*comencem la transacció*/
		Transaction tx = estDao.getSession().beginTransaction();
		/*guardem el registre d'estadístiques a la taula*/
		estDao.save(estadistiques);
		/*acabem la transacció (es realitzen els canvis a la base de dades)*/
		tx.commit();
		/*tanquem la sessió (lliberem les conexions)*/
		estDao.getSession().close();
		
	}
	/**
	 * Incrementa el nombre de cursos creats a les estadístiques.
	 * @param nomUsuari El nom de l'usuari.
	 */
	
	public void guardarCursCreat(String nomUsuari){
		/*creem la DAO d'usuaris*/
		UsuarisDAO usuDao = new UsuarisDAO();
		/*recuperem l'objecte sessió associat a l'usuari*/
		Map session = ActionContext.getContext().getSession();
		Sessio sesio = (Sessio) session.get("usuari");
		/*recuperem el registre mitjnçant el nom de l'usuari*/
		List<Usuaris> usuariList =  usuDao.findByNomUsuari(sesio.getNomUsuari());
		Iterator usuariListIterator = usuariList.iterator();
		Usuaris usuari = (Usuaris) usuariListIterator.next();
		/*recuperem el registre de la taula estadístiques que pertany a l'usuari*/
		Set estadistiquesList = usuari.getEstadistiqueses();
		Iterator estadistiquesListIterator = estadistiquesList.iterator();
		Estadistiques estadistiques = (Estadistiques) estadistiquesListIterator.next();
		/*incrementem el nombre de cursos publicats*/		
		estadistiques.setCursPub(estadistiques.getCursPub()+1);
		/*creem una DAO d'estadístiques*/
		EstadistiquesDAO estDao = new EstadistiquesDAO();
		/*comencem la transacció*/
		Transaction tx = estDao.getSession().beginTransaction();
		/*guardem el registre a la taula d'estadístiques*/
		estDao.save(estadistiques);		
		/*acabem la transacció (es realitzen els canvis a la base de dades)*/
		tx.commit();		
		/*tanquem la sessió (lliberem les conexions)*/
		estDao.getSession().close();
	}
	/**
	 * Incrementa el nombre de cursos visitats a les estadístiques.
	 * @param curs L'identificador del curs.
	 */
	public void guardarCursVisitat(int curs){
		/*creem la DAO d'usuaris*/
		UsuarisDAO usuDao = new UsuarisDAO();
		/*recuperem l'objecte sessió associat a l'usari*/
		Map session = ActionContext.getContext().getSession();
		Sessio sesio = (Sessio) session.get("usuari");
		/*recuperem el registre mitjançant el nom de l'usuari*/
		List<Usuaris> usuariList =  usuDao.findByNomUsuari(sesio.getNomUsuari());
		Iterator usuariListIterator = usuariList.iterator();
		/*guardem el registre en un objecte de tipus Usuaris*/
		Usuaris usuari = (Usuaris) usuariListIterator.next();
		/*recuperem la llista de l'historial de cursos visitats*/
		Set histcursvisiList = usuari.getHistorialCursVisitats();
		Iterator histcursvisiListiterator =  histcursvisiList.iterator();
		/*booleà que ens perment coneixer si el curs ha estat visitat anteriorment*/
		boolean existeixCursVisitat = false;
		while(histcursvisiListiterator.hasNext()){
			HistorialCursVisitat histCursVis= (HistorialCursVisitat) histcursvisiListiterator.next();
			/*si el curs ha estat visitat anteriorment*/
			if(histCursVis.getCursos().getIdCurs().equals(curs)){
				existeixCursVisitat = true;
			}
			
		}
		/*si no existeix el curs en la taula historial, llavors incrementem a les estadistiques*/		
		if(!existeixCursVisitat){
			/*recuperem les estadístiques de l'usuari*/
			Set estadistiquesList = usuari.getEstadistiqueses();
			Iterator estadistiquesListIterator = estadistiquesList.iterator();
			Estadistiques estadistiques = (Estadistiques) estadistiquesListIterator.next();
			/*incrementem el nombre de cursos consultats*/
			estadistiques.setCursCon(estadistiques.getCursCon()+1);
			
			
			/*primer recuperem l'objecte curs*/
			CursosDAO cursDao = new CursosDAO();
			Cursos cursos = cursDao.findById(curs);
			HistorialCursVisitat histCursVis = new HistorialCursVisitat(cursos,usuari);
			
			HistorialCursVisitatDAO hiscursvisdao = new HistorialCursVisitatDAO();
			/*comencem la transacció*/
			Transaction tx = hiscursvisdao.getSession().beginTransaction();
			
			/*creem un nou registre a l'historial de cursos visitats*/
			hiscursvisdao.save(histCursVis);
			
			/*acabem la transacció (es realitzen els canvis a la base de dades)*/
			tx.commit();
			
			/*tanquem la sessió (lliberem les conexions)*/
			hiscursvisdao.getSession().close();
			
			
		}
		
		
		
		
	}
	/**
	 * Incrementa el número de missatges enviats a les estadístiques.
	 * @param nomUsuari El nom de l'usuari.
	 */
	public void guardarMissatgeEnviat(String nomUsuari){
		/*creem la DAO d'usuaris*/
		UsuarisDAO usuDao = new UsuarisDAO();
		/*recuperem el registre mitjançant el nom de l'usuari*/
		List<Usuaris> usuariList =  usuDao.findByNomUsuari(nomUsuari);
		Iterator usuariListIterator = usuariList.iterator();
		/*guardem el registre en un objecte de tipus Usuaris*/
		Usuaris usuari = (Usuaris) usuariListIterator.next();
		/*recuperem les estadístiques de l'usuari*/
		Set estadistiquesList = usuari.getEstadistiqueses();
		Iterator estadistiquesListIterator = estadistiquesList.iterator();
		Estadistiques estadistiques = (Estadistiques) estadistiquesListIterator.next();
		/*incrementem el nomnre de missatges enviats*/
		estadistiques.setMsmEnv(estadistiques.getMsmEnv()+1);
		/*creem la DAO d'estadístiques*/
		EstadistiquesDAO estDao = new EstadistiquesDAO();
		/*comencem la transacció*/
		Transaction tx = estDao.getSession().beginTransaction();
		/*guardem el registre a la taula estadístiques*/
		estDao.save(estadistiques);
		
		/*acabem la transacció (es realitzen els canvis a la base de dades)*/
		tx.commit();
		
		/*tanquem la sessió (lliberem les conexions)*/
		estDao.getSession().close();
		
		
	}
	/**
	 * Incrementa el número de missatges llegits a les estadístiques.
	 * 
	 */
	public void guardarMissatgeLlegit(){
		/*creem la DAO d'usuaris*/
		UsuarisDAO usuDao = new UsuarisDAO();
		/*recuperem la sessió associada a l'usuari*/
		Map session = ActionContext.getContext().getSession();
		Sessio sesio = (Sessio) session.get("usuari");
		/*recuperem el registre mitjançant el nom d'usuari*/
		List<Usuaris> usuariList =  usuDao.findByNomUsuari(sesio.getNomUsuari());
		Iterator usuariListIterator = usuariList.iterator();
		/*guardem el registre en un objecte de tipus Usuaris*/
		Usuaris usuari = (Usuaris) usuariListIterator.next();
		/*recuperem les estadístiques de l'usuari*/
		Set estadistiquesList = usuari.getEstadistiqueses();
		Iterator estadistiquesListIterator = estadistiquesList.iterator();
		Estadistiques estadistiques = (Estadistiques) estadistiquesListIterator.next();
		/*incrementem el nombre de missatges rebuts de l'usuari*/
		estadistiques.setMsmReb(estadistiques.getMsmReb()+1);
		/*creem la DAO d'estadístiques*/
		EstadistiquesDAO estDao = new EstadistiquesDAO();
		/*comencem la transacció*/
		Transaction tx = estDao.getSession().beginTransaction();
		
		/*guardem el registre a la taula d'estadístiques*/
		estDao.save(estadistiques);
		
		/*acabem la transacció (es realitzen els canvis a la base de dades)*/
		tx.commit();
		
		/*tanquem la sessió (lliberem les conexions)*/
		estDao.getSession().close();
	}
	/**
	 * Carrega la data en la que l'usuari s'ha registrat.
	 * @return La data en la que l'usuari s'ha registrat.
	 */
	public String carregarData(){
		/*creem la DAO d'usuaris*/
		UsuarisDAO usuDao = new UsuarisDAO();
		/*recuperem el objecte sessió associat a l'usuari*/
		Map session = ActionContext.getContext().getSession();
		Sessio sesio = (Sessio) session.get("usuari");
		/*recuperem el registre mitjançant el nom de l'usuari*/
		List<Usuaris> usuariList =  usuDao.findByNomUsuari(sesio.getNomUsuari());
		Iterator usuariListIterator = usuariList.iterator();
		/*guardem el registre en un objecte de tipus Usuaris*/
		Usuaris usuari = (Usuaris) usuariListIterator.next();
		/*recuperem les estadístiques de l'usuari*/
		Set estadistiquesList = usuari.getEstadistiqueses();
		Iterator estadistiquesListIterator = estadistiquesList.iterator();
		Estadistiques estadistiques = (Estadistiques) estadistiquesListIterator.next();
		/*retornem la data de registre de l'usuari*/
		return estadistiques.getUltimLog().toString();
		
		
	}
	/**
	 * Carrega el número de cursos creats per l'usuari.
	 * @return El número de cursos creats per l'usuari.
	 */
	public int carregarCursosCreats(){
		/*creem la DAO d'usuaris*/
		UsuarisDAO usuDao = new UsuarisDAO();
		/*recuperem el objecte sessió associat a l'usuari*/
		Map session = ActionContext.getContext().getSession();
		Sessio sesio = (Sessio) session.get("usuari");
		/*recuperem el registre mitjaçant el nom de l'usuari*/
		List<Usuaris> usuariList =  usuDao.findByNomUsuari(sesio.getNomUsuari());
		Iterator usuariListIterator = usuariList.iterator();
		/*guardem el registre en un objecte de tipus Usuaris*/
		Usuaris usuari = (Usuaris) usuariListIterator.next();
		/*recuperem les estadistíques de l'usuari*/
		Set estadistiquesList = usuari.getEstadistiqueses();
		Iterator estadistiquesListIterator = estadistiquesList.iterator();
		Estadistiques estadistiques = (Estadistiques) estadistiquesListIterator.next();
		/*retornem el nombre de cursos publicats per l'usuari*/
		return estadistiques.getCursPub();
		
		
	}
	/**
	 * Carrega el número de cursos visitats per l'usuari.
	 * @return El número de cursos visitats per l'usuari.
	 */
	public int carregarCursosVisitats(){
		/*creem la DAO d'usuaris*/
		UsuarisDAO usuDao = new UsuarisDAO();
		/*recuperem la sessió associada a l'usuari*/
		Map session = ActionContext.getContext().getSession();
		Sessio sesio = (Sessio) session.get("usuari");
		/*recuperem el registre mitjançant el nom de l'usuari*/
		List<Usuaris> usuariList =  usuDao.findByNomUsuari(sesio.getNomUsuari());
		Iterator usuariListIterator = usuariList.iterator();
		/*guardem el registre en un objecte de tipus Usuaris*/
		Usuaris usuari = (Usuaris) usuariListIterator.next();
		/*recuperem les estadístiques de l'usuari*/
		Set estadistiquesList = usuari.getEstadistiqueses();
		Iterator estadistiquesListIterator = estadistiquesList.iterator();
		Estadistiques estadistiques = (Estadistiques) estadistiquesListIterator.next();
		/*retornem el nombre de cursos consultats*/
		return estadistiques.getCursCon();
		
	}
	/**
	 * Carrega el número de missatges enviats per l'usuari.
	 * @return El número de missatges enviats per l'usuari.
	 */
	public int carregarMissatgesEnviats(){
		/*creem la DAO d'usuaris*/
		UsuarisDAO usuDao = new UsuarisDAO();
		/*recuperem el objecte sessió associat a l'usuari*/
		Map session = ActionContext.getContext().getSession();
		Sessio sesio = (Sessio) session.get("usuari");
		/*recuperem el registre mitjançant el nom de l'usuari*/
		List<Usuaris> usuariList =  usuDao.findByNomUsuari(sesio.getNomUsuari());
		Iterator usuariListIterator = usuariList.iterator();
		/*guardem el registre en un objecte de tipus Usuaris*/
		Usuaris usuari = (Usuaris) usuariListIterator.next();
		/*recuperem les estadístiques de l'usuari*/
		Set estadistiquesList = usuari.getEstadistiqueses();
		Iterator estadistiquesListIterator = estadistiquesList.iterator();
		Estadistiques estadistiques = (Estadistiques) estadistiquesListIterator.next();
		/*retornme el nombre de missatges enviats per l'usuari*/
		return estadistiques.getMsmEnv();
		
	}
	/**
	 * Carrega el número de missatges llegits per l'usuari.
	 * @return El número de missatges llegits per l'usuari.
	 */
	public int carregarMissatgesLlegits(){
		/*creem la DAO d'usuaris*/
		UsuarisDAO usuDao = new UsuarisDAO();
		/*recuperem el objecte sessió associat a l'usuari*/
		Map session = ActionContext.getContext().getSession();
		Sessio sesio = (Sessio) session.get("usuari");
		/*recuperem el registre mitjançant el nom de l'usuari*/
		List<Usuaris> usuariList =  usuDao.findByNomUsuari(sesio.getNomUsuari());
		Iterator usuariListIterator = usuariList.iterator();
		/*guardem el registre en un objecte de tipus Usuaris*/
		Usuaris usuari = (Usuaris) usuariListIterator.next();
		/*recuperem les estadístiques de l'usuari*/
		Set estadistiquesList = usuari.getEstadistiqueses();
		Iterator estadistiquesListIterator = estadistiquesList.iterator();
		Estadistiques estadistiques = (Estadistiques) estadistiquesListIterator.next();
		/*retornem el nombre de missatges rebuts per l'usuari*/
		return estadistiques.getMsmReb();
	}
}
