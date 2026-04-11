package com.example.real_estate_company.KaziTahmidAbtahi.Client;

import java.io.Serializable;

public class Property implements Serializable {
    private int propertyId;
    private String propertyName;
    private String location;
    private double price;
    private double sizeSqFt;
    private int bedrooms;
    private String propertyType;
    private String status;

    public Property(int propertyId, String propertyName, String location, double price, double sizeSqFt, int bedrooms, String propertyType, String status) {
        this.propertyId = propertyId;
        this.propertyName = propertyName;
        this.location = location;
        this.price = price;
        this.sizeSqFt = sizeSqFt;
        this.bedrooms = bedrooms;
        this.propertyType = propertyType;
        this.status = status;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSizeSqFt() {
        return sizeSqFt;
    }

    public void setSizeSqFt(double sizeSqFt) {
        this.sizeSqFt = sizeSqFt;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + propertyId +
                ", propertyName='" + propertyName + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", sizeSqFt=" + sizeSqFt +
                ", bedrooms=" + bedrooms +
                ", propertyType='" + propertyType + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
