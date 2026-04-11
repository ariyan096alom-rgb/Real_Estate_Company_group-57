package com.example.real_estate_company.ZayedBinZaman.SiteEngineer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SiteEngineerController {

    @FXML
    private TextField engineerName;

    @FXML
    private TextArea output;
    @FXML
    private TextField projectName;

    @FXML
    public void monitorConstruction() {
        output.setText("Monitoring construction...");
    }

    @FXML
    public void approveDesign() {
        output.setText("Design approved.");
    }

    @FXML
    public void approveOA(ActionEvent actionEvent) {
    }

    @FXML
    public void taskOA(ActionEvent actionEvent) {
    }

    @FXML
    public void monitorOA(ActionEvent actionEvent) {
    }

    @FXML
    public void generateOA(ActionEvent actionEvent) {
    }
}