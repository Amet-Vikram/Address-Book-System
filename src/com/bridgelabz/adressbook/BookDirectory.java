package com.bridgelabz.adressbook;

import java.util.*;
import java.util.stream.Collectors;

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
                    4 -> Search People
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
                    int option = searchMenu();
                    handleSearchChoice(option);
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

    int searchMenu(){
        System.out.println("""
                Filter people by:
                1 -> City
                2 -> State
                """);
        System.out.print("Choice: ");
        return sc.nextInt();
    }

    void handleSearchChoice(int choice){
        switch (choice){
            case 1 -> {
                System.out.println("\n Enter city: ");
                String city = sc.next();
                List<Contact> citizens = filterCity(city);
                System.out.println("\n ========Found "+ citizens.size() + " people in" + city + "========");
                citizens.forEach(person -> System.out.println(person.getFirstName() + " " + person.getLastName()));
                System.out.println("============================= \n");
            }
            case 2 -> {
                System.out.println("Enter state: ");
                String state = sc.next();
                List<Contact> citizens = filterState(state);
                System.out.println("\n ========Found "+ citizens.size() + " people in" + state + "========");
                citizens.forEach(person -> System.out.println(person.getFirstName() + " " + person.getLastName()));
                System.out.println("============================= \n");
            }
        }
    }

    List<Contact> filterCity(String city) {
        List<Contact> citizens = new ArrayList<>();

        for (Map.Entry<String, AddressBook> books : mainAddressBook.entrySet()) {
            List<Contact> entryContact = books.getValue().entry;
            List<Contact> filteredContacts = entryContact.stream()
                    .filter(person -> person.getCity().equals(city))
                    .toList();

            citizens.addAll(filteredContacts);
        }
        return citizens;
    }

    List<Contact> filterState(String state) {
        List<Contact> citizens = new ArrayList<>();

        for (Map.Entry<String, AddressBook> books : mainAddressBook.entrySet()) {
            List<Contact> entryContact = books.getValue().entry;
            List<Contact> filteredContacts = entryContact.stream()
                    .filter(person -> person.getState().equals(state))
                    .toList();

            citizens.addAll(filteredContacts);
        }
        return citizens;
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

    //Temporary Method
    void addAddressBook(AddressBook ab){
        mainAddressBook.put(ab.bookName, new AddressBook(ab.bookName));
    }

    @Override
    public String toString() {
        return "BookDirectory{" +
                "mainAddressBook=" + mainAddressBook + "\n" +
                '}';
    }

}
