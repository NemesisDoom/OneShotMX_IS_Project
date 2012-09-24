/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.person;

import java.util.Hashtable;

/**
 *
 * @author Miguel
 */
public final class PersonalData {
    public static final String HOME_NUMBER = "Home Number";
    public static final String WORK_NUMBER = "Work Number";
    public static final String CELLPHONE_NUMBER = "Cellphone Number";
    public static final String CELLPHONE_NUMBER_2 = "Cellphone Number 2";
    public static final String HOME_NUMBER_2 = "Home Number 2";
    public static final int TOTAL_PHONE_NUMBERS = 5;
    
    private String address;
    private String emailAddress;
    private Hashtable<String,String> telephones;
    
    public PersonalData(){
        setAddress("");
        setEmailAddress("");
        initializeTelephoneTable();
    }
    
    private void initializeTelephoneTable(){
        telephones = new Hashtable<String,String>();
        telephones.put(PersonalData.CELLPHONE_NUMBER, "");
        telephones.put(PersonalData.CELLPHONE_NUMBER_2,"");
        telephones.put(PersonalData.HOME_NUMBER,"");
        telephones.put(PersonalData.HOME_NUMBER_2,"");
        telephones.put(PersonalData.WORK_NUMBER,"");
    }
    
    public PersonalData(String in_Address,String in_EmailAddress){
        setAddress(in_Address);
        setEmailAddress(in_EmailAddress);
    }
    
    public void addTelephone(String in_telephoneNumber,String in_telephoneKeyValue){
        telephones.put(in_telephoneKeyValue, in_telephoneNumber);
    }
    
    public void setAddress(String in_Address){
        if(!in_Address.isEmpty()){
            address = in_Address;
        }
    }
    
    public void setEmailAddress(String in_emailAddress){
        if(!in_emailAddress.isEmpty()){
            emailAddress = in_emailAddress;
        }
    }
    
    public String getAddress(){
        return address;
    }
    
    public String getEmailAddress(){
        return emailAddress;
    }
    
    public String getTelephone(String in_telephoneKey){
        String telephoneNumber = "";
        if(!in_telephoneKey.isEmpty()){
            telephoneNumber = telephones.get(in_telephoneKey);
        }
        return telephoneNumber;
    }
}
