package com.algonquin.cst8288.assignment2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Class to create DBConnection instance that apply Singleton pattern
 * 
 * @author yao yi
 * Course section: CST8288_033
 * Lab professor: Sazzad Hossain
 */
public class DBConnection {

    private static Connection connection = null;
    private static DBConnection dbConnectionInstance;
	
    private String serverUrl = "jdbc:mysql://localhost:3306/bookvault";
    private String userString = "root";
    private String passwordString = "rootUserPasswd";
    private String driverString = "com.mysql.cj.jdbc.Driver";
	
    
    // Private constructor 
    private DBConnection() throws SQLException {
        try {
            // Load the JDBC driver
            Class.forName(driverString);
            connection = DriverManager.getConnection(serverUrl, userString, passwordString);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load JDBC driver");
        }
    }

    // Method to ensure only one DBConnection instance is initialized
    public static synchronized DBConnection getInstance() throws SQLException {
        if (dbConnectionInstance == null) {
            dbConnectionInstance = new DBConnection();       
        }
        return dbConnectionInstance;
    }
    
    //Method to get connection object
    public Connection getConnection() {
        return connection;
    }
    
}