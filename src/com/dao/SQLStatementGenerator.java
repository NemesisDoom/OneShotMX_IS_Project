/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

/**
 *
 * @author Miguel
 */
public abstract class SQLStatementGenerator<T> {
    
    public SQLStatementGenerator(String inDBTable){
        setDatabaseTable(inDBTable);
    }
    
    public final void setDatabaseTable(String inDbTable){
        databaseTable = inDbTable;
    }
    
    public String getDatabaseTable(){
        return databaseTable;
    }
    
    public abstract String createSelectStatement(String[] tableValues,String condition);
    public abstract String createUpdateStatement(T prevObject,T newObject);
    public abstract String createDeleteStatement(T deletingObject);
    public abstract String createInsertStatement(T insertingObject);
    
    private String databaseTable;
    
}
