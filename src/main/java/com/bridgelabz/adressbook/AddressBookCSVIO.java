package com.bridgelabz.adressbook;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class AddressBookCSVIO {
    public static String CONTACT_READ_CSV = "src/main/resources/ContactRead.csv";
    public static String CONTACT_WRITE_CSV = "src/main/resources/ContactWrite.csv";


    public void writeData(ArrayList<Contact> entries) throws IOException,
            CsvDataTypeMismatchException, CsvRequiredFieldEmptyException{
        try(
                Writer writer = Files.newBufferedWriter(Paths.get(CONTACT_WRITE_CSV))
        ){
            StatefulBeanToCsv<Contact> beanToCsv = new StatefulBeanToCsvBuilder(writer).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            ArrayList<Contact> newEntries = new ArrayList<>(entries);
            beanToCsv.write(newEntries);
        }
    }

    public ArrayList<Contact> readData() throws IOException{
        ArrayList<Contact> entries = new ArrayList<>();
        try(
                Reader reader = Files.newBufferedReader(Paths.get(CONTACT_READ_CSV))
        ){
            CsvToBean<Contact> csvToBean = new CsvToBeanBuilder(reader).withType(Contact.class).withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<Contact> contactIterator = csvToBean.iterator();

            while (contactIterator.hasNext()){
                Contact person = contactIterator.next();
                entries.add(person);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return entries;
    }
}
