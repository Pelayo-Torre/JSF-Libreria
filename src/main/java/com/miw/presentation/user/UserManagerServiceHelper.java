package com.miw.presentation.user;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.miw.business.usermanager.UserManagerService;
import com.miw.model.RegisterUserBean;

@ManagedBean(name = "userManagerServiceHelper", eager = true)
@ApplicationScoped
public class UserManagerServiceHelper {

	Logger logger = Logger.getLogger(this.getClass());
	
	RegisterUserBean registerInfo = new RegisterUserBean();

	public RegisterUserBean getRegisterInfo() {
		return registerInfo;
	}

	public void setRegisterInfo(RegisterUserBean registerInfo) {
		this.registerInfo = registerInfo;
	}
	
	@ManagedProperty(value = "#{bookManagerService}")
	private UserManagerService userManagerService = null;
	
	public String registerUser() throws Exception {
		FacesMessage msg;
		if(userManagerService.getUserByLogin(registerInfo.getLogin()) != null) {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El login establecido ya está registrado", "El login establecido ya está registrado");
			FacesContext.getCurrentInstance().addMessage("login", msg);
			return "";
		}
		else {
			userManagerService.saveUser(registerInfo);
			return "";
		}
	}
	
	
	public String showRegister(){
		return "success";
	}
	
	public String register() {
		return "success";
	}
	
}
