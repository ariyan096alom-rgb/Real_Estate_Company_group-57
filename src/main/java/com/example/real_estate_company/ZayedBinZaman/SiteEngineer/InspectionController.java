package com.example.real_estate_company.ZayedBinZaman.SiteEngineer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class InspectionController {

    @FXML
    private TextArea output;

    @FXML
    public void validateInspection(ActionEvent event) {
        output.setText("Inspection validated.");
    }
}