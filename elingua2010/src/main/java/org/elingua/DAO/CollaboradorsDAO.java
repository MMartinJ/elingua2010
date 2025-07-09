package org.elingua.DAO;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elingua.model.Collaboradors;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Un Data Acces Object (DAO) que proporciona suport de persistència i de cerca a la entitat Collaboradors. 
 * 
 * @author Marina Martin
 * @see org.elingua.model.Collaboradors
 */

public class CollaboradorsDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(CollaboradorsDAO.class);
	/** Propietats constants de CollaboradorsDAO */
	public static final String NOM = "nom";
	public static final String COGNOM1 = "cognom1";
	public static final String COGNOM2 = "cognom2";
	public static final String SEXE = "sexe";
	public static final String EMAIL = "email";
	/**
	 * Mètode que permet a l'entitat Collaboradors guardar els seus camps en un registre a la Base de dades
	 * @param transientInstance Instància de la classe Collaboradors.
	 * @throws RuntimeException
	 */
	public void save(Collaboradors transientInstance) {
		log.debug("saving Collaboradors instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Collaboradors eliminar un objecte associat a un registre de la Base de dades.
	 * @param persistentInstance Instància de la classe Collaboradors.
	 * @throws RuntimeException
	 */
	public void delete(Collaboradors persistentInstance) {
		log.debug("deleting Collaboradors instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Collaboradors recuperar un objecte associat a un registre de la Base de dades.
	 * @param id L'identificador únic del registre de la base de dades.
	 * @return Un objecte de tipus Collaboradors amb l'identificador introduït. 
	 * @throws RuntimeException
	 */
	public Collaboradors findById(java.lang.Integer id) {
		log.debug("getting Collaboradors instance with id: " + id);
		try {
			Collaboradors instance = (Collaboradors) getSession().get(
					"org.elingua.model.Collaboradors", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Collaboradors recuperar una llista d'objectes associats a registres de la Base de dades.
	 * @param instance Instància de la classe Collaboradors.
	 * @return Llista d'objectes associats a registres de la Base de dades.
	 */
	public List findByExample(Collaboradors instance) {
		log.debug("finding Collaboradors instance by example");
		try {
			List results = getSession()
					.createCriteria("org.elingua.model.Collaboradors")
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
	 * Mètode que permet a l'entitat Collaboradors recuperar una llista d'objectes segons les seves propietats.
	 * @param propertyName El nom de la propietat a cercar.
	 * @param value El valor de la propietat a cercar.
	 * @return Una llista d'objectes associats a uns registres de la base de dades.
	 * @throws RuntimeException
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Collaboradors instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Collaboradors as model where model."
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
	 * @param nom Nom personal de l'usuari.
	 * @return Llista d'objectes associats a registres en la base de dades.
	 */
	public List findByNom(Object nom) {
		return findByProperty(NOM, nom);
	}
	/**
	 * Utilitza el mètode findByProperty per recuperar una llista d'objectes.
	 * @param cognom1 Primer cognom de l'usuari.
	 * @return Llista d'objectes associats a registres en la base de dades.
	 */
	public List findByCognom1(Object cognom1) {
		return findByProperty(COGNOM1, cognom1);
	}
	/**
	 * Utilitza el mètode findByProperty per recuperar una llista d'objectes.
	 * @param cognom2 Segon cognom de l'usuari.
	 * @return Llista d'objectes associats a registres en la base de dades.
	 */
	public List findByCognom2(Object cognom2) {
		return findByProperty(COGNOM2, cognom2);
	}
	/**
	 * Utilitza el mètode findByProperty per recuperar una llista d'objectes.
	 * @param sexe El sexe de l'usuari.
	 * @return Llista d'objectes associats a registres en la base de dades.
	 */
	public List findBySexe(Object sexe) {
		return findByProperty(SEXE, sexe);
	}
	/**
	 * Utilitza el mètode findByProperty per recuperar una llista d'objectes.
	 * @param email L'email de l'usuari.
	 * @return Llista d'objectes associats a registres en la base de dades.
	 */
	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}
	/**
	 * Mètode que permet a l'entitat Collaboradors recuperar tots els registres de la taula de la base de dades.
	 * @return Una llista d'objectes associats a tots els registres de la taula de la base de dades.
	 * @throws RuntimeException
	 */
	public List findAll() {
		log.debug("finding all Collaboradors instances");
		try {
			String queryString = "from Collaboradors";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que guarda o actualitza un registre mitjançant una instància de l'entitat Collaboradors sense que aquesta 
	 * estigui adjunta a una sessió d'Hibernate.
	 * @param detachedInstance Instància de la classe Collaboradors.
	 * @return Un objecte de tipus Collaboradors adjunt a una sessió d'Hibernate.
	 */
	public Collaboradors merge(Collaboradors detachedInstance) {
		log.debug("merging Collaboradors instance");
		try {
			Collaboradors result = (Collaboradors) getSession().merge(
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
	 * @param instance Instància de la classe Collaboradors.
	 */
	public void attachDirty(Collaboradors instance) {
		log.debug("attaching dirty Collaboradors instance");
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
	 * @param instance Instància de la classe Collaboradors.
	 */
	public void attachClean(Collaboradors instance) {
		log.debug("attaching clean Collaboradors instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}