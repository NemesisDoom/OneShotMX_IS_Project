/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.person.ContactInformation;
import com.person.Person;
import java.util.Date;

/**
 *
 * @author Miguel
 */
public class PersonManagementController {
    
    public ContactInformation createContactInformation(String homeAddress,String emailAddress,
            String homeNumber,String cellphoneNumber,String extraCellphone,String extraHomePhone){
        
        ContactInformation personContactInformation = new ContactInformation();
        personContactInformation.setEmailAddress(emailAddress);
        personContactInformation.setHomeAddress(homeAddress);
        
        personContactInformation.addTelephoneNumber(ContactInformation.CELLPHONE_NUMBER, cellphoneNumber);
        personContactInformation.addTelephoneNumber(ContactInformation.HOME_PHONE_NUMBER,homeNumber);
        personContactInformation.addTelephoneNumber(ContactInformation.ADDITIONAL_CELLPHONE_NUMBER,extraCellphone);
        personContactInformation.addTelephoneNumber(ContactInformation.ADDITIONAL_HOME_NUMBER,extraHomePhone);
        
        return personContactInformation;
    }
    
    public Person createPerson(String inFirstName,String inLastName,ContactInformation contactInfo,Date registryDate){
        Person newPerson = new Person();
        
        newPerson.setFirstName(inFirstName);
        newPerson.setLastName(inLastName);
        newPerson.setContactInformation(contactInfo);
        newPerson.setRegistrationDate(registryDate);
        
        return newPerson;
    }
}
