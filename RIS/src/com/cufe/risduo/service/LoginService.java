package com.cufe.risduo.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cufe.risduo.dao.UserDaoImpl;
import com.cufe.risduo.model.User;

public class LoginService {
	
	public boolean verifyLogin(User user){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDaoImpl dao = ctx.getBean("userDaoImpl", UserDaoImpl.class);
		
		String inputuserName = user.getUserName();
		User user1 = dao.getUser(inputuserName);
		
		if (inputuserName.equals(user1.getUserName()) && user.getPassword().equals(user1.getPassword())){
			return true;
		}
		return false;
	}
}
