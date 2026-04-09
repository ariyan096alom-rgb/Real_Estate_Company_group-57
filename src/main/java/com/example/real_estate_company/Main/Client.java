package com.example.real_estate_company.Main;

import java.time.LocalDate;

public class Client extends User {
    private LocalDate DOB;
    private int phoneNumber;
    private String gender;

    public Client(int userId, String userName, String emailAddress, String password, LocalDate DOB, String gender, int phoneNumber) {
        super(userId, userName, emailAddress, password);
        this.DOB = DOB;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
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
