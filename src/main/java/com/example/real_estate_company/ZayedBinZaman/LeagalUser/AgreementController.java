package com.example.real_estate_company.ZayedBinZaman.LeagalUser;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.awt.*;

public class AgreementController {
}
package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AgreementController {

    @FXML private TextField agreementId;
    @FXML private TextArea output;

    @FXML
    public void generateAgreement(){
        if(agreementId.getText().isEmpty()){
            output.setText("Enter Agreement ID.");
        } else {
            output.setText("Agreement generated: " + agreementId.getText());
        }
    }

    @FXML
    public void validateAgreement(){
        output.setText("Agreement validated.");
    }
}
