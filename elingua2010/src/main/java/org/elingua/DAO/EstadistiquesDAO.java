package org.elingua.DAO;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elingua.model.Estadistiques;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Un Data Acces Object (DAO) que proporciona suport de persistència i de cerca a la entitat Estadistiques. 
 * 
 * @author Marina Martin
 * @see org.elingua.model.Estadistiques
 */

public class EstadistiquesDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(EstadistiquesDAO.class);
	/** Propietats constants de EstadistiquesDAO */
	public static final String CURS_PUB = "cursPub";
	public static final String CURS_CON = "cursCon";
	public static final String MSM_ENV = "msmEnv";
	public static final String MSM_REB = "msmReb";
	/**
	 * Mètode que permet a l'entitat Estadistiques guardar els seus camps en un registre a la Base de dades.
	 * @param transientInstance Instància de la classe Estadistiques.
	 * @throws RuntimeException
	 */
	public void save(Estadistiques transientInstance) {
		log.debug("saving Estadistiques instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Estadistiques eliminar un objecte associat a un registre de la Base de dades.
	 * @param persistentInstance Instància de la classe Estadistiques.
	 * @throws RuntimeException
	 */
	public void delete(Estadistiques persistentInstance) {
		log.debug("deleting Estadistiques instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Estadistiques recuperar un objecte associat a un registre de la Base de dades.
	 * @param id L'identificador únic del registre de la base de dades.
	 * @return Un objecte de tipus Estadistiques amb l'identificador introduït. 
	 * @throws RuntimeException
	 */
	public Estadistiques findById(java.lang.Integer id) {
		log.debug("getting Estadistiques instance with id: " + id);
		try {
			Estadistiques instance = (Estadistiques) getSession().get(
					"org.elingua.model.Estadistiques", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Estadistiques recuperar una llista d'objectes associats a registres de la Base de dades.
	 * @param instance Instància de la classe Estadistiques.
	 * @return Llista d'objectes associats a registres de la Base de dades.
	 */
	public List findByExample(Estadistiques instance) {
		log.debug("finding Estadistiques instance by example");
		try {
			List results = getSession()
					.createCriteria("org.elingua.model.Estadistiques")
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
	 * Mètode que permet a l'entitat Estadistiques recuperar una llista d'objectes segons les seves propietats.
	 * @param propertyName El nom de la propietat a cercar.
	 * @param value El valor de la propietat a cercar.
	 * @return Una llista d'objectes associats a uns registres de la base de dades.
	 * @throws RuntimeException
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Estadistiques instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Estadistiques as model where model."
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
 * @param cursPub Nombre de cursos publicats per l'usuari.
 * @return Llista d'objectes associats a registres en la base de dades.
 */
	public List findByCursPub(Object cursPub) {
		return findByProperty(CURS_PUB, cursPub);
	}
/**
 * Utilitza el mètode findByProperty per recuperar una llista d'objectes.
 * @param cursCon Nombre de cursos consultats per l'usuari. 
 * @return Llista d'objectes associats a registres en la base de dades.
 */
	public List findByCursCon(Object cursCon) {
		return findByProperty(CURS_CON, cursCon);
	}
/**
 * Utilitza el mètode findByProperty per recuperar una llista d'objectes.
 * @param msmEnv Nombre de missatges enviats per l'usuari.
 * @return Llista d'objectes associats a registres en la base de dades.
 */
	public List findByMsmEnv(Object msmEnv) {
		return findByProperty(MSM_ENV, msmEnv);
	}
/**
 * Utilitza el mètode findByProperty per recuperar una llista d'objectes.
 * @param msmReb Nombre de missatges rebuts per l'usuari.
 * @return Llista d'objectes associats a registres en la base de dades. 
 */
	public List findByMsmReb(Object msmReb) {
		return findByProperty(MSM_REB, msmReb);
	}
	/**
	 * Mètode que permet a l'entitat Estadistiques recuperar tots els registres de la taula de la base de dades.
	 * @return Una llista d'objectes associats a tots els registres de la taula de la base de dades.
	 * @throws RuntimeException
	 */
	public List findAll() {
		log.debug("finding all Estadistiques instances");
		try {
			String queryString = "from Estadistiques";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que guarda o actualitza un registre mitjançant una instància de l'entitat Estadistiques sense que aquesta 
	 * estigui adjunta a una sessió d'Hibernate.
	 * @param detachedInstance Instància de la classe Estadistiques.
	 * @return Un objecte de tipus Estadistiques adjunt a una sessió d'Hibernate.
	 */
	public Estadistiques merge(Estadistiques detachedInstance) {
		log.debug("merging Estadistiques instance");
		try {
			Estadistiques result = (Estadistiques) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	/**
	 * Adjunta una instància transitòria o individual a la sessió d'una còpia de seguretat per finalment actualitzar.
	 * @param instance Instància de la classe Estadistiques.
	 */
	public void attachDirty(Estadistiques instance) {
		log.debug("attaching dirty Estadistiques instance");
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
	 * @param instance Instància de la classe Estadistiques.
	 */
	public void attachClean(Estadistiques instance) {
		log.debug("attaching clean Estadistiques instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}