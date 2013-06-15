package com.cufe.risduo.model;

public class User {
	private String userName;
	private String Password;
	private String role;
	private String userFullName;
	private String userSex;
	private int userTel;
	
	public User(String userName, String password, String role) {
		
		setUserName(userName);
		setPassword(password);
		setRole(role);
	}
	public User() {
		
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userId) {
		this.userName = userId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public int getUserTel() {
		return userTel;
	}
	public void setUserTel(int userTel) {
		this.userTel = userTel;
	}

}
