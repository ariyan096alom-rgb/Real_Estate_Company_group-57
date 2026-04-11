package com.example.real_estate_company.ZayedBinZaman.SiteEngineer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ProgressReportController {

    @FXML
    private TextArea output;
    @FXML
    private TextField report;
    @FXML
    private TextField project;
    @FXML
    private TextArea details;

    @Deprecated
    public void generateReport(ActionEvent event) {
        // You can later add file handling or string formatting here to make a real report!
        output.setText("Report generated.");
    }

    @FXML
    public void gererateReportOA(ActionEvent actionEvent) {
    }

    @FXML
    public void storeReportOA(ActionEvent actionEvent) {
    }
}
