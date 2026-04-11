package com.example.real_estate_company.ZayedBinZaman.LeagalUser;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AgreementController {

    @FXML
    private TextField agreementId;

    @FXML
    private TextArea output;

    @FXML
    public void generateAgreement() {
        if (agreementId.getText().isEmpty()) {
            output.setText("Enter Agreement ID.");
        } else {
            output.setText("Agreement generated: " + agreementId.getText());
        }
    }

    @FXML
    public void validateAgreement() {
        output.setText("Agreement validated.");
    }
}