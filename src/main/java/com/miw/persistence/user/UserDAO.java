package com.miw.persistence.user;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.log4j.Logger;

import com.miw.model.RegisterUserBean;
import com.miw.persistence.Dba;

public class UserDAO implements UserDataService{
	
	protected Logger logger = Logger.getLogger(getClass());

	public void saveUser(RegisterUserBean user) throws Exception {
		
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			em.persist(user);
			em.getTransaction().commit();

			logger.debug("User inserted!!");
			
		} finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}
	}

	public RegisterUserBean getUserByLogin(String login) throws Exception {
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();

			RegisterUserBean user = em.createQuery(
					"SELECT u FROM User u WHERE u.login = ?", RegisterUserBean.class)
					.setParameter(1, login)
					.getSingleResult();

			logger.debug("User by login: "+ user);
			
			return user;
			
		} catch (NoResultException e) {
			//Si salta esta excepción quiere decir que el usuario no existe en base de datos
			return null;
		}
		finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}
		
	}

	public boolean userExists(String login, String password) throws Exception {
		Dba dba = new Dba();
		
		try {
			EntityManager em = dba.getActiveEm();

			RegisterUserBean user = em.createQuery(
					"SELECT u FROM User u WHERE u.login = ? AND u.password = ?", RegisterUserBean.class)
					.setParameter(1, login)
					.setParameter(2, password)
					.getSingleResult();

			logger.debug("User by login AND password: "+ user);
			
			if(user != null)
				return true;
			
		} catch (NoResultException e) {
			//Si salta esta excepción quiere decir que el usuario no existe en base de datos
			return false;
		}
		finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}
		return false;
	}

}
