package com.example.real_estate_company.ZayedBinZaman.LeagalUser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ContractController {

    @FXML
    private TextField contactId;
    @FXML
    private TextField FileName;
    @FXML
    private TextArea resultLabel;

    @FXML
    public void uploadContract() {
        if (contactId.getText().isEmpty()) {
            resultLabel.setText("Please enter Contract ID first.");
            return;
        }

        resultLabel.setText("Contract " + contactId.getText() + " uploaded.");
    }

    @FXML
    public void validateContract() {
        if (contactId.getText().isEmpty()) {
            resultLabel.setText("Please enter Contract ID first.");
            return;
        }

        resultLabel.setText("Contract " + contactId.getText() + " validated successfully.");
    }

    @FXML
    public void updateContracactOA(ActionEvent actionEvent) {
    }

    @FXML
    public void storeRecordOA(ActionEvent actionEvent) {
    }
}