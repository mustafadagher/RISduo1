package com.cufe.risduo.action;

import org.apache.commons.lang.StringUtils;

import com.cufe.risduo.model.User;
import com.cufe.risduo.service.LoginService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User>{
	
	private User user =  new User();
	
	public void validate (){
		if (StringUtils.isEmpty(user.getUserName()))
			addFieldError("userId", "User Name must be set.");
		if (StringUtils.isEmpty(user.getPassword()))
			addFieldError("password", "Passowrd must be set.");
			
	}
	
	public String execute() {
		
		LoginService loginService= new LoginService();
		if (loginService.verifyLogin(user))
			return SUCCESS;
		return LOGIN;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getModel() {
		
		return user;
	}

}
