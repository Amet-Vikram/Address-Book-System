package com.bridgelabz.adressbook;

public class Main {

    public static void main(String[] args) {

        //Navigate to select a book -> Open that book ->

        System.out.println("-----Welcome to Address Book Program----- \n");

        BookDirectory addressBookMain = new BookDirectory();
        addressBookMain.dirNavigator();
    }

}
