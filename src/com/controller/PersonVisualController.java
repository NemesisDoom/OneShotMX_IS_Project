/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.person.Person;
import com.visual.PersonManagement;
import com.visual.PersonTableModel;
import java.text.DateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Miguel
 */
public class PersonVisualController {
    private final static String FIRSTNAME_COLUMN = "First name";
    private final static String LASTNAME_COLUMN = "Last name";
    private final static String REGISTRY_DATE_COLUMN = "Register Date";
    private final static String ID_COLUMN = "Person ID";
    
    private JTable personTable;
    
    public PersonVisualController(JTable prsnTable){
        personTable = prsnTable;
        initializePersonTable(personTable);
    }
    
    public final void initializePersonTable(JTable inoutPersonTable){
        PersonTableModel tableModel = new PersonTableModel();
        tableModel.addColumn(ID_COLUMN);
        tableModel.addColumn(FIRSTNAME_COLUMN);
        tableModel.addColumn(LASTNAME_COLUMN);
        tableModel.addColumn(REGISTRY_DATE_COLUMN);
        
        personTable.setModel(tableModel);
    }
    
    private String getRegisterDateString(Date inRegisterDate){
        DateFormat dateFormatter = DateFormat.getDateInstance();
        String registerDate = dateFormatter.format(inRegisterDate);
        return registerDate;
    }
    
    public void addPersonToTable(Person inPerson){
        PersonTableModel tableModel = (PersonTableModel)personTable.getModel();
        
        String prsnFirstName = inPerson.getFirstName();
        String prsnLastName = inPerson.getLastName();
        String registryDate = getRegisterDateString(inPerson.getRegistrationDate());
        
        Vector<String> rowData = new Vector<String>();
        rowData.add("ID");
        rowData.add(prsnFirstName);
        rowData.add(prsnLastName);
        rowData.add(registryDate);
        
        tableModel.addRow(rowData);
        personTable.setModel(tableModel);
    }
    
    public void deletePerson(PersonManagement prsnManagementForm){
        int selectedRow = personTable.getSelectedRow();
        if(selectedRow >= 0){
            int confirmResponse = -1;
            confirmResponse = JOptionPane.showConfirmDialog(
                    prsnManagementForm,
                    "¿Desea eliminar a la persona seleccionada?",
                    "Deleting a Person", 
                    JOptionPane.OK_CANCEL_OPTION
                    );
            if(confirmResponse == JOptionPane.OK_OPTION){
                deletePersonFromTable(selectedRow);
            }
        }
    }
    
    private void deletePersonFromTable(int inSelectedIndex){
        PersonTableModel tableModel = (PersonTableModel)personTable.getModel();
        tableModel.removeRow(inSelectedIndex);
    }
}
