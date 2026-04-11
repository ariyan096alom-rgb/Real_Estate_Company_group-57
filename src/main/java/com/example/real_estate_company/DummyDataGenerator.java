package com.example.real_estate_company;

import com.example.real_estate_company.KaziTahmidAbtahi.Client.Property;
// TODO: Import your actual User or Employee class here!
// import com.example.real_estate_company.User;

import java.io.File;
import java.io.IOException;

public class DummyDataGenerator {
    public static void main(String[] args) {

        System.out.println("--- Starting Dummy Data Generation ---");

        // =========================================================
        // 1. GENERATE FINANCE OFFICER LOGIN CREDENTIALS
        // =========================================================
        String userFileName = "UserData.bin"; // Change this if your login system uses a different file name

        File userFile = new File(userFileName);
        if (userFile.exists()) {
            userFile.delete();
        }

        try {
            // *** IMPORTANT: Update this line to match your actual User class constructor! ***
            // Example assumes: User(int id, String name, String password, String role)
            // User demoFinanceOfficer = new User(1001, "Tahmid", "1234", "Finance Officer");
            // Helper.writeInto(userFileName, demoFinanceOfficer);

            System.out.println("Success! Demo Finance Officer created. (Make sure to uncomment and fix the User object line)");
        } catch (Exception e) {
            System.out.println("Error generating User data: " + e.getMessage());
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

        System.out.println("--- Generation Complete ---");
    }
}