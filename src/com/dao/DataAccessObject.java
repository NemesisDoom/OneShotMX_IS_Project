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
    private String databaseTable;
    
    public DataAccessObject(String in_databaseTable){
        databaseTable = in_databaseTable;
        connectionManager = DatabaseConnectionManager.getInstance();
    }
    
    public String getDatabaseTable(){
        return databaseTable;
    }
    
    public DatabaseConnectionManager getConnectionManager(){
        return connectionManager;
    }
    
    public abstract int insertObject(T object);
    public abstract int updateObject(T object);
    public abstract ResultSet readObject(String sqlStatement);
    public abstract int deleteObject(T object);
}
