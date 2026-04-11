package com.example.real_estate_company.ZayedBinZaman.LeagalUser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LegalUserController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField idField;
    @FXML
    private TextArea output;

    @FXML
    public void verifyOwnership() {
        if (nameField.getText().isEmpty()) {
            output.setText("Enter name first.");
        } else {
            output.setText("Ownership verified for " + nameField.getText());
        }
    }

    @FXML
    public void checkCompliance() {
        output.setText("Compliance check completed.");
    }

    @FXML
    public void assignClassification() {
        output.setText("Legal classification assigned.");
    }

    @FXML
    public void transferProperty() {
        output.setText("Property transfer initiated.");
    }

    @FXML
    public void checkComplaianceOA(ActionEvent actionEvent) {
    }

    @FXML
    public void assignLegalClassificationOA(ActionEvent actionEvent) {
    }

    @FXML
    public void handlePropertytransferOA(ActionEvent actionEvent) {
    }

    @FXML
    public void verifyOwnershipOA(ActionEvent actionEvent) {
    }
}