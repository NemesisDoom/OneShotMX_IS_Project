/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.person;

/**
 *
 * @author Miguel
 */
public final class Person {
    private String firstName;
    private String lastName;
    private int age;
    private ContactInformation contactInfo;
    
    public Person(){
        setFirstName("");
        setLastName("");
        setAge(0);
    }
    
    public Person(String in_Name, String in_lastname, int in_Age){
        setFirstName(in_Name);
        setLastName(in_lastname);
        setAge(in_Age);
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
    
    public void setAge(final int in_Age){
        if(in_Age > 0){
            age = in_Age;
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
        personString += "Age: "+getAge()+"\n";
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

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }
    
    public static void main(String args[]){
        Person person = new Person();
        Person person2 = new Person("Miguel","Chan",21);
        System.out.println(person);
        System.out.println(person2);
    }
}
