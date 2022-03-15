package com.bridgelabz.adressbook;

import java.util.*;

public class BookDirectory {

    static Scanner sc = new Scanner(System.in);

    Dictionary<String, AddressBook> mainAddressBook =  new Hashtable<>();

    void dirNavigator() {
        boolean toggle = true;
        while (toggle) {
            System.out.println("""
                    MAIN ADDRESS BOOK
                    
                    1 -> Create New Book
                    2 -> Display Book
                    3 -> Open A book
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
}
