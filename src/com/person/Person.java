/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.person;

import java.util.Date;

/**
 *
 * @author Miguel
 */
public final class Person {
    private String firstName;
    private String lastName;
    private ContactInformation contactInfo;
    private Date registrationDate;
    
    public Person(){
        setFirstName("");
        setLastName("");
    }
    
    public Person(String in_Name, String in_lastname, int in_Age,Date rgstrtnDate){
        setFirstName(in_Name);
        setLastName(in_lastname);
        setRegistrationDate(rgstrtnDate);
        contactInfo = new ContactInformation();
    }
    
    public void setFirstName(final String in_FirstName){
        if(!in_FirstName.isEmpty()){
            firstName = in_FirstName;
        }
    }
    
    public void setLastName(final String in_LastName){
        if(!in_LastName.isEmpty()){
            lastName = in_LastName;
        }
    }
    
    public void setContactInformation(ContactInformation inCntctInfo){
        if(inCntctInfo != null){
            contactInfo = inCntctInfo;
        }
    }
    
    public String getName(){
        return getFirstName() + " " + getLastName();
    }
    
    public ContactInformation getContactInformation(){
        return contactInfo;
    }
    
    @Override
    public String toString(){
        ContactInformation cntctInfo = getContactInformation();
        String personString = "";
        personString = "Name: "+getName()+"\n";
        personString += "Cellphone: "+ cntctInfo.getTelephoneNumber(ContactInformation.CELLPHONE_NUMBER) + "\n";
        personString += "Telephone: "+ cntctInfo.getTelephoneNumber(ContactInformation.HOME_PHONE_NUMBER) + "\n";
        personString += "Email Address: "+ cntctInfo.getEmailAddress() + "\n";
        return personString;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }
    
    public void setRegistrationDate(Date rgstrtnDate){
        if(rgstrtnDate != null){
            registrationDate = rgstrtnDate;
        }
    }
    
    public Date getRegistrationDate(){
        return registrationDate;
    }
}
