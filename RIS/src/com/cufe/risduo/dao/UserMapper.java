package com.cufe.risduo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cufe.risduo.model.User;

public class UserMapper implements RowMapper<User>{

	
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		User user = new User();
	      user.setUserName(rs.getString("userName"));
	      user.setRole(rs.getString("userRole"));
	      user.setPassword(rs.getString("userPassword"));
	      return user;
		
	}

}