package org.admu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDataBase {

	private static ConnectionDataBase instance;
	private static Connection connection;
	private static Statement state;
	
	public static ConnectionDataBase getInstance(){
		return (instance == null) ? new ConnectionDataBase(): instance ;
	}
	
	
	public Connection init(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/?user=root?&useSSL=false";
			connection = DriverManager.getConnection(url,"binary_db","B!n@ry123");
			
			state = connection.createStatement();
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public Connection getConnection(){
		return connection;
	}
	
	public void executeStatement(String query){
		try {
			state.executeQuery(query);
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public ResultSet getQueryResults(String query){
		ResultSet result = null;
		Statement statement = null;
		try {
			statement = connection.createStatement();
			result = statement.executeQuery(query);
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void closeStatement(Statement stm) throws Exception{
		stm.close();
	}
	
	public void closeConnection(Connection cnn){
		try {
			cnn.close();
			cnn = null;
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
}
