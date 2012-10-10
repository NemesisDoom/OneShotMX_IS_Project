/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public final class DatabaseConnectionManager {

    private Connection connection;
    private String username;
    private String url;
    private String password;
    private String databaseName;
    private int port;
    
    private static DatabaseConnectionManager INSTANCE;
    
    public static DatabaseConnectionManager getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DatabaseConnectionManager();
        }
        return INSTANCE;
    }
    
    public void initializeConnectionManager(String inUsername,String inPassword,
            String inUrl,String inDatabaseName,int inPort){
        setUsername(inUsername);
        setUrl(inUrl);
        setPassword(inPassword);
        setDatabaseName(inDatabaseName);
        setDatabasePort(inPort);
    }
    
    private DatabaseConnectionManager(){}

    public void setDatabaseName(String in_DatabaseName) {
        if (!in_DatabaseName.isEmpty()) {
            databaseName = in_DatabaseName;
        }
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabasePort(int in_DatabasePort) {
        if (in_DatabasePort > 0) {
            port = in_DatabasePort;
        }
    }

    public int getDatabasePort() {
        return port;
    }

    public void setUsername(String in_userName) {
        if (!in_userName.isEmpty()) {
            username = in_userName;
        }
    }

    public void setPassword(String in_password) {
        if (!in_password.isEmpty()) {
            password = in_password;
        }
    }

    public void setUrl(String in_Url) {
        if (!in_Url.isEmpty()) {
            url = in_Url;
        }
    }

    public String getUrl() {
        return url;
    }

    public void openConnection() {
        try {
            String dbFullUrl = createDatabaseFullString();
            connection = DriverManager.getConnection(dbFullUrl, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String createDatabaseFullString() {
        String databaseFullString = "jdbc:postgresql:";
        databaseFullString += "//"+getUrl() + ":"+getDatabasePort();
        databaseFullString += "/" +getDatabaseName();
        return databaseFullString;
    }
}
