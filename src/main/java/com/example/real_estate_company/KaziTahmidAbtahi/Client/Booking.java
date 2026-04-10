package com.example.real_estate_company.KaziTahmidAbtahi.Client;

import java.io.Serializable;

public class Booking implements Serializable {
    private int bookingId;
    private int clientId;
    private int propertyId;
    private String paymentPlan;
    private String status;

    public Booking(int bookingId, int clientId, int propertyId, String paymentPlan, String status) {
        this.bookingId = bookingId;
        this.clientId = clientId;
        this.propertyId = propertyId;
        this.paymentPlan = paymentPlan;
        this.status = status;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getPaymentPlan() {
        return paymentPlan;
    }

    public void setPaymentPlan(String paymentPlan) {
        this.paymentPlan = paymentPlan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", clientId=" + clientId +
                ", propertyId=" + propertyId +
                ", paymentPlan='" + paymentPlan + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
