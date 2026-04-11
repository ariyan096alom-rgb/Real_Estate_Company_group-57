package com.example.real_estate_company.ZayedBinZaman.LeagalUser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ComplianceController {

    @FXML
    private TextArea StatusLebel;
    @FXML
    private TextField complaianceIdTextField;
    @FXML
    private TextField projectIdTextField;

    @FXML
    public void approveStatus() {
        StatusLebel.setText("Status approved.");
    }

    @FXML
    public void validateApproval() {
        StatusLebel.setText("Approval validated.");
    }

    @FXML
    public void ProcessResultID(ActionEvent actionEvent) {
    }

    @FXML
    public void ValidateApprovalOnClick(ActionEvent actionEvent) {
    }

    @FXML
    public void aprovestatusOnClick(ActionEvent actionEvent) {
    }
}