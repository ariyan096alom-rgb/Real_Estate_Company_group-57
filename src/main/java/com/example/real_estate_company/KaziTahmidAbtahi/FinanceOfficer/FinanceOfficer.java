package com.example.real_estate_company.KaziTahmidAbtahi.FinanceOfficer;

import com.example.real_estate_company.User;


public class FinanceOfficer extends User {

    public FinanceOfficer(int userId, String userName, String emailAddress, String password) {
        super(userId, userName, emailAddress, password);
    }

    @Override
    public String toString() {
        return "FinanceOfficer{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
