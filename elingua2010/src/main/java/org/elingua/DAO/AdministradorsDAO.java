package org.elingua.DAO;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elingua.model.Administradors;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Un Data Acces Object (DAO) que proporciona suport de persistència i de cerca a la entitat Administradors. 
 * 
 * @author Marina Martin
 * @see org.elingua.model.Administradors
 */

public class AdministradorsDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(AdministradorsDAO.class);

	/**
	 * Mètode que permet a l'entitat Administradors guardar els seus camps en un registre a la Base de dades
	 * @param transientInstance Instància de la classe Administradors.
	 * @throws RuntimeException
	 */

	public void save(Administradors transientInstance) {
		log.debug("saving Administradors instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Administradors eliminar un objecte associat a un registre de la Base de dades.
	 * @param persistentInstance Instància de la classe Administradors.
	 * @throws RuntimeException
	 */
	public void delete(Administradors persistentInstance) {
		log.debug("deleting Administradors instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Administradors recuperar un objecte associat a un registre de la Base de dades.
	 * @param id L'identificador únic del registre de la base de dades.
	 * @return Un objecte de tipus Administradors amb l'identificador introduït. 
	 * @throws RuntimeException
	 */
	public Administradors findById(java.lang.Integer id) {
		log.debug("getting Administradors instance with id: " + id);
		try {
			Administradors instance = (Administradors) getSession().get(
					"org.elingua.model.Administradors", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Administradors recuperar una llista d'objectes associats a registres de la Base de dades.
	 * @param instance Instància de la classe Administradors.
	 * @return Llista d'objectes associats a registres de la Base de dades.
	 */
	public List findByExample(Administradors instance) {
		log.debug("finding Administradors instance by example");
		try {
			List results = getSession()
					.createCriteria("org.elingua.model.Administradors")
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
	 * Mètode que permet a l'entitat Administradors recuperar una llista d'objectes segons les seves propietats.
	 * @param propertyName El nom de la propietat a cercar.
	 * @param value El valor de la propietat a cercar.
	 * @return Una llista d'objectes associats a uns registres de la base de dades.
	 * @throws RuntimeException
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Administradors instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Administradors as model where model."
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
	 * Mètode que permet a l'entitat Administradors recuperar tots els registres de la taula de la base de dades.
	 * @return Una llista d'objectes associats a tots els registres de la taula de la base de dades.
	 * @throws RuntimeException
	 */
	public List findAll() {
		log.debug("finding all Administradors instances");
		try {
			String queryString = "from Administradors";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que guarda o actualitza un registre mitjançant una instància de l'entitat Administradors sense que aquesta 
	 * estigui adjunta a una sessió d'Hibernate.
	 * @param detachedInstance Instància de la classe Administradors.
	 * @return Un objecte de tipus Administradors adjunt a una sessió d'Hibernate.
	 */
	public Administradors merge(Administradors detachedInstance) {
		log.debug("merging Administradors instance");
		try {
			Administradors result = (Administradors) getSession().merge(
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
	 * @param instance Instància de la classe Administradors.
	 */
	public void attachDirty(Administradors instance) {
		log.debug("attaching dirty Administradors instance");
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
	 * @param instance Instància de la classe Administradors.
	 */
	public void attachClean(Administradors instance) {
		log.debug("attaching clean Administradors instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}