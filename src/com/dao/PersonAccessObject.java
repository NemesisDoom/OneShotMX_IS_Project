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
public class PersonAccessObject extends DataAccessObject{

    public PersonAccessObject(String in_UserName,
            String in_DatabasePassword,
            String in_Url,
            String in_DatabaseName,
            int in_DatabasePort){
        super(in_UserName,in_DatabasePassword,in_Url,in_DatabaseName,in_DatabasePort);
    }
    
    @Override
    public int createObject(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int updateObject(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResultSet readObject(String sqlStatement) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int deleteObject(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
