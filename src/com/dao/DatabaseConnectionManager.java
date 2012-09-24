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
    
    public DatabaseConnectionManager(final String in_UserName,
            final String in_DatabasePassword,
            final String in_Url,
            final String in_DatabaseName,
            final int in_DatabasePort){
        setUsername(in_UserName);
        setPassword(in_DatabasePassword);
        setUrl(in_Url);
        setDatabaseName(in_DatabaseName);
        setDatabasePort(in_DatabasePort);
    }
    
    public void setDatabaseName(final String in_DatabaseName){
        if(!in_DatabaseName.isEmpty()){
            databaseName = in_DatabaseName;
        }
    }
    
    public String getDatabaseName(){
        return databaseName;
    }
    
    private String createDatabaseFullString(){
        String databaseFullString = getUrl();
        databaseFullString += ":" + getDatabasePort();
        databaseFullString += "/" +getDatabaseName();
        return databaseFullString;
    }
    
    public void setDatabasePort(final int in_DatabasePort){
        if(in_DatabasePort > 0){
            port = in_DatabasePort;
        }
    }
    
    public int getDatabasePort(){
        return port;
    }
    
    public void setUsername(final String in_userName){
        if(!in_userName.isEmpty()){
            username = in_userName;
        }
    }
    
    public void setPassword(final String in_password){
        if(!in_password.isEmpty()){
            password = in_password;
        }
    }
    public void setUrl(final String in_Url){
        if(!in_Url.isEmpty()){
            url = in_Url;
        }
    }
    
    public String getUrl(){
        return url;
    }
    
    public void openConnection(){
        try {
            String dbFullUrl = createDatabaseFullString();
            connection = DriverManager.getConnection(dbFullUrl, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
