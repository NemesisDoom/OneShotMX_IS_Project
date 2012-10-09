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
        try {
            String sqlQuery = createInsertQuery(object);
            DatabaseConnectionManager connMannager = getConnectionManager();
            connMannager.openConnection();
            Connection dbConnection = connMannager.getConnection();
            Statement statement = dbConnection.createStatement();
            int result = statement.executeUpdate(sqlQuery);
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(PersonAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int updateObject(Person object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int deleteObject(Person object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResultSet readObject(String sqlStatement) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private String createInsertQuery(Person in_InsertingPerson) {
        String sqlQuery = "";
        sqlQuery = "INSERT INTO " + getDatabaseTable();
        sqlQuery += "( " + ID_COL + "," + FIRSTNAME_COL + ","
                + LASTNAME_COL + "," + REGISTRY_DATE_COL + ")"
                + "VALUES(nextval('ID_Person_Increment'), " + in_InsertingPerson.getFirstName()
                + "," + in_InsertingPerson.getLastName() + "," + in_InsertingPerson.getRegistrationDate().toGMTString()
                + ");";
        return sqlQuery;
    }
}
