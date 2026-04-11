package com.example.real_estate_company.mahhi;

import java.io.Serializable;
import java.time.LocalDate;

public class AttendanceRecord implements Serializable {
    private String employeeName;
    private String date; // Using String for simplicity in the table
    private String status;

    public AttendanceRecord(String employeeName, String date, String status) {
        this.employeeName = employeeName;
        this.date = date;
        this.status = status;
    }

    // Getters - These are required for the TableView to show data!
    public String getEmployeeName() { return employeeName; }
    public String getDate() { return date; }
    public String getStatus() { return status; }
}
