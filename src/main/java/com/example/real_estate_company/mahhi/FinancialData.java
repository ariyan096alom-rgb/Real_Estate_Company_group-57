package com.example.real_estate_company.mahhi;

import java.io.Serializable;

public class FinancialData implements Serializable {
    private double totalIncome;
    private double totalExpense;

    public FinancialData(double totalIncome, double totalExpense) {
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
    }

    public double getTotalIncome() { return totalIncome; }
    public double getTotalExpense() { return totalExpense; }
}
