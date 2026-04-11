package com.example.real_estate_company.ZayedBinZaman.SiteEngineer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class LegalIssueController {

    @FXML
    private TextArea output;

    @FXML
    public void reportIssue(ActionEvent event) {
        output.setText("Issue reported.");
    }
}