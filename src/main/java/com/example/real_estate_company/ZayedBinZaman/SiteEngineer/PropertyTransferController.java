package com.example.real_estate_company.ZayedBinZaman.SiteEngineer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class PropertyTransferController {

    @FXML
    private TextArea output;

    @FXML
    public void processTransfer(ActionEvent event) {

        output.setText("Transfer completed.");
    }
}