package com.bridgelabz.adressbook;

public class Contact {
    int id;
    String address;
    String firstName;
    String lastName;
    String city;
    String state;
    String zip;
    String phoneNumber;
    String eMail;

    public String getCity() {
        return city;
    }

    public Contact(int id, String address, String firstName, String lastName, String city, String state, String zip, String phoneNumber, String eMail) {
        this.id = id;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
    }

    public String getState() {
        return state;
    }

    Contact(int index){
        this.id = index;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address ='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
