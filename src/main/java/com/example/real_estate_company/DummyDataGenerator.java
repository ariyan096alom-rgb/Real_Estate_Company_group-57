package com.example.real_estate_company;

import com.example.real_estate_company.KaziTahmidAbtahi.Client.Property;
import com.example.real_estate_company.KaziTahmidAbtahi.FinanceOfficer.FinanceOfficer;

import java.io.File;

public class DummyDataGenerator {

    public static void main(String[] args) {


        File officerFile = new File("FinanceOfficerData.bin");
        if (officerFile.exists()) {
            officerFile.delete();
        }

        try {
            FinanceOfficer officer = new FinanceOfficer(1, "Tahmid", "tahmid@gmail.com", "12345678");
            Helper.writeInto("FinanceOfficerData.bin", officer);
        } catch (Exception e) {
            System.out.println("Error saving Finance Officer");

        }

        File propertyFile = new File("PropertyData.bin");
        if (propertyFile.exists()) {
            propertyFile.delete();
        }

        try {
            Helper.writeInto("PropertyData.bin", new Property(1, "a", "Gulshan", 1000000.0, 100, 1, "House", "Pending"));
            Helper.writeInto("PropertyData.bin", new Property(2, "b", "Banani", 200000.0, 2000, 2, "Apartment", "Available"));
            Helper.writeInto("PropertyData.bin", new Property(3, "c", "Dhanmondi", 30000000.0, 3000, 3, "Commercial", "Pending"));
            Helper.writeInto("PropertyData.bin", new Property(4, "d", "Uttara", 4000000.0, 4000, 4, "Apartment", "Available"));
            Helper.writeInto("PropertyData.bin", new Property(5, "e", "Bashundhara", 5000000.0, 5000, 5, "Apartment", "Available"));
            Helper.writeInto("PropertyData.bin", new Property(6, "f", "Gulshan", 60000000.0, 6000, 6, "House", "Approved"));
            Helper.writeInto("PropertyData.bin", new Property(7, "g", "Mirpur", 7000000.0, 7000, 7, "Apartment", "Approved"));
            Helper.writeInto("PropertyData.bin",new Property(8, "h", "Motijheel", 8000000.0, 8000, 8, "Apartment", "Available"));

        } catch (Exception e) {
            System.out.println("Error saving Properties");


        }
    }
}