package com.example.real_estate_company.mahhi;

import java.io.Serializable;

public class CompanyData implements Serializable {
    private String totalProjects;
    private String totalProperties;
    private String totalEmployees;
    private String businessStatus;

    public CompanyData(String totalProjects, String totalProperties, String totalEmployees, String businessStatus) {
        this.totalProjects = totalProjects;
        this.totalProperties = totalProperties;
        this.totalEmployees = totalEmployees;
        this.businessStatus = businessStatus;
    }

    public String getTotalProjects() { return totalProjects; }
    public String getTotalProperties() { return totalProperties; }
    public String getTotalEmployees() { return totalEmployees; }
    public String getBusinessStatus() { return businessStatus; }
}
