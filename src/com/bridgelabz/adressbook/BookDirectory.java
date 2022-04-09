package com.bridgelabz.adressbook;

import java.util.*;

public class BookDirectory {

    static Scanner sc = new Scanner(System.in);
    Map<String, AddressBook> mainAddressBook =  new Hashtable<>();

    void dirNavigator() {
        boolean toggle = true;
        while (toggle) {
            System.out.println("""
                    MAIN ADDRESS BOOK
                    
                    1 -> Create New Book
                    2 -> Display Book
                    3 -> Open A book
                    4 -> Search People by City
                    5 -> Search People by State
                    0 -> Exit
                    """);
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            System.out.println("============================= \n");
            switch (choice) {
                case 1 -> {
                    System.out.println("What do you want to call this book? (Space Character not supported):");
                    String name = sc.next();
                    newBook(name);
                    System.out.println("============================= \n");
                }
                case 2 -> {
                    displayBooks();
                    System.out.println("============================= \n");
                }
                case 3 -> {
                    System.out.println("Enter the Book Name to be opened: ");
                    String bookName = sc.next();
                    System.out.println("============================= \n");
                    openBook(bookName).bookNavigator();
                }
                case 4 -> {
                    System.out.println("Enter City: ");
                    String city = sc.next();
                    filterCity(city);
                }
                case 5 -> {
                    System.out.println("Enter State: ");
                    String state = sc.next();
                    filterState(state);
                }
                case 0 -> {
                    System.out.println("Main Book Closed.");
                    toggle = false;
                }
                default -> {
                    System.out.println("Enter Correct choice.");
                    System.out.println("============================= \n");
                }
            }
        }
    }

    void filterCity(String city){
        for(Map.Entry<String, AddressBook> entry : mainAddressBook.entrySet()){
            List<Contact> citizens = entry.getValue().getEntry().stream()
                    .filter(person -> person.getCity().equals(city))
                    .toList();
            citizens.forEach(person -> System.out.println(person.getFirstName() + " " + person.getLastName()));
        }
        System.out.println("\n");
    }

    void filterState(String state){
        for(Map.Entry<String, AddressBook> entry : mainAddressBook.entrySet()){
            List<Contact> citizens = entry.getValue().getEntry().stream()
                    .filter(person -> person.getState().equals(state))
                    .toList();
            citizens.forEach(person -> System.out.println(person.getFirstName() + " " + person.getLastName()));
        }
        System.out.println("\n");
    }

    void newBook(String name){
        mainAddressBook.put(name, new AddressBook(name));
        System.out.println("Created book named " + name);
    }

    void displayBooks(){
        System.out.println(mainAddressBook.toString());
    }

    AddressBook openBook(String name){
        return mainAddressBook.get(name);
    }

//    private Map<String, AddressBook> getMainAddressBook() {
//        return mainAddressBook;
//    }

    //Temporary Method
    void addAddressBook(AddressBook ab){
        mainAddressBook.put(ab.bookName, new AddressBook(ab.bookName));
    }
}
