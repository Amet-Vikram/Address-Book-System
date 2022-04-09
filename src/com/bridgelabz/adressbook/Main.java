package com.bridgelabz.adressbook;

import java.util.ArrayList;

public class Main {

        static BookDirectory addContacts(){
        BookDirectory bd = new BookDirectory();
        AddressBook ab1 = new AddressBook("Book1");
        AddressBook ab2 = new AddressBook("Book2");
        bd.addAddressBook(ab1);
        bd.addAddressBook(ab2);
        return bd;
    }

    public static void main(String[] args) {

        System.out.println("-----Welcome to Address Book Program----- \n");
        BookDirectory addressBookMain = addContacts();
//        BookDirectory addressBookMain = new BookDirectory();
        addressBookMain.dirNavigator();
    }
}
