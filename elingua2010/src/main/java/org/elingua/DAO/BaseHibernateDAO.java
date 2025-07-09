package org.elingua.DAO;

import org.hibernate.Session;


/**
 * Un Data Acces Object (DAO) per al model de domini.
 * @author Marina Martin
 */
public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}
	
}