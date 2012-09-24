/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.sql.ResultSet;


/**
 *
 * @author Miguel
 */
public abstract class DataAccessObject<T> {
    private DatabaseConnectionManager connectionManager;
    
    public DataAccessObject(String in_DatabaseUsername,
            String in_DatabasePassword,
            String in_DatabaseUrl,
            String in_DatabaseName,
            int in_DatabasePort){
        connectionManager = new DatabaseConnectionManager(in_DatabaseUsername,
                in_DatabasePassword,
                in_DatabaseUrl,
                in_DatabaseName,
                in_DatabasePort);
        
    }
    
    public DatabaseConnectionManager getConnectionManager(){
        return connectionManager;
    }
    
    public abstract int addObject(final T object);
    public abstract int editObject(final T object);
    public abstract ResultSet selectObject(final String sqlStatement);
    public abstract int deleteObject(final T object);
}
