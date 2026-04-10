package com.example.real_estate_company.ZayedBinZaman.LeagalUser;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ComplaianceController {
}
package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ComplianceController {

    @FXML
    private TextField complianceId;
    @FXML private TextArea output;

    @FXML
    public void approveStatus(){
        output.setText("Status approved.");
    }

    @FXML
    public void validateApproval(){
        output.setText("Approval validated.");
    }
}
