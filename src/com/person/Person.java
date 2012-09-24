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
    private PersonalData personalData;
    
    public Person(){
        setFirstName("");
        setLastName("");
        setAge(0);
    }
    
    public Person(final String in_Name,
            final String in_lastname,
            final int in_Age,
            final String in_EmailAddress,
            final String in_Address){
        setFirstName(in_Name);
        setLastName(in_lastname);
        setAge(in_Age);
        personalData = new PersonalData(in_Address,in_EmailAddress);
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
    
    public String getName(){
        return getFirstName() + " " + getLastName();
    }
    
    public PersonalData getPersonalData(){
        return personalData;
    }
    
    @Override
    public String toString(){
        PersonalData actualPersonalData = getPersonalData();
        String personString = "";
        personString = "Name: "+getName()+"\n";
        personString += "Age: "+getAge()+"\n";
        personString += "Cellphone: "+ actualPersonalData.getTelephone(PersonalData.CELLPHONE_NUMBER) + "\n";
        personString += "Telephone: "+ actualPersonalData.getTelephone(PersonalData.HOME_NUMBER) + "\n";
        personString += "Email Address: "+ actualPersonalData.getEmailAddress() + "\n";
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
        Person person2 = new Person("Miguel","Chan",21,"","");
        System.out.println(person);
        System.out.println(person2);
    }
}
