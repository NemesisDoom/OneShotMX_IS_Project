/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.util.ArrayList;


/**
 *
 * @author Miguel
 */
public abstract class DataAccessObject<T> {
    public static final int ERROR_EXECUTING_UPDATE = -1;
    
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
    public abstract int updateObject(T prevObject,T newObject);
    public abstract ArrayList<T> selectDataFromDatabase(String[] tableValues);
    public abstract int deleteObject(T object);
}
