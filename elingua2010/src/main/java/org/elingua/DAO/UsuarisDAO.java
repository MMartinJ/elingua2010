package org.elingua.DAO;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elingua.model.Usuaris;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Un Data Acces Object (DAO) que proporciona suport de persistència i de cerca a la entitat Usuaris.
 * 
 * @author Marina Martin
 * @see org.elingua.model.Usuaris
 */

public class UsuarisDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(UsuarisDAO.class);
	/** Propietats constants de UsuarisDAO */
	public static final String NOM_USUARI = "nomUsuari";
	public static final String PSSWD = "psswd";
	public static final String TIPUS = "tipus";
	public static final String PRIVACITAT = "privacitat";
	/**
	 * Mètode que permet a l'entitat Usuaris guardar els seus camps en un registre a la Base de dades.
	 * @param transientInstance Instància de la classe Usuaris.
	 * @throws RuntimeException
	 */
	public void save(Usuaris transientInstance) {
		log.debug("saving Usuaris instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Usuaris eliminar un objecte associat a un registre de la Base de dades.
	 * @param persistentInstance Instància de la classe Usuaris.
	 * @throws RuntimeException
	 */
	public void delete(Usuaris persistentInstance) {
		log.debug("deleting Usuaris instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Usuaris recuperar un objecte associat a un registre de la Base de dades.
	 * @param id L'identificador únic del registre de la base de dades.
	 * @return Un objecte de tipus Usuaris amb l'identificador introduït. 
	 * @throws RuntimeException
	 */
	public Usuaris findById(java.lang.Integer id) {
		log.debug("getting Usuaris instance with id: " + id);
		try {
			Usuaris instance = (Usuaris) getSession().get(
					"org.elingua.model.Usuaris", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Usuaris recuperar una llista d'objectes associats a registres de la Base de dades.
	 * @param instance Instància de la classe Usuaris.
	 * @return Llista d'objectes associats a registres de la Base de dades.
	 */
	public List findByExample(Usuaris instance) {
		log.debug("finding Usuaris instance by example");
		try {
			List results = getSession()
					.createCriteria("org.elingua.model.Usuaris")
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
	 * Mètode que permet a l'entitat Usuaris recuperar una llista d'objectes segons les seves propietats.
	 * @param propertyName El nom de la propietat a cercar.
	 * @param value El valor de la propietat a cercar.
	 * @return Una llista d'objectes associats a uns registres de la base de dades.
	 * @throws RuntimeException
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Usuaris instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Usuaris as model where model."
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
 * @param nomUsuari El nom de l'usuari.
 * @return Una llista d'objectes associats a tots els registres de la taula de la base de dades.
 */
	public List findByNomUsuari(Object nomUsuari) {
		return findByProperty(NOM_USUARI, nomUsuari);
	}
/**
 * Utilitza el mètode findByProperty per recuperar una llista d'objectes.
 * @param psswd La contrasenya de l'usuari.
 * @return Una llista d'objectes associats a tots els registres de la taula de la base de dades.
 */
	public List findByPsswd(Object psswd) {
		return findByProperty(PSSWD, psswd);
	}
/**
 * Utilitza el mètode findByProperty per recuperar una llista d'objectes.
 * @param tipus El tipus d'usuari.
 * @return Una llista d'objectes associats a tots els registres de la taula de la base de dades.
 */
	public List findByTipus(Object tipus) {
		return findByProperty(TIPUS, tipus);
	}
/**
 * Utilitza el mètode findByProperty per recuperar una llista d'objectes.
 * @param privacitat La privacitat de l'usuari.
 * @return Una llista d'objectes associats a tots els registres de la taula de la base de dades.
 */
	public List findByPrivacitat(Object privacitat) {
		return findByProperty(PRIVACITAT, privacitat);
	}
	/**
	 * Mètode que permet a l'entitat Usuaris recuperar tots els registres de la taula de la base de dades.
	 * @return Una llista d'objectes associats a tots els registres de la taula de la base de dades.
	 * @throws RuntimeException
	 */
	public List findAll() {
		log.debug("finding all Usuaris instances");
		try {
			String queryString = "from Usuaris";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que guarda o actualitza un registre mitjançant una instància de l'entitat Usuaris sense que aquesta 
	 * estigui adjunta a una sessió d'Hibernate.
	 * @param detachedInstance Instància de la classe Usuaris.
	 * @return Un objecte de tipus Usuaris adjunt a una sessió d'Hibernate.
	 */
	public Usuaris merge(Usuaris detachedInstance) {
		log.debug("merging Usuaris instance");
		try {
			Usuaris result = (Usuaris) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	/**
	 * Adjunta una instància transitòria o individual a la sessió d'una còpia de seguretat per finalment actualitzar.
	 * @param instance Instància de la classe Usuaris.
	 */
	public void attachDirty(Usuaris instance) {
		log.debug("attaching dirty Usuaris instance");
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
	 * @param instance Instància de la classe Usuaris.
	 */
	public void attachClean(Usuaris instance) {
		log.debug("attaching clean Usuaris instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}