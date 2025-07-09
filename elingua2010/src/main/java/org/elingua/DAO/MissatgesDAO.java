package org.elingua.DAO;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elingua.model.Missatges;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Un Data Acces Object (DAO) que proporciona suport de persistència i de cerca a la entitat Missatges.
 * 
 * @author Marina Martin
 * @see org.elingua.model.Missatges
 */

public class MissatgesDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(MissatgesDAO.class);
	/** Propietats constants de MissatgesDAO */
	public static final String ASSUMPTE = "assumpte";
	public static final String CONTINGUT = "contingut";
	/**
	 * Mètode que permet a l'entitat Missatges guardar els seus camps en un registre a la Base de dades.
	 * @param transientInstance Instància de la classe Missatges.
	 * @throws RuntimeException
	 */
	public void save(Missatges transientInstance) {
		log.debug("saving Missatges instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Missatges eliminar un objecte associat a un registre de la Base de dades.
	 * @param persistentInstance Instància de la classe Missatges.
	 * @throws RuntimeException
	 */
	public void delete(Missatges persistentInstance) {
		log.debug("deleting Missatges instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Missatges recuperar un objecte associat a un registre de la Base de dades.
	 * @param id L'identificador únic del registre de la base de dades.
	 * @return Un objecte de tipus Missatges amb l'identificador introduït. 
	 * @throws RuntimeException
	 */
	public Missatges findById(java.lang.Integer id) {
		log.debug("getting Missatges instance with id: " + id);
		try {
			Missatges instance = (Missatges) getSession().get(
					"org.elingua.model.Missatges", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Missatges recuperar una llista d'objectes associats a registres de la Base de dades.
	 * @param instance Instància de la classe Missatges.
	 * @return Llista d'objectes associats a registres de la Base de dades.
	 */
	public List findByExample(Missatges instance) {
		log.debug("finding Missatges instance by example");
		try {
			List results = getSession()
					.createCriteria("org.elingua.model.Missatges")
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
	 * Mètode que permet a l'entitat Missatges recuperar una llista d'objectes segons les seves propietats.
	 * @param propertyName El nom de la propietat a cercar.
	 * @param value El valor de la propietat a cercar.
	 * @return Una llista d'objectes associats a uns registres de la base de dades.
	 * @throws RuntimeException
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Missatges instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Missatges as model where model."
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
 * @param assumpte L'assumpte del missatge.
 * @return Una llista d'objectes associats a tots els registres de la taula de la base de dades.
 */
	public List findByAssumpte(Object assumpte) {
		return findByProperty(ASSUMPTE, assumpte);
	}
/**
 * Utilitza el mètode findByProperty per recuperar una llista d'objectes.
 * @param contingut El contingut el missatge.
 * @return Una llista d'objectes associats a tots els registres de la taula de la base de dades.
 */
	public List findByContingut(Object contingut) {
		return findByProperty(CONTINGUT, contingut);
	}
	/**
	 * Mètode que permet a l'entitat Missatges recuperar tots els registres de la taula de la base de dades.
	 * @return Una llista d'objectes associats a tots els registres de la taula de la base de dades.
	 * @throws RuntimeException
	 */
	public List findAll() {
		log.debug("finding all Missatges instances");
		try {
			String queryString = "from Missatges";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que guarda o actualitza un registre mitjançant una instància de l'entitat Missatges sense que aquesta 
	 * estigui adjunta a una sessió d'Hibernate.
	 * @param detachedInstance Instància de la classe Missatges.
	 * @return Un objecte de tipus Missatges adjunt a una sessió d'Hibernate.
	 */
	public Missatges merge(Missatges detachedInstance) {
		log.debug("merging Missatges instance");
		try {
			Missatges result = (Missatges) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	/**
	 * Adjunta una instància transitòria o individual a la sessió d'una còpia de seguretat per finalment actualitzar.
	 * @param instance Instància de la classe Missatges.
	 */
	public void attachDirty(Missatges instance) {
		log.debug("attaching dirty Missatges instance");
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
	 * @param instance Instància de la classe Missatges.
	 */
	public void attachClean(Missatges instance) {
		log.debug("attaching clean Missatges instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}