package com.cufe.risduo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cufe.risduo.model.User;

@Component
public class UserDaoImpl implements UserDao{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public User getUser(String userName){
		
		String SQL = "select * from User where userName = ?";
		User user = (User)jdbcTemplate.queryForObject(SQL, 
                new Object[]{userName}, new UserMapper());
		return user;
		
	      
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdpcTemplate() {
		return jdbcTemplate;
	}

	public void setJdpcTemplate(JdbcTemplate jdpcTemplate) {
		this.jdbcTemplate = jdpcTemplate;
	}

	
	public void create(String userName, String password, String userFullname,
			String userSex, int userTel, String role) {
		
		
	}

	
	public List<User> listUsers(String userName) {
		
		return null;
	}

	
	public void delete() {
		
		
	}

	
	public void update(String userName, String password, String userFullname, String userSex, int userTel, String role) {
		
		
	}
}
