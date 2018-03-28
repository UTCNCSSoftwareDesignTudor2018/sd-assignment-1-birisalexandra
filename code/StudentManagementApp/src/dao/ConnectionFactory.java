package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
	private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/studentdb?useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "1234";
	
	private static ConnectionFactory instance = new ConnectionFactory();
	
	/*
	 * In the constructor the connection to the DB will be placed in a Singleton object
	 * Class.forName(String) returns the Class object associated with the class with the given string 
	 */
	private ConnectionFactory() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Private method for creating a connection
	 * @return conn, the created connection
	 */
	private Connection createConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DBURL, USER, PASS);
			if (conn != null)
				System.out.println("Connected succesfully!");
		} catch (SQLException e) {
			System.out.println("Not connected!");
		}
		return conn;
	}
	
	/**
	 * Method for getting an active connection
	 * @return
	 */
	public static Connection getConnection() {
		return instance.createConnection();
	}
	
	/**
	 * Method for closing a connection
	 * @param conn, the connection we want to close
	 */
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "Error occured at closing the connection");
			}
		}
	}
	
	/**
	 * Method for closing a statement
	 * @param state
	 */
	public static void close(Statement state) {
		if (state != null) {
			try {
				state.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "Error occured at closing the statement");
			}
		}
	}
	
	/**
	 * Method for closing a result
	 * @param res
	 */
	public static void close(ResultSet res) {
		if (res != null) {
			try {
				res.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "Error occured at closing the ResultSet");
			}
		}
	}
}