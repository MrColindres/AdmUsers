package org.admu.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.admu.model.User;
import org.admu.util.ConnectionDataBase;

public class UserController {
	
	ConnectionDataBase conn = ConnectionDataBase.getInstance();
	private static UserController instance;
	
	public static UserController getInstance(){
		return (instance == null) ? new UserController():instance;
	}
	
	
	public boolean auth(String userName, String password){
		User user = getUserByName(userName);
		
		if (user != null && user.getUserName().equals(userName) && user.getPassName().equals(password))
			return true;
		else
			return false;
	}	
	
	public User getUserByName(String userName){
		
		User usr = null;
		
		try {
			conn.init();
			ResultSet result = conn.getQueryResults("SELECT * FROM Users WHERE USERNAME = '" + userName + "'");
			 usr = (User)result.getObject(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usr;
	}
	
	public ArrayList<User> getUsers(){
		ArrayList<User> userList = new ArrayList<>();
		
		try {
			if (conn.getConnection().isClosed()){
				conn.init();
			}
			
			ResultSet rs = conn.getQueryResults("SELECT * FROM USERS");
			
			while (rs.next()){
				userList.add(new User(rs.getInt("USERID"), rs.getString("USERNAME"), rs.getString("USERPASS")));
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}
		 
		return userList;
	}
}
