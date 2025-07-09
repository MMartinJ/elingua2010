package org.elingua.DAO;

import org.hibernate.Session;


/**
 * Interface que dona accès a les dades del model de domini.
 * @author Marina Martin
 */
public interface IBaseHibernateDAO {
	public Session getSession();
}