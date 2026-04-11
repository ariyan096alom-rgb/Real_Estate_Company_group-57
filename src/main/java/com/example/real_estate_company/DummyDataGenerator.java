package com.example.real_estate_company;

import com.example.real_estate_company.KaziTahmidAbtahi.Client.Property;
<<<<<<< HEAD
import com.example.real_estate_company.mahhi.*;
=======
import com.example.real_estate_company.KaziTahmidAbtahi.FinanceOfficer.FinanceOfficer; // Importing the new model!
>>>>>>> 2ac478c33a71ad8835db5eeb1a29b32355017c94

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DummyDataGenerator {
    public static void main(String[] args) {

        System.out.println("--- Starting Dummy Data Generation ---");

        // =========================================================
        // 1. GENERATE FINANCE OFFICER LOGIN CREDENTIALS
        // =========================================================
        String userFileName = "FinanceOfficerData.bin";

        File userFile = new File(userFileName);
        if (userFile.exists()) {
            userFile.delete();
        }

        try {
            // Creating the actual Finance Officer object!
            FinanceOfficer demoFinanceOfficer = new FinanceOfficer(1001, "Tahmid", "12345678", "tahmid@gmail.com");

            // Saving it to the binary file
            Helper.writeInto(userFileName, demoFinanceOfficer);

            System.out.println("Success! Demo Finance Officer created.");
            System.out.println("Login ID: 1001 | Password: 1234");
        } catch (Exception e) {
            System.out.println("Error generating Finance Officer data: " + e.getMessage());
        }

        // =========================================================
        // 2. GENERATE DASHBOARD DATA (PIE CHART & AMOUNTS)
        // =========================================================
        String propertyFileName = "PropertyData.bin";

        File propertyFile = new File(propertyFileName);
        if (propertyFile.exists()) {
            propertyFile.delete();
        }

        try {
            // "Pending" Properties -> Adds to Pending Amount & Pending Slices in PieChart
            Helper.writeInto(propertyFileName, new Property(101, "Sunset Villa", "Gulshan", 150000.0, 2500, 4, "House", "Pending"));
            Helper.writeInto(propertyFileName, new Property(102, "Ocean View", "Banani", 85000.0, 1200, 3, "Apartment", "Pending"));
            Helper.writeInto(propertyFileName, new Property(103, "City Center Tower", "Dhanmondi", 200000.0, 5000, 0, "Commercial", "Pending"));

            // "Approved" Properties -> Adds to Approved Slices in PieChart
            Helper.writeInto(propertyFileName, new Property(104, "Green Plaza", "Uttara", 50000.0, 1000, 2, "Apartment", "Approved"));
            Helper.writeInto(propertyFileName, new Property(105, "Luxury Condo", "Bashundhara", 120000.0, 1800, 3, "Apartment", "Approved"));
            Helper.writeInto(propertyFileName, new Property(106, "Lakehouse", "Gulshan", 300000.0, 4000, 5, "House", "Approved"));
            Helper.writeInto(propertyFileName, new Property(107, "Mirpur Heights", "Mirpur", 45000.0, 900, 2, "Apartment", "Approved"));

            // "Available" Properties -> Ignored by Dashboard, but good to have for testing!
            Helper.writeInto(propertyFileName, new Property(108, "Downtown Studio", "Motijheel", 25000.0, 600, 1, "Apartment", "Available"));

            System.out.println("Success! Sample properties (Pending & Approved) have been saved to " + propertyFileName);

        } catch (IOException e) {
            System.out.println("Error generating Property data: " + e.getMessage());
        }
<<<<<<< HEAD

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
    }
=======
>>>>>>> 2ac478c33a71ad8835db5eeb1a29b32355017c94

        System.out.println("--- Generation Complete ---");
    }
}