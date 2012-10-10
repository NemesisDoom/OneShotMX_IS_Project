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
    private String emailAddress;
    private Hashtable<String,String> telephoneNumbers;
    
    public ContactInformation(){
        setHomeAddress("");
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
        if(inHomeAddres != null){
            homeAddress = inHomeAddress;
        }
    }

    public void setEmailAddress(String inEmailAddress){
        if(inEmailAddress != null){
            emailAddress = inEmailAddress;
        }
    }
    
    public String getHomeAddress(){
        return homeAddress;
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
    
    public void addTelephoneNumber(String inTelephoneNumberKey,String inTelephoneNumberValue){
        telephoneNumbers.put(inTelephoneNumberKey, inTelephoneNumberValue);
    }
}
