package com.example.real_estate_company.ZayedBinZaman.SiteEngineer;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;



import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ProgressReportController {

    @FXML private TextArea output;

    @FXML
    public void generateReport(){
        output.setText("Report generated.");
    }
}
