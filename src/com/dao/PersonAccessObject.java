/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.person.Person;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public class PersonAccessObject extends DataAccessObject<Person> {

    private static final String ID_COL = "IDPerson";
    private static final String FIRSTNAME_COL = "PersonFirstName";
    private static final String LASTNAME_COL = "PersonLastName";
    private static final String REGISTRY_DATE_COL = "RegistryDate";

    public PersonAccessObject(String in_databaseTable) {
        super(in_databaseTable);
    }

    @Override
    public int insertObject(Person object) {
        DatabaseConnectionManager connManager = null;
        try {
            String sqlQuery = createInsertQuery(object);
            connManager = getConnectionManager();
            connManager.openConnection();
            Connection dbConnection = connManager.getConnection();
            Statement statement = dbConnection.createStatement();
            int result = statement.executeUpdate(sqlQuery);
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(PersonAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connManager.closeConnection();
        }
        return ERROR_EXECUTING_UPDATE;
    }

    @Override
    public int updateObject(Person object) {
        return ERROR_EXECUTING_UPDATE;
    }

    @Override
    public int deleteObject(Person object) {
        DatabaseConnectionManager connManager = null;
        try {
            String sqlDeleteQuery = createDeleteQuery(object);
            connManager.openConnection();
            Connection dbConnection = connManager.getConnection();
            Statement deleteStatement = dbConnection.createStatement();
            int result = deleteStatement.executeUpdate(sqlDeleteQuery);
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(PersonAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connManager.closeConnection();
        }
        return ERROR_EXECUTING_UPDATE;
    }

    @Override
    public ArrayList<Person> readObject(String[] tableValues) {
        ArrayList<Person> personsList = new ArrayList<Person>();
        DatabaseConnectionManager connManager = getConnectionManager();
        try {
            String selectQuery = createSelectQuery(tableValues);
            connManager.openConnection();
            Connection dbConnection = connManager.getConnection();
            Statement selectStatement = dbConnection.createStatement();
            ResultSet selectResult = selectStatement.executeQuery(selectQuery);
            personsList = createPersonArrayList(selectResult);
        } catch (SQLException ex) {
            Logger.getLogger(PersonAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connManager.closeConnection();
        }
        return personsList;
    }

    private ArrayList<Person> createPersonArrayList(ResultSet inDBResult) {
        ArrayList<Person> personsLists = new ArrayList<Person>();
        try {
            while (inDBResult.next()) {
                String firstName = inDBResult.getString(FIRSTNAME_COL);
                String lastName = inDBResult.getString(LASTNAME_COL);
                Date registryDate = inDBResult.getDate(REGISTRY_DATE_COL);
                
                Person person = new Person();
                person.setFirstName(firstName);
                person.setLastName(lastName);
                person.setRegistrationDate(registryDate);
                personsLists.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personsLists;
    }

    private String createSelectQuery(String[] values) {
        String selectQuery = "SELECT ";
        selectQuery += values[0];
        for (int i = 1; i < values.length; i++) {
            selectQuery += "," + values[i];
        }
        selectQuery += " FROM " + getDatabaseTable() + ";";
        return selectQuery;
    }

    private String createInsertQuery(Person in_InsertingPerson) {
        String sqlQuery = "";
        sqlQuery = "INSERT INTO " + getDatabaseTable();
        sqlQuery += "( " + ID_COL + "," + FIRSTNAME_COL + ","
                + LASTNAME_COL + "," + REGISTRY_DATE_COL + ")"
                + "VALUES(nextval('ID_Person_Increment'), '" + in_InsertingPerson.getFirstName() + "'"
                + "," + "'" + in_InsertingPerson.getLastName() + "','"
                + in_InsertingPerson.getRegistrationDate().toGMTString() + "'"
                + ");";
        return sqlQuery;
    }

    private String createDeleteQuery(Person inDeletingPerson) {
        String deleteSQLQuery = "DELETE FROM " + getDatabaseTable();
        deleteSQLQuery += "WHERE " + FIRSTNAME_COL + " = '" + inDeletingPerson.getFirstName() + "'";
        deleteSQLQuery += " && " + LASTNAME_COL + " = '" + inDeletingPerson.getLastName() + "';";
        return deleteSQLQuery;
    }
}
