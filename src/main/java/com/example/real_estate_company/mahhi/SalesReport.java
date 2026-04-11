package com.example.real_estate_company.mahhi;

public class SalesReport {
    private String revenue;
    private String units;

    public SalesReport(String revenue, String units) {
        this.revenue = revenue;
        this.units = units;
    }

    public String getRevenue() { return revenue; }
    public String getUnits() { return units; }
}
