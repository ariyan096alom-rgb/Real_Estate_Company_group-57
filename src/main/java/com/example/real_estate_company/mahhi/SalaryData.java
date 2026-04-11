package com.example.real_estate_company.mahhi;

import java.io.Serializable;

public class SalaryData implements Serializable {
    private double baseSalary;
    private double bonus;

    public SalaryData(double baseSalary, double bonus) {
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    public double getBaseSalary() { return baseSalary; }
    public double getBonus() { return bonus; }
    public double getGrandTotal() { return baseSalary + bonus; }
}
