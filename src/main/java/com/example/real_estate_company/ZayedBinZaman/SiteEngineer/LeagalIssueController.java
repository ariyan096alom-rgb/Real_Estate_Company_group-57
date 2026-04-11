package com.example.real_estate_company.ZayedBinZaman.SiteEngineer;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class LeagalIssueController {
}
package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LegalIssueController {

    @FXML private TextArea output;

    @FXML
    public void reportIssue(){
        output.setText("Issue reported.");
    }
}
