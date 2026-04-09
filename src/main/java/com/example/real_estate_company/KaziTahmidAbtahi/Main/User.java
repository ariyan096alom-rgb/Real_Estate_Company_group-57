package com.example.real_estate_company.KaziTahmidAbtahi.Main;

import java.io.Serializable;

public abstract class User implements Serializable {
    protected int userId;
    protected String userName;
    protected String emailAddress;
    protected String password;

    public User(int userId, String userName, String emailAddress, String password) {
        this.userId = userId;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
