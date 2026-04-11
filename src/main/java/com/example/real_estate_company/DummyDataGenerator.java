package com.example.real_estate_company;

import com.example.real_estate_company.KaziTahmidAbtahi.Client.Property;
import com.example.real_estate_company.mahhi.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DummyDataGenerator {
    public static void main(String[] args) {
        String fileName = "PropertyData.bin";

        // Step 1: Delete the file if it already exists so we don't create duplicates
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }

        // Step 2: Write fresh sample data into the binary file
        try {
            Helper.writeInto(fileName, new Property(101, "Sunset Villa", "Gulshan", 150000.0, 2500, 4, "House", "Available"));
            Helper.writeInto(fileName, new Property(102, "Ocean View", "Banani", 85000.0, 1200, 3, "Apartment", "Available"));
            Helper.writeInto(fileName, new Property(103, "City Center Tower", "Dhanmondi", 200000.0, 5000, 0, "Commercial", "Available"));
            Helper.writeInto(fileName, new Property(104, "Green Plaza", "Uttara", 50000.0, 1000, 2, "Apartment", "Booked"));
            Helper.writeInto(fileName, new Property(105, "Luxury Condo", "Bashundhara", 120000.0, 1800, 3, "Apartment", "Available"));
            Helper.writeInto(fileName, new Property(106, "Mirpur Heights", "Mirpur", 45000.0, 900, 2, "Apartment", "Available"));

            System.out.println("Success! Sample properties have been saved to " + fileName);

        } catch (IOException e) {
            System.out.println("Error generating data: " + e.getMessage());
        }

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

}
