package com.miw.presentation.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.miw.model.UserBean;

@ManagedBean
@SessionScoped
public class Controller {
	Logger logger = Logger.getLogger(this.getClass());

	private UserBean loginInfo = new UserBean();

	public UserBean getLoginInfo() {
		return loginInfo;
	}

	public void setLoginInfo(UserBean loginInfo) {
		logger.debug("Setting loginInfo");
		this.loginInfo = loginInfo;
	}

	public String login() {
		logger.debug("doing login with " + loginInfo);
		FacesMessage msg;
		if (loginInfo.getLogin().equals("admin") && loginInfo.getPassword().equals("amazin"))
		{
		    msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@ "+ loginInfo.getLogin(), loginInfo.getLogin());
			FacesContext.getCurrentInstance().addMessage("welcome", msg);
			return "success";
		}
		else
		{
			 msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error: Invalid credentials",
                     "Credentials are not valid");
			 FacesContext.getCurrentInstance().addMessage(null, msg);

			return "login-error";
		}
	}

	public String showBooksAction() {
		logger.debug("Redirecting to showBooks view with success");
		// At this point we interact with the model...
		return "success";
	}
	
	public String showAddCartAction() {
		logger.debug("Redirecting to showAddCart view with success");
		// At this point we interact with the model...
		return "success";
	}
		
	public String showCartAction() {
		logger.debug("Redirecting to showCart view with success");
		// At this point we interact with the model...
		return "success";
	}

	public String showSpecialOfferAction() {
		logger.debug("Redirecting to showSpecialOffer view");
		return "success";
	}

	public String startAction() {
		return "success";
	}
}
