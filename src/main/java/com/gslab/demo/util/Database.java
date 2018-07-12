package com.gslab.demo.util;

import java.sql.*;

public class Database {
	
	Connection connection;
	Statement statement;
	
	public Database() {
		// TODO Auto-generated constructor stub
		this.connection = null;
		this.statement = null;
	}	
	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * @return the statement
	 */
	public Statement getStatement() {
		return statement;
	}	
	public boolean loadDriver(String driverURL) {
		try {
			Class.forName(driverURL);
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean setConnection(String URL,String username,String password) {
		try {
			this.connection = DriverManager.getConnection(URL, username, password);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean setStatement() {
		if (this.connection != null) {
			try {
				this.statement = this.connection.createStatement();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
}
