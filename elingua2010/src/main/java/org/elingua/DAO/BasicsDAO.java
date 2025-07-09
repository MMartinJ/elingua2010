package org.elingua.DAO;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elingua.model.Basics;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * Un Data Acces Object (DAO) que proporciona suport de persistència i de cerca a la entitat Basics.
 * 
 * @author Marina Martin
 * @see org.elingua.model.Basics
 */

public class BasicsDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(BasicsDAO.class);
	/** Propietats constants de BasicsDAO */
	public static final String NOM = "nom";
	public static final String COGNOM1 = "cognom1";
	public static final String COGNOM2 = "cognom2";
	public static final String SEXE = "sexe";
	public static final String EMAIL = "email";
	/**
	 * Mètode que permet a l'entitat Basics guardar els seus camps en un registre a la Base de dades
	 * @param transientInstance Instància de la classe Basics.
	 * @throws RuntimeException
	 */
	public void save(Basics transientInstance) {
		log.debug("saving Basics instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Basics eliminar un objecte associat a un registre de la Base de dades.
	 * @param persistentInstance Instància de la classe Basics.
	 * @throws RuntimeException
	 */
	public void delete(Basics persistentInstance) {
		log.debug("deleting Basics instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Basics recuperar un objecte associat a un registre de la Base de dades.
	 * @param id L'identificador únic del registre de la base de dades.
	 * @return Un objecte de tipus Basics amb l'identificador introduït.
	 * @throws RuntimeException 
	 */
	public Basics findById(java.lang.Integer id) {
		log.debug("getting Basics instance with id: " + id);
		try {
			Basics instance = (Basics) getSession().get(
					"org.elingua.model.Basics", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que permet a l'entitat Basics recuperar una llista d'objectes associats a registres de la Base de dades.
	 * @param instance Instància de la classe Basics.
	 * @return Llista d'objectes associats a registres de la Base de dades.
	 */
	public List findByExample(Basics instance) {
		log.debug("finding Basics instance by example");
		try {
			List results = getSession()
					.createCriteria("org.elingua.model.Basics")
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
	 * Mètode que permet a l'entitat Basics recuperar una llista d'objectes segons les seves propietats.
	 * @param propertyName El nom de la propietat a cercar.
	 * @param value El valor de la propietat a cercar.
	 * @return Una llista d'objectes associats a uns registres de la base de dades.
	 * @throws RuntimeException
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Basics instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Basics as model where model."
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
	 * Mètode que permet a l'entitat Basics recuperar tots els registres de la taula de la base de dades.
	 * @return Una llista d'objectes associats a tots els registres de la taula de la base de dades.
	 * @throws RuntimeException
	 */
	public List findAll() {
		log.debug("finding all Basics instances");
		try {
			String queryString = "from Basics";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * Mètode que guarda o actualitza un registre mitjançant una instància de l'entitat Basics sense que aquesta 
	 * estigui adjunta a una sessió d'Hibernate.
	 * @param detachedInstance Instància de la classe Basics.
	 * @return Un objecte de tipus Basics adjunt a una sessió d'Hibernate.
	 */
	public Basics merge(Basics detachedInstance) {
		log.debug("merging Basics instance");
		try {
			Basics result = (Basics) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	/**
	 * Adjunta una instància transitòria o individual a la sessió d'una còpia de seguretat per finalment actualitzar.
	 * @param instance Instància de la classe Basics.
	 */
	public void attachDirty(Basics instance) {
		log.debug("attaching dirty Basics instance");
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
	 * @param instance Instància de la classe Basics.
	 */
	public void attachClean(Basics instance) {
		log.debug("attaching clean Basics instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}