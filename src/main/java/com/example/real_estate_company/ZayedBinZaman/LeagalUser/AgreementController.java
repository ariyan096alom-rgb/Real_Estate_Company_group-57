package com.example.real_estate_company.ZayedBinZaman.LeagalUser;

import javafx.event.ActionEvent;
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

    }

    @FXML
    public void validateAgreement() {
        statusLabel.setText("Agreement validated.");
    }

    @FXML
    public void generateAgreementOnClick(ActionEvent actionEvent) {
    }
}