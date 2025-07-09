package org.elingua.DAO;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elingua.model.HistorialCursVisitat;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Un Data Acces Object (DAO) que proporciona suport de persistència i de cerca a la entitat HistorialCursVisitat.  
 * 
 * @author Marina Martin
 * @see org.elingua.model.HistorialCursVisitat
 */

public class HistorialCursVisitatDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory
			.getLog(HistorialCursVisitatDAO.class);

	/**
	 * Mètode que permet a l'entitat HistorialCursVisitat guardar els seus camps en un registre a la Base de dades.
	 * @param transientInstance Instància de la classe HistorialCursVisitat.
	 * @throws RuntimeException
	 */

	public void save(HistorialCursVisitat transientInstance) {
		log.debug("saving HistorialCursVisitat instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat HistorialCursVisitat eliminar un objecte associat a un registre de la Base de dades.
	 * @param persistentInstance Instància de la classe HistorialCursVisitat.
	 * @throws RuntimeException
	 */
	public void delete(HistorialCursVisitat persistentInstance) {
		log.debug("deleting HistorialCursVisitat instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat HistorialCursVisitat recuperar un objecte associat a un registre de la Base de dades.
	 * @param id L'identificador únic del registre de la base de dades.
	 * @return Un objecte de tipus HistorialCursVisitat amb l'identificador introduït. 
	 * @throws RuntimeException
	 */
	public HistorialCursVisitat findById(java.lang.Integer id) {
		log.debug("getting HistorialCursVisitat instance with id: " + id);
		try {
			HistorialCursVisitat instance = (HistorialCursVisitat) getSession()
					.get("org.elingua.model.HistorialCursVisitat", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(HistorialCursVisitat instance) {
		log.debug("finding HistorialCursVisitat instance by example");
		try {
			List results = getSession()
					.createCriteria("org.elingua.model.HistorialCursVisitat")
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
	 * Mètode que permet a l'entitat HistorialCursVisitat recuperar una llista d'objectes segons les seves propietats.
	 * @param propertyName El nom de la propietat a cercar.
	 * @param value El valor de la propietat a cercar.
	 * @return Una llista d'objectes associats a uns registres de la base de dades.
	 * @throws RuntimeException
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding HistorialCursVisitat instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from HistorialCursVisitat as model where model."
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
	 * Mètode que permet a l'entitat HistorialCursVisitat recuperar tots els registres de la taula de la base de dades.
	 * @return Una llista d'objectes associats a tots els registres de la taula de la base de dades.
	 * @throws RuntimeException
	 */
	public List findAll() {
		log.debug("finding all HistorialCursVisitat instances");
		try {
			String queryString = "from HistorialCursVisitat";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public HistorialCursVisitat merge(HistorialCursVisitat detachedInstance) {
		log.debug("merging HistorialCursVisitat instance");
		try {
			HistorialCursVisitat result = (HistorialCursVisitat) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(HistorialCursVisitat instance) {
		log.debug("attaching dirty HistorialCursVisitat instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(HistorialCursVisitat instance) {
		log.debug("attaching clean HistorialCursVisitat instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}