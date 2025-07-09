package org.elingua.model;



import org.elingua.DAO.CursosDAO;
import org.elingua.DAO.UsuarisDAO;
import org.elingua.DAO.IdiomesDAO;
import org.elingua.model.Cursos;
import org.elingua.model.Idiomes;
import org.elingua.model.Sessio;
import org.elingua.model.Usuaris;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Classe de la capa model que fa d'intermediari entre CursAction i les DAO corresponents.  
 * @author Marina Martin
 * @version 1.0
 * @see org.elingua.control.CursAction
 */
public class managerCurs {
	/**Constructor per defecte */	
	public managerCurs(){
		
	}
	/**
	 * Mètode que carrega les dades del curs que es vol mostrar.
	 * @param id L'identificatiu únic del curs
	 * @return Una llista amb les dades i el contingut del curs.
	 */
	public List<String> carregarCurs(int id){
		/*creem una llista on guardarem les dades del curs*/
		List<String> resultat = new ArrayList();
		/*creem una DAO de Cursos*/
		CursosDAO cursosdao = new CursosDAO();
		/*recuperem i guardem el registre mitjançant el seu identificador*/
		Cursos curs = (Cursos) cursosdao.findById(id);
		/*guardem l'idioma del curs*/
		Idiomes idioma = curs.getIdiomes();
		/*guardem les dades del curs en una llista*/
		resultat.add(idioma.getNom());
		resultat.add(curs.getTitol());
		resultat.add(curs.getContingut());
		Usuaris usuari = curs.getUsuaris();
		resultat.add(usuari.getNomUsuari());
		/*retornem les dades del curs*/
		return resultat;
		
	}
	/**
	 * LLista els cursos disponibles.
	 * @return Una llista amb les dades dels cursos que estan disponibles.
	 */
	public List<List> llistarCursos(){
		/*creem una llista de llistes on guardarem la llista de cursos amb les seves dades*/
		List<List> resultat = new ArrayList();
		/*creem una DAO de cursos*/
		CursosDAO cursosDao = new CursosDAO();
		/*recuperem tots els registres de la taula de cursos*/
		List<Cursos> cursosList = cursosDao.findAll();		
		Iterator cursosIterator = cursosList.iterator();
		/*recorrem la llista de cursos*/
		while(cursosIterator.hasNext()){
			/*creem una llista per guardar les dades del curs*/
			List<String> camps = new ArrayList();
			/*guardem en un objecte de tipus Cursos el registre*/
			Cursos curs = (Cursos) cursosIterator.next();
			/*ara agafarem el id del curs, convertim el id de int a string*/
		    String idcurs = Integer.toString(curs.getIdCurs());
			/*i el guardem a la llista*/
			camps.add(idcurs);			
			/*una vegada tenim el curs ja podem saber el idioma*/
			Idiomes idioma = curs.getIdiomes();
			/*ja tenim el idioma asociat al curs el guardem a la llista*/
			camps.add(idioma.getNom());			
			/*ara guardem el titol del curs*/
			camps.add(curs.getTitol());			
			/*ara busquem qui ha creat el curs, el autor*/
			Usuaris usuaris = curs.getUsuaris();
			/*ja tenim el usuari associat al curs, ara el guardem a la llista*/
			camps.add(usuaris.getNomUsuari());
			/*guardem el objecte sessió associat a l'usuari*/
			Map session = ActionContext.getContext().getSession();
			Sessio sesio = (Sessio) session.get("usuari");
			/*si no es tracta de l'usuari administrador*/
			if(!sesio.getNomUsuari().equals("admin")){				
				/*mirem si l'idioma del curs es el que tenim a preferències*/				
				List<String> idiomesApren = sesio.getIdiomesApren();
				Iterator idiomesAprenIter = idiomesApren.iterator();
				while(idiomesAprenIter.hasNext()){
					if(camps.get(1).equals(idiomesAprenIter.next())){
						//guardem la llista de dades en una llista de cursos
						resultat.add(camps);
					}					
				}
				/*si es l'autor del curs, llavors també el llistarem*/
				if(camps.get(3).equals(sesio.getNomUsuari())){
					resultat.add(camps);
				}
			}
			/*si es tracta de l'administrador llistarem tots els cursos possibles*/
			else{
				resultat.add(camps);
			}
		}
		/*retornem la llista de llistes de cursos*/
		return resultat;
	}
	/**
	 * Enregistra un nou curs a la web.
	 * @param idUsuari L'identificador únic de l'usuari.
	 * @param cnt El contingut del curs.
	 * @param titol El titol del curs.
	 * @param idiomaSele L'idioma del curs.
	 * @return L'identificador únic del curs creat.
	 */
	public int enregistrarCurs(int idUsuari,String cnt,String titol,String idiomaSele){
		/*creem la DAO d'usuaris*/
		UsuarisDAO usuariDao = new UsuarisDAO();
		/*recuperem l'objecte usuari mitjançant el seu id de usuari*/
		Usuaris usuari = usuariDao.findById(idUsuari);		
		/*ara agafem l'objecte idioma asociat al curs*/
		IdiomesDAO idiomesDao = new IdiomesDAO();
		/*l'usuari només pot crear cursos amb idiomes que parli*/
		List<Idiomes> idiomaList = idiomesDao.findByNom(idiomaSele);
		Iterator idiomaListIte = idiomaList.iterator();
		Idiomes idioma = (Idiomes) idiomaListIte.next();		
		/*creem el objecte curs corresponent*/
		Cursos curs = new Cursos(idioma,usuari,titol,cnt);		
		/*creem una DAO de cursos*/
		CursosDAO dao = new CursosDAO();
		/*comencem la transacció*/
		Transaction tx = dao.getSession().beginTransaction();
		/*guardem el curs a la base de dades*/
		dao.save(curs);
		/*acabem la transacció (es realitzen els canvis a la base de dades)*/
		tx.commit();		
		/*tanquem la sessió (lliberem les conexions)*/
		dao.getSession().close();		
		/*Recuperem el curs que acabem de desar per agafar el seu id de curs per borrar o modificar*/
		
		List<Cursos> cursList = dao.findByExample(curs);
		Iterator cursListIterator = cursList.iterator();
		Cursos cursRecuperat = (Cursos) cursListIterator.next();
		
		/*retornem l'identificador assignat al curs creat*/
		return cursRecuperat.getIdCurs();
		
		
	}
	/**
	 * Carrega els idiomes que l'usuari te disponibles per crear un curs.
	 * @return Els idiomes disponibles. 
	 */
	public List<String> carregarIdiomes(){
		/*creem una DAO d'idiomes*/
		IdiomesDAO dao = new IdiomesDAO();		
		/*guardem en una llista tots el registres de la taula idiomes*/
		List<Idiomes> idiomesObj = dao.findAll();		
		/*tanquem la sessió (lliberem les conexions)*/
		dao.getSession().close();
		
		List<String> idiomes = new ArrayList<String>();		
		Iterator<Idiomes> ite = idiomesObj.iterator();
		/*recorrem la llista d'idiomes*/
		while(ite.hasNext()){
			
			String idiomaNom = ite.next().getNom(); 
			/*recuperem l'objecte sessió associat a l'usuari*/
			Map session = ActionContext.getContext().getSession();
			Sessio sesio = (Sessio) session.get("usuari");
			/*si l'usuari es l'administrador podem crear un curs en qualsevol idioma*/
			if(sesio.getNomUsuari().equals("admin")){
				idiomes.add(idiomaNom);
			}
			else{
				/*comprovem que el usuari pot crear nomes cursos d'idiomes que ell sap*/
				
				List<String> idiomesSapList = sesio.getIdiomesSap();
				Iterator idiomesSapListIterator = idiomesSapList.iterator();
				while(idiomesSapListIterator.hasNext()){
					if(idiomaNom.equals(idiomesSapListIterator.next())){
						idiomes.add(idiomaNom);
					}
				}
			}			
		}
		/*retornem la llista d'idiomes*/
		return idiomes;
		
	}
	/**
	 * Mètode que permet editar un curs determinat.
	 * @param id L'identificador únic del curs.
	 * @param cnt El nou contingut del curs editat.
	 * @param titol El nou titol del curs editat.
	 */
	public void editarCurs(int id,String cnt,String titol){
		/*creem una DAO de cursos*/
		CursosDAO cursosdao = new CursosDAO();
		/*recuperem un registre per el seu identificador*/
		Cursos curs = cursosdao.findById(id);
		/*guardem les dades del curs*/
		curs.setTitol(titol);
		curs.setContingut(cnt);
		/*comencem la transacció*/
		Transaction tx = cursosdao.getSession().beginTransaction();
		/*guardem el curs editat*/
		cursosdao.save(curs);		
		/*acabem la transacció (es realitzen els canvis a la base de dades)*/
		tx.commit();		
		/*tanquem la sessió (lliberem les conexions)*/
		cursosdao.getSession().close();
		
	}
	/**
	 * Elimina el curs mitjançant el seu identificador.
	 * @param id L'identificador únic del curs.
	 */
	public void eliminarCurs(int id){
		/*creem el DAO de cursos*/
		CursosDAO cursosdao = new CursosDAO();
		/*recuperem el registre pel seu identificador*/
		Cursos curs = cursosdao.findById(id);
		/*comencem la transacció*/
		Transaction tx = cursosdao.getSession().beginTransaction();
		/*eliminem el curs*/
		cursosdao.delete(curs);
		/*tanquem la sessió (lliberem les conexions)*/
		tx.commit();
		/*tanquem la sessió (lliberem les conexions)*/
		cursosdao.getSession().close();		
	}
}
