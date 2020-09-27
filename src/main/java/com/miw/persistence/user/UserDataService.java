package com.miw.persistence.user;

import com.miw.model.RegisterUserBean;

public interface UserDataService {
	
	public void saveUser(RegisterUserBean user) throws Exception ;
	public RegisterUserBean getUserByLogin(String login) throws Exception ;
	public boolean userExists(String login, String password) throws Exception;

}
