package com.example.real_estate_company.ZayedBinZaman.LeagalUser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LegalIssueController {

    @FXML
    private TextArea output;
    @FXML
    private TextField issueID;
    @FXML
    private TextField discription;

    @FXML
    public void reportIssue() {
        output.setText("Issue reported.");
    }

    @FXML
    public void reportIssueOA(ActionEvent actionEvent) {
    }

    @FXML
    public void storeRecordOA(ActionEvent actionEvent) {
    }
}