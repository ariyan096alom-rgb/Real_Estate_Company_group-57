package com.example.real_estate_company.ZayedBinZaman.SiteEngineer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MaterialController {

    @FXML
    private TextField materialName;

    @FXML
    private TextArea output;

    @FXML
    public void updateInventory(ActionEvent event) {
        output.setText("Inventory updated for " + materialName.getText());
    }
}