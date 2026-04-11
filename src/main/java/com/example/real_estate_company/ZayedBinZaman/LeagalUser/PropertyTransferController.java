package com.example.real_estate_company.ZayedBinZaman.LeagalUser;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class PropertyTransferController {

    @FXML
    private TextArea output;

    @FXML
    public void processTransfer() {
        output.setText("Transfer completed.");
    }
}