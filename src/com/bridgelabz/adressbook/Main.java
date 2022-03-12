package com.bridgelabz.adressbook;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("-----Welcome to Address Book Program----- \n");
        AddressBook book = new AddressBook();
        boolean toggle = true;
        while (toggle) {
            System.out.println("""
                    1 -> Create Contact
                    2 -> Display Contacts
                    3 -> Edit Contact
                    4 -> Delete Contact
                    0 -> Exit
                    """);
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            System.out.println("============================= \n");
            switch (choice) {
                case 1 -> {
                    book.setContact();
                    System.out.println("============================= \n");
                }
                case 2 -> {
                    book.getContact();
                    System.out.println("============================= \n");
                }
                case 3 -> {
                    book.editContact();
                    System.out.println("============================= \n");
                }
                case 4 -> {
                    book.deleteContact();
                    System.out.println("============================= \n");
                }
                case 0 -> {
                    System.out.println("Address Book Closed.");
                    toggle = false;
                }
                default -> System.out.println("Enter Correct choice.");
            }
        }
    }
}
