/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

import com.dao.DatabaseAcceser;
import com.visual.PersonManagement;

/**
 *
 * @author Miguel
 */
public class ProgramLoader {
    public static void main(String args[]){
        DatabaseAcceser acceser = DatabaseAcceser.getInstance();
        acceser.loadDatabaseConfiguration();
        acceser.testConnection();
        new PersonManagement().setVisible(true);
    }
}
