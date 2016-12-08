package org.admu.model;

public class User {
	private Integer userId;
	private String userName;
	private String passName;
		
	public User(Integer userId, String userName, String passName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passName = passName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassName() {
		return passName;
	}
	public void setPassName(String passName) {
		this.passName = passName;
	}
	
	
}
