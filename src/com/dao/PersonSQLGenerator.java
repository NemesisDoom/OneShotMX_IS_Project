/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.person.Person;

/**
 *
 * @author Miguel
 */
public class PersonSQLGenerator extends SQLStatementGenerator<Person> {
    
    private final String ID_COL;
    private final String FIRSTNAME_COL;
    private final String LASTNAME_COL;
    private final String REGISTRY_DATE_COL;
    
    public PersonSQLGenerator(
            String inDBTable,
            String inIDCol,
            String inFirstNameCol,
            String inLastNameCol,
            String inRgstrDateCol
            ){
        super(inDBTable);
        ID_COL = inIDCol;
        FIRSTNAME_COL = inFirstNameCol;
        LASTNAME_COL = inLastNameCol;
        REGISTRY_DATE_COL = inRgstrDateCol;
    }
    
    @Override
    public String createSelectStatement(String[] tableValues,String condition) {
        String sqlQuery = "SELECT ";
        sqlQuery += tableValues[0];
        for(int i=1;i<tableValues.length;i++){
            sqlQuery += "," + tableValues[i];
        }
        sqlQuery += "FROM " + getDatabaseTable();
        sqlQuery += condition == null ? ";" : "WHERE " + condition + ";";
        return sqlQuery;
    }

    @Override
    public String createUpdateStatement(Person prevObject, Person newObject) {
        String sqlQuery = "";
        sqlQuery += "UPDATE " + getDatabaseTable() + "SET ";
        sqlQuery += "PersonFirstName = '"+newObject.getFirstName()+"',";
        sqlQuery += "PersonLastName = '"+newObject.getLastName() +"'";
        sqlQuery += " WHERE PersonFirstName = '"+prevObject.getFirstName()+"'";
        sqlQuery += " AND PersonLastName = '"+prevObject.getLastName()+"';";
        return sqlQuery;
    }

    @Override
    public String createDeleteStatement(Person deletingObject) {
        String sqlQuery = "DELETE FROM " + getDatabaseTable() + " ";
        sqlQuery += "WHERE PersonFirstName = '" +deletingObject.getFirstName() +"' ";
        sqlQuery += "AND PersonLastName = '" + deletingObject.getLastName() + "';";
        return sqlQuery;
    }

    @Override
    public String createInsertStatement(Person insertingObject) {
        String sqlQuery = "";
        sqlQuery = "INSERT INTO " + getDatabaseTable();
        sqlQuery += "( " + ID_COL + "," + FIRSTNAME_COL + ","
                + LASTNAME_COL + "," + REGISTRY_DATE_COL + ")"
                + "VALUES(nextval('ID_Person_Increment'), '" + insertingObject.getFirstName() + "'"
                + "," + "'" + insertingObject.getLastName() + "','"
                + insertingObject.getRegistrationDate().toGMTString() + "'"
                + ");";
        return sqlQuery;
    }
}
