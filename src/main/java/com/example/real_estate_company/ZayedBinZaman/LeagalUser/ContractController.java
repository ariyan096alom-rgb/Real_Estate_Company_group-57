package com.example.real_estate_company.ZayedBinZaman.LeagalUser;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ContractController {

    @FXML
    private TextField contractId;

    @FXML
    private TextArea output;

    @FXML
    public void uploadContract() {
        if (contractId.getText().isEmpty()) {
            output.setText("Please enter Contract ID first.");
            return;
        }

        output.setText("Contract " + contractId.getText() + " uploaded.");
    }

    @FXML
    public void validateContract() {
        if (contractId.getText().isEmpty()) {
            output.setText("Please enter Contract ID first.");
            return;
        }

        output.setText("Contract " + contractId.getText() + " validated successfully.");
    }
}