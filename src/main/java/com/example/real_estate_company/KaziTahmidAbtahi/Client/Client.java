package com.example.real_estate_company.KaziTahmidAbtahi.Client;

import com.example.real_estate_company.User;

import java.time.LocalDate;

public class Client extends User {
    private LocalDate DOB;
    private String phoneNumber;
    private String gender;

    public Client(int userId, String userName, String emailAddress, String password, LocalDate DOB, String phoneNumber, String gender) {
        super(userId, userName, emailAddress, password);
        this.DOB = DOB;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Client{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", DOB=" + DOB +
                ", phoneNumber=" + phoneNumber +
                ", gender='" + gender + '\'' +
                '}';
    }
}
