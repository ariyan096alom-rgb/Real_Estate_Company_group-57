package com.example.real_estate_company;

import com.example.real_estate_company.KaziTahmidAbtahi.Client.Property;
<<<<<<< HEAD
import com.example.real_estate_company.KaziTahmidAbtahi.FinanceOfficer.FinanceOfficer;

import java.io.File;
=======
import com.example.real_estate_company.mahhi.*;
import com.example.real_estate_company.KaziTahmidAbtahi.FinanceOfficer.FinanceOfficer; // Importing the new model!

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
>>>>>>> 2ece45b2a45e4016886beb4162e4edbab72789fe

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
<<<<<<< HEAD
=======

        String companyFileName = "CompanyData.bin";
        File compFile = new File(companyFileName);
        if (compFile.exists()) {
            compFile.delete();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(companyFileName))) {

            // Here we use the CompanyData class you just created!
            CompanyData compData = new CompanyData("12 Active", "45 Available, 20 Sold", "150", "Profitable");
            oos.writeObject(compData);

            System.out.println("Success! Sample CompanyData has been saved to " + companyFileName);

        } catch (Exception e) {
            System.out.println("Error generating Company data: " + e.getMessage());
        }


        String attendanceFile = "AttendanceData.bin";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(attendanceFile))) {
            oos.writeObject(new AttendanceRecord("John Doe", "2023-10-01", "Present"));
            oos.writeObject(new AttendanceRecord("Jane Smith", "2023-10-01", "Absent"));
            oos.writeObject(new AttendanceRecord("Bob Wilson", "2023-10-01", "Present"));
            oos.writeObject(new AttendanceRecord("John Doe", "2023-10-02", "Present"));

            System.out.println("Success! AttendanceData.bin created.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("FinancialData.bin"))) {
            oos.writeObject(new FinancialData(500000.0, 320000.0)); // 500k income, 320k expense
            System.out.println("Success! FinancialData.bin created.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SalaryData.bin"))) {
            oos.writeObject(new SalaryData(75000.0, 5000.0));
            System.out.println("Success! SalaryData.bin created.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ProjectData.bin"))) {
            oos.writeObject(new ProjectData("East-West Plaza", "Dec 2026", 0.75));
            oos.writeObject(new ProjectData("Green Valley", "June 2027", 0.40));
            oos.writeObject(new ProjectData("Skyline Tower", "Jan 2026", 0.95));
            System.out.println("Success! ProjectData.bin created.");
        } catch (Exception e) { e.printStackTrace(); }

        System.out.println("--- Generation Complete ---");
>>>>>>> 2ece45b2a45e4016886beb4162e4edbab72789fe
    }
}