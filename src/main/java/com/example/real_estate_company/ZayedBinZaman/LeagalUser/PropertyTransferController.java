package com.example.real_estate_company.ZayedBinZaman.LeagalUser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PropertyTransferController {

    @FXML
    private TextArea output;
    @FXML
    private TextField seller;
    @FXML
    private TextField transferID;
    @FXML
    private TextField buyer;

    @FXML
    public void processTransfer() {
        output.setText("Transfer completed.");
    }

    @FXML
    public void updateRecord(ActionEvent actionEvent) {
    }
}