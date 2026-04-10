package com.example.real_estate_company.KaziTahmidAbtahi.Client;

import java.io.Serializable;
import java.time.LocalDate;

public class VisitSiteAppointment implements Serializable {
    private int propertyId;
    private String propertyName;
    private LocalDate visitDate;
    private String visitTime;
    private String confirmationNum;

    public VisitSiteAppointment(int propertyId, String propertyName, LocalDate visitDate, String visitTime, String confirmationNum) {
        this.propertyId = propertyId;
        this.propertyName = propertyName;
        this.visitDate = visitDate;
        this.visitTime = visitTime;
        this.confirmationNum = confirmationNum;
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

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public String getConfirmationNum() {
        return confirmationNum;
    }

    public void setConfirmationNum(String confirmationNum) {
        this.confirmationNum = confirmationNum;
    }

    @Override
    public String toString() {
        return "VisitSiteAppointment{" +
                "propertyId=" + propertyId +
                ", propertyName='" + propertyName + '\'' +
                ", visitDate=" + visitDate +
                ", visitTime='" + visitTime + '\'' +
                ", confirmationNum='" + confirmationNum + '\'' +
                '}';
    }
}
