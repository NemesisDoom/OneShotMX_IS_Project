/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.person.ContactInformation;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Miguel
 */
public class ContactInformationAccessObject extends DataAccessObject<ContactInformation>{
    
    public ContactInformationAccessObject(String in_databaseTable){
        super(in_databaseTable);
    }
    
    @Override
    public int insertObject(ContactInformation object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int updateObject(ContactInformation prevObject,ContactInformation newObject) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public int deleteObject(ContactInformation object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<ContactInformation> selectDataFromDatabase(String[] tableValues) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
