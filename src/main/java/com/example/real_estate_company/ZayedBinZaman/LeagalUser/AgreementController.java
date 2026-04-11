package com.example.real_estate_company.ZayedBinZaman.LeagalUser;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AgreementController {

    @FXML
    private TextField ClientIdTextField;
    @FXML
    private TextField AgreementIdTextField;
    @FXML
    private TextField propertyIdTextField;
    @FXML
    private TextArea statusLabel;

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

    @FXML
    public void validateAgreementOnClick(ActionEvent actionEvent) {
        String agreementID = AgreementIdTextField.getText().trim();
        String propertyID = propertyIdTextField.getText().trim();
        String clientID = ClientIdTextField.getText().trim();

        if(agreementID.isEmpty() || propertyID.isEmpty() || clientID.isEmpty()) {
            statusLabel.setText("Error: Please fill in all the field.");
            statusLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        if(propertyIdTextField.)
    }

    @FXML
    public void generateAgreementOnClick(ActionEvent actionEvent) {
    }
}