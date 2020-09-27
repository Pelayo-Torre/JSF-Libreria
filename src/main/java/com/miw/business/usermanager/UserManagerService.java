package com.miw.business.usermanager;

import com.miw.model.RegisterUserBean;

public interface UserManagerService {
	
	public void saveUser(RegisterUserBean user) throws Exception ;
	public RegisterUserBean getUserByLogin(String login) throws Exception ;
	public boolean userExists(String login, String password) throws Exception;

}
