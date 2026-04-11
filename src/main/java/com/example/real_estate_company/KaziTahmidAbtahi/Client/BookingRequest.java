package com.example.real_estate_company.KaziTahmidAbtahi.Client;

import java.io.Serializable;

public class BookingRequest implements Serializable {
    private String bookingRefNum;
    private int propertyId;
    private String propertyName;
    private String paymentPlan;
    private double totalAmount;
    private String status;

    public BookingRequest(String bookingRefNum, int propertyId, String propertyName, String paymentPlan, double totalAmount, String status) {
        this.bookingRefNum = bookingRefNum;
        this.propertyId = propertyId;
        this.propertyName = propertyName;
        this.paymentPlan = paymentPlan;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public String getBookingRefNum() {
        return bookingRefNum;
    }

    public void setBookingRefNum(String bookingRefNum) {
        this.bookingRefNum = bookingRefNum;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPaymentPlan() {
        return paymentPlan;
    }

    public void setPaymentPlan(String paymentPlan) {
        this.paymentPlan = paymentPlan;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookingRequest{" +
                "bookingRefNum='" + bookingRefNum + '\'' +
                ", propertyId=" + propertyId +
                ", propertyName='" + propertyName + '\'' +
                ", paymentPlan='" + paymentPlan + '\'' +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                '}';
    }
}
