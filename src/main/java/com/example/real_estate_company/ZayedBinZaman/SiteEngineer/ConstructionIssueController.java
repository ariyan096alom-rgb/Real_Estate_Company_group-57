package com.example.real_estate_company.ZayedBinZaman.SiteEngineer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ConstructionIssueController {

    @FXML
    private TextArea output;
    @FXML
    private TextField issueID;
    @FXML
    private TextField statusID;
    @FXML
    private TextField projectID;

    @FXML
    public void resolveIssue() {
        output.setText("Issue resolved.");
    }

    @FXML
    public void resolveOA(ActionEvent actionEvent) {
    }

    @FXML
    public void validateOA(ActionEvent actionEvent) {
    }
}