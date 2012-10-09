/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.visual;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miguel
 */
public class PersonTableModel extends DefaultTableModel{
    
    @Override
    public boolean isCellEditable(int row,int mColumnIndex){
        return false;
    }
}
