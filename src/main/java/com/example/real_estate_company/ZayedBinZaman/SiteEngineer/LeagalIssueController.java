package com.example.real_estate_company.ZayedBinZaman.SiteEngineer;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class LeagalIssueController {

    @FXML private TextArea output;

    @FXML
    public void reportIssue(){
        output.setText("Issue reported.");
    }
}
