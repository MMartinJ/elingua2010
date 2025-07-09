package org.elingua.DAO;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elingua.model.Cursos;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Un Data Acces Object (DAO) que proporciona suport de persistència i de cerca a la entitat Cursos.  
 * 
 * @author Marina Martin
 * @see org.elingua.model.Cursos
 */

public class CursosDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(CursosDAO.class);
	/** Propietats constants de CursosDAO */
	public static final String TITOL = "titol";
	public static final String CONTINGUT = "contingut";
	/**
	 * Mètode que permet a l'entitat Cursos guardar els seus camps en un registre a la Base de dades.
	 * @param transientInstance Instància de la classe Cursos.
	 * @throws RuntimeException
	 */
	public void save(Cursos transientInstance) {
		log.debug("saving Cursos instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Cursos eliminar un objecte associat a un registre de la Base de dades.
	 * @param persistentInstance Instància de la classe Cursos.
	 * @throws RuntimeException
	 */
	public void delete(Cursos persistentInstance) {
		log.debug("deleting Cursos instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Cursos recuperar un objecte associat a un registre de la Base de dades.
	 * @param id L'identificador únic del registre de la base de dades.
	 * @return Un objecte de tipus Cursos amb l'identificador introduït. 
	 * @throws RuntimeException
	 */
	public Cursos findById(java.lang.Integer id) {
		log.debug("getting Cursos instance with id: " + id);
		try {
			Cursos instance = (Cursos) getSession().get(
					"org.elingua.model.Cursos", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Cursos recuperar una llista d'objectes associats a registres de la Base de dades.
	 * @param instance Instància de la classe Cursos.
	 * @return Llista d'objectes associats a registres de la Base de dades.
	 */
	public List findByExample(Cursos instance) {
		log.debug("finding Cursos instance by example");
		try {
			List results = getSession()
					.createCriteria("org.elingua.model.Cursos")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Cursos recuperar una llista d'objectes segons les seves propietats.
	 * @param propertyName El nom de la propietat a cercar.
	 * @param value El valor de la propietat a cercar.
	 * @return Una llista d'objectes associats a uns registres de la base de dades.
	 * @throws RuntimeException
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Cursos instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Cursos as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
/**
 * Utilitza el mètode findByProperty per recuperar una llista d'objectes.
 * @param titol Titol del curs.
 * @return Llista d'objectes associats a registres en la base de dades.
 */
	public List findByTitol(Object titol) {
		return findByProperty(TITOL, titol);
	}
/**
 * Utilitza el mètode findByProperty per recuperar una llista d'objectes.
 * @param contingut El contingut del curs.
 * @return Llista d'objectes associats a registres en la base de dades.
 */
	public List findByContingut(Object contingut) {
		return findByProperty(CONTINGUT, contingut);
	}
	/**
	 * Mètode que permet a l'entitat Cursos recuperar tots els registres de la taula de la base de dades.
	 * @return Una llista d'objectes associats a tots els registres de la taula de la base de dades.
	 * @throws RuntimeException
	 */
	public List findAll() {
		log.debug("finding all Cursos instances");
		try {
			String queryString = "from Cursos";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que guarda o actualitza un registre mitjançant una instància de l'entitat Cursos sense que aquesta 
	 * estigui adjunta a una sessió d'Hibernate.
	 * @param detachedInstance Instància de la classe Cursos.
	 * @return Un objecte de tipus Cursos adjunt a una sessió d'Hibernate.
	 */
	public Cursos merge(Cursos detachedInstance) {
		log.debug("merging Cursos instance");
		try {
			Cursos result = (Cursos) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	/**
	 * Adjunta una instància transitòria o individual a la sessió d'una còpia de seguretat per finalment actualitzar.
	 * @param instance Instància de la classe Cursos.
	 */
	public void attachDirty(Cursos instance) {
		log.debug("attaching dirty Cursos instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	/**
	 * Adjunta una instància de la sessió amb un mode de bloqueig definit.
	 * @param instance Instància de la classe Cursos.
	 */
	public void attachClean(Cursos instance) {
		log.debug("attaching clean Cursos instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}