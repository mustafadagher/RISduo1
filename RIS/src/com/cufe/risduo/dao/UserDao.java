package com.cufe.risduo.dao;

import java.util.List;
import javax.sql.DataSource;

import com.cufe.risduo.model.User;

public interface UserDao {
   /** 
    * This is the method to be used to initialize
    * database resources ie. connection.
    */
   public void setDataSource(DataSource ds);
   /** 
    * This is the method to be used to create
    * a record in the User table.
    */
   public void create(String userName, String password, String userFullname,
			String userSex, int userTel, String role);
   /** 
    * This is the method to be used to list down
    * a record from the User table corresponding
    * to a passed User id.
    */
   public User getUser(String userName);
   /** 
    * This is the method to be used to list down
    * all the records from the User table.
    */
   public List<User> listUsers(String userName);
   /** 
    * This is the method to be used to delete
    * a record from the User table corresponding
    * to a passed User id.
    */
   public void delete();
   /** 
    * This is the method to be used to update
    * a record into the User table.
    */
   
   void update(String userName, String password, String userFullname,
		String userSex, int userTel, String role);
}

