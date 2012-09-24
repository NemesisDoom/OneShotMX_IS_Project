/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.person.Person;
import com.person.PersonalData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public final class PersonAccessObject extends DataAccessObject<Person> {

    private String databaseTable;
    private String databaseValues;

    public PersonAccessObject(final String in_UserName,
            final String in_DatabasePassword,
            final String in_Url,
            final String in_DatabaseName,
            final int in_DatabasePort,
            final String in_Table,
            final String in_Values)
    {
        super(in_UserName,
                in_DatabasePassword,
                in_Url,in_DatabaseName,
                in_DatabasePort);
        setDatabaseTable(in_Table);
        setDatabaseValues(in_Values);
    }

    public void setDatabaseValues(final String in_Values) {
        if (!in_Values.isEmpty()) {
            databaseValues = in_Values;
        }
    }

    public String getDatabaseValues() {
        return databaseValues;
    }

    public void setDatabaseTable(final String in_table) {
        if (!in_table.isEmpty()) {
            databaseTable = in_table;
        }
    }

    public String getDatabaseTable() {
        return databaseTable;
    }

    @Override
    public int addObject(Person object) {
        PersonalData objectPersonalData = object.getPersonalData();
        String insert_query = "INSERT INTO " + getDatabaseTable() + " ";
        insert_query += "(" + getDatabaseValues() + ") ";
        insert_query += "values( " + object.getFirstName()
                + "," + object.getLastName()
                + "," + object.getAge()
                + "," + objectPersonalData.getTelephone(PersonalData.CELLPHONE_NUMBER)
                + "," + objectPersonalData.getTelephone(PersonalData.HOME_NUMBER)
                + "," + objectPersonalData.getEmailAddress() + ";";
        DatabaseConnectionManager connManager = getConnectionManager();
        Connection con = connManager.getConnection();
        int result = -1;
        try {
            Statement sql_statement = con.createStatement();
            result = sql_statement.executeUpdate(insert_query);
        } catch (SQLException ex) {
            Logger.getLogger(PersonAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        connManager.closeConnection();
        return result;
    }

    @Override
    public int editObject(Person object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResultSet selectObject(String sqlStatement) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int deleteObject(Person object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
