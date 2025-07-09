package org.elingua.DAO;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elingua.model.Idiomes;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 *  Un Data Acces Object (DAO) que proporciona suport de persistència i de cerca a la entitat Idiomes.
 * 
 * @author Marina Martin
 * @see org.elingua.model.Idiomes
 */

public class IdiomesDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(IdiomesDAO.class);
	/** Propietats constants de IdiomesDAO */
	public static final String NOM = "nom";
	/**
	 * Mètode que permet a l'entitat Idiomes guardar els seus camps en un registre a la Base de dades.
	 * @param transientInstance Instància de la classe Idiomes.
	 * @throws RuntimeException
	 */
	public void save(Idiomes transientInstance) {
		log.debug("saving Idiomes instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Idiomes eliminar un objecte associat a un registre de la Base de dades.
	 * @param persistentInstance Instància de la classe Idiomes.
	 * @throws RuntimeException
	 */
	public void delete(Idiomes persistentInstance) {
		log.debug("deleting Idiomes instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Idiomes recuperar un objecte associat a un registre de la Base de dades.
	 * @param id L'identificador únic del registre de la base de dades.
	 * @return Un objecte de tipus Idiomes amb l'identificador introduït. 
	 * @throws RuntimeException
	 */
	public Idiomes findById(java.lang.Integer id) {
		log.debug("getting Idiomes instance with id: " + id);
		try {
			Idiomes instance = (Idiomes) getSession().get(
					"org.elingua.model.Idiomes", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Idiomes recuperar una llista d'objectes associats a registres de la Base de dades.
	 * @param instance Instància de la classe Idiomes.
	 * @return Llista d'objectes associats a registres de la Base de dades.
	 */
	public List findByExample(Idiomes instance) {
		log.debug("finding Idiomes instance by example");
		try {
			List results = getSession()
					.createCriteria("org.elingua.model.Idiomes")
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
	 * Mètode que permet a l'entitat Idiomes recuperar una llista d'objectes segons les seves propietats.
	 * @param propertyName El nom de la propietat a cercar.
	 * @param value El valor de la propietat a cercar.
	 * @return Una llista d'objectes associats a uns registres de la base de dades.
	 * @throws RuntimeException
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Idiomes instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Idiomes as model where model."
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
 * @param nom El nom de l'idioma.
 * @return Una llista d'objectes associats a tots els registres de la taula de la base de dades.
 */
	public List findByNom(Object nom) {
		return findByProperty(NOM, nom);
	}
	/**
	 * Mètode que permet a l'entitat Idiomes recuperar tots els registres de la taula de la base de dades.
	 * @return Una llista d'objectes associats a tots els registres de la taula de la base de dades.
	 * @throws RuntimeException
	 */
	public List findAll() {
		log.debug("finding all Idiomes instances");
		try {
			String queryString = "from Idiomes";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que guarda o actualitza un registre mitjançant una instància de l'entitat Idiomes sense que aquesta 
	 * estigui adjunta a una sessió d'Hibernate.
	 * @param detachedInstance Instància de la classe Idiomes.
	 * @return Un objecte de tipus Idiomes adjunt a una sessió d'Hibernate.
	 */
	public Idiomes merge(Idiomes detachedInstance) {
		log.debug("merging Idiomes instance");
		try {
			Idiomes result = (Idiomes) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	/**
	 * Adjunta una instància transitòria o individual a la sessió d'una còpia de seguretat per finalment actualitzar.
	 * @param instance Instància de la classe Idiomes.
	 */
	public void attachDirty(Idiomes instance) {
		log.debug("attaching dirty Idiomes instance");
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
	 * @param instance Instància de la classe Idiomes.
	 */
	public void attachClean(Idiomes instance) {
		log.debug("attaching clean Idiomes instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}