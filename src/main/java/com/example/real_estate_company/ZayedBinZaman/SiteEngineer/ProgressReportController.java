package com.example.real_estate_company.ZayedBinZaman.SiteEngineer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ProgressReportController {

    @FXML
    private TextArea output;

    @FXML
    public void generateReport(ActionEvent event) {
        // You can later add file handling or string formatting here to make a real report!
        output.setText("Report generated.");
    }
}