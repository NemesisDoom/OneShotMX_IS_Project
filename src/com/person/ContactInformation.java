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
public final class ContactInformation {
    public static final String HOME_PHONE_NUMBER = "Home Number";
    public static final String WORK_PHONE_NUMBER = "Work Number";
    public static final String CELLPHONE_NUMBER = "Cellphone Number";
    public static final String ADDITIONAL_CELLPHONE_NUMBER = "Additional Cellphone Number";
    public static final String ADDITIONAL_HOME_NUMBER = "Additional Home Number";
    
    private String homeAddress;
    private String homeCity;
    private int zipcode;
    private String emailAddress;
    private Hashtable<String,String> telephoneNumbers;
    
    public ContactInformation(){
        setHomeAddress("");
        setHomeCity("");
        setZipCode(0);
        setEmailAddress("");
        initializePhonebook();
    }
    
    private void initializePhonebook(){
        telephoneNumbers = new Hashtable<String,String>();
        telephoneNumbers.put(ContactInformation.HOME_PHONE_NUMBER, "");
        telephoneNumbers.put(ContactInformation.ADDITIONAL_HOME_NUMBER, "");
        telephoneNumbers.put(ContactInformation.WORK_PHONE_NUMBER, "");
        telephoneNumbers.put(ContactInformation.CELLPHONE_NUMBER, "");
        telephoneNumbers.put(ContactInformation.ADDITIONAL_CELLPHONE_NUMBER, "");
    }
    
    public void setHomeAddress(String inHomeAddress){
        if(!inHomeAddress.isEmpty()){
            homeAddress = inHomeAddress;
        }
    }
    
    public void setHomeCity(String inHomeCity){
        if(!inHomeCity.isEmpty()){
            homeCity = inHomeCity;
        }
    }
    
    public void setZipCode(int inZipCode){
        if(inZipCode > 0){
            zipcode = inZipCode;
        }
    }
    
    public void setEmailAddress(String inEmailAddress){
        if(!inEmailAddress.isEmpty()){
            emailAddress = inEmailAddress;
        }
    }
    
    public String getHomeAddress(){
        return homeAddress;
    }
    
    public int getZipCode(){
        return zipcode;
    }
    
    public String getHomeCity(){
        return homeCity;
    }
    
    public String getEmailAddress(){
        return emailAddress;
    }
    
    public String getTelephoneNumber(String inTelephoneNumberKey){
        String telephoneNumber = "";
        if(telephoneNumbers.containsKey(inTelephoneNumberKey)){
            telephoneNumber = telephoneNumbers.get(inTelephoneNumberKey);
        }
        return telephoneNumber;
    }
}
