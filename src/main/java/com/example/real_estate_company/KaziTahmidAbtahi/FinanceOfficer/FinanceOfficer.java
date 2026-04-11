package com.example.real_estate_company.KaziTahmidAbtahi.FinanceOfficer;

import java.io.Serializable;

public class FinanceOfficer implements Serializable {

    private int employeeId;
    private String name;
    private String password;
    private String email;

    public FinanceOfficer(int employeeId, String name, String password, String email) {
        this.employeeId = employeeId;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "FinanceOfficer{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
