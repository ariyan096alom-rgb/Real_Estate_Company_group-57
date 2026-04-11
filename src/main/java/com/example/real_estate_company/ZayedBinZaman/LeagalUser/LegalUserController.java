package com.example.real_estate_company.ZayedBinZaman.LeagalUser;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LegalUserController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField idField;

    @FXML
    private TextArea outputArea;

    @FXML
    public void verifyOwnership() {
        if (nameField.getText().isEmpty()) {
            outputArea.setText("Enter name first.");
        } else {
            outputArea.setText("Ownership verified for " + nameField.getText());
        }
    }

    @FXML
    public void checkCompliance() {
        outputArea.setText("Compliance check completed.");
    }

    @FXML
    public void assignClassification() {
        outputArea.setText("Legal classification assigned.");
    }

    @FXML
    public void transferProperty() {
        outputArea.setText("Property transfer initiated.");
    }
}