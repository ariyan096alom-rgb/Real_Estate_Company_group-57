package com.example.real_estate_company.ZayedBinZaman.SiteEngineer;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MetarialController {
}
package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MaterialController {

    @FXML
    private TextField materialName;
    @FXML private TextArea output;

    @FXML
    public void updateInventory(){
        output.setText("Inventory updated for " + materialName.getText());
    }
}
