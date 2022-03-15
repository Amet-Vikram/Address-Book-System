package com.bridgelabz.adressbook;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class AddressBook{
    String bookName;
    int index = 0;
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Contact> entry = new ArrayList<>();

    AddressBook(String name){
        this.bookName = name;
    }

    void setContact(){
        Contact person = new Contact(index);
        System.out.println("Enter First Name: ");
        person.setFirstName(sc.nextLine());
        System.out.println("Enter Last Name: ");
        person.setLastName(sc.nextLine());
        System.out.println("Enter Address: ");
        person.setAddress(sc.nextLine());
        System.out.println("Enter City: ");
        person.setCity(sc.nextLine());
        System.out.println("Enter State: ");
        person.setState(sc.nextLine());
        System.out.println("Enter Zip Code: ");
        person.setZip(sc.nextLine());
        System.out.println("Enter Phone Number: ");
        person.setPhoneNumber(sc.nextLine());
        System.out.println("Enter E-Mail: ");
        person.seteMail(sc.nextLine());
        System.out.println("\n");
        entry.add(person);
        index ++;
    }

    void editContact(){
        System.out.println("Enter the contact's First Name to be edited: ");
        String firstName = sc.nextLine();
        boolean check = true;
        for (Contact person : entry){
            if(Objects.equals(person.getFirstName(), firstName)){
                System.out.println("Enter First Name: ");
                person.setFirstName(sc.nextLine());
                System.out.println("Enter Last Name: ");
                person.setLastName(sc.nextLine());
                System.out.println("Enter Address: ");
                person.setAddress(sc.nextLine());
                System.out.println("Enter City: ");
                person.setCity(sc.nextLine());
                System.out.println("Enter State: ");
                person.setState(sc.nextLine());
                System.out.println("Enter Zip Code: ");
                person.setZip(sc.nextLine());
                System.out.println("Enter Phone Number: ");
                person.setPhoneNumber(sc.nextLine());
                System.out.println("Enter E-Mail: ");
                person.seteMail(sc.nextLine());
                System.out.println("\n");
                entry.set(entry.indexOf(person), person);
                System.out.println("Contact has been updated!");
                check = false;
                break;
            }
        }
        if(check){
            System.out.println("The Contact doesn't Exist.");
        }
    }

    void getContact(){
        for (Contact e: entry) {
            System.out.println("ID: " + e.id);
            System.out.println("First Name: " + e.firstName);
            System.out.println("Last Name: " + e.lastName);
            System.out.println("Address: " + e.address);
            System.out.println("City: " + e.city);
            System.out.println("State: " + e.state);
            System.out.println("Zip: " + e.zip);
            System.out.println("Phone Number: " + e.phoneNumber);
            System.out.println("E-Mail: " + e.eMail + "\n");
        }
    }

    void deleteContact(){
        System.out.println("Enter contact's  first name to be deleted: ");
        String name = sc.nextLine();
        boolean check = true;
        for (Contact person : entry) {
            if (Objects.equals(person.getFirstName(), name)) {
                entry.remove(person);
                System.out.println("Entry Removed! \n");
                check = false;
                break;
            }
        }
        if (check){
            System.out.println("No Such Entry Exists.");
        }
    }
    void bookNavigator() {
        boolean toggle = true;
        while (toggle) {
            System.out.println("Current Book: " + this.bookName + "\n");
            System.out.println("""
                    1 -> Create Contact
                    2 -> Display Contacts
                    3 -> Edit Contact
                    4 -> Delete Contact
                    0 -> Exit to Main Address Book
                    """);
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            System.out.println("============================= \n");
            switch (choice) {
                case 1 -> {
                    setContact();
                    System.out.println("============================= \n");
                }
                case 2 -> {
                    getContact();
                    System.out.println("============================= \n");
                }
                case 3 -> {
                    editContact();
                    System.out.println("============================= \n");
                }
                case 4 -> {
                    deleteContact();
                    System.out.println("============================= \n");
                }
                case 0 -> {
                    System.out.println("Address Book Closed. \n");
                    toggle = false;
                }
                default -> {
                    System.out.println("Enter Correct choice.");
                    System.out.println("============================= \n");
                }
            }
        }
    }
}

