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
    
    public DataAccessObject(String in_UserName,
            String in_DatabasePassword,
            String in_Url,
            String in_DatabaseName,
            int in_DatabasePort){
        connectionManager = new DatabaseConnectionManager(in_UserName,in_DatabasePassword,
                in_Url,in_DatabaseName,in_DatabasePort);
    }
    
    public DatabaseConnectionManager getConnectionManager(){
        return connectionManager;
    }
    
    public abstract int createObject(T object);
    public abstract int updateObject(T object);
    public abstract ResultSet readObject(String sqlStatement);
    public abstract int deleteObject(T object);
}
