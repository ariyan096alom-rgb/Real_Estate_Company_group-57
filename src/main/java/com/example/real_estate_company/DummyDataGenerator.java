package com.example.real_estate_company;

import com.example.real_estate_company.KaziTahmidAbtahi.Client.Property;

import java.io.File;
import java.io.IOException;

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
    }

}
