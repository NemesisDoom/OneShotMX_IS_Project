/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persona;

/**
 *
 * @author Miguel
 */
public final class Persona {
    private String firstName;
    private String lastName;
    private int age;
    private String telephone;
    private String cellphone;
    private String emailAddress;
    
    public Persona(){
        firstName = "";
        lastName = "";
        age = 0;
        telephone = "";
        cellphone = "";
        emailAddress = "";
    }
    
    public Persona(final String in_Name,final String in_lastname,final int in_Age,
            final String in_telephone,final String in_Cellphone,final String in_EmailAddress){
        setFirstName(in_Name);
        setLastName(in_lastname);
        setAge(in_Age);
        setTelephone(in_telephone);
        setCellphone(in_Cellphone);
        setEmailAddress(in_EmailAddress);
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
    
    public void setEmailAddress(final String in_eMailAddress){
        emailAddress = in_eMailAddress;
    }
    
    public void setTelephone(final String in_telephone){
        telephone = in_telephone;
    }
    
    public void setCellphone(final String in_cellphone){
        cellphone = in_cellphone;
    }
    
    public String getName(){
        return getFirstName() + " " + getLastName();
    }
    public String toString(){
        String personString = "";
        personString = "Name: "+getName()+"\n";
        personString += "Age: "+getAge()+"\n";
        personString += "Cellphone: "+getCellphone() + "\n";
        personString += "Telephone: "+getTelephone() + "\n";
        personString += "Email Address: "+getEmailAddress() + "\n";
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

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @return the cellphone
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }
    
    public static void main(String args[]){
        Persona person = new Persona();
        Persona person2 = new Persona("Miguel","Chan",21,"9469941",
                "9991260587","nemesis_658@hotmail.com");
        System.out.println(person);
        System.out.println(person2);
    }
}
