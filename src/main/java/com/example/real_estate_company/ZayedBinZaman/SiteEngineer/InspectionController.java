package com.example.real_estate_company.ZayedBinZaman.SiteEngineer;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class InspectionController {
}
package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class InspectionController {

    @FXML
    private TextArea output;

    @FXML
    public void validateInspection(){
        output.setText("Inspection validated.");
    }
}

