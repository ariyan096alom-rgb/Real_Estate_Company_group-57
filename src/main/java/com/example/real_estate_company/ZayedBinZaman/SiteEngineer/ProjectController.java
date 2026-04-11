package com.example.real_estate_company.ZayedBinZaman.SiteEngineer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ProjectController {

    @FXML
    private TextArea output;
    @FXML
    private TextField name;
    @FXML
    private TextField project;
    @FXML
    private TextField progress;

    @FXML
    public void defineProject() {
        output.setText("Project defined: " + name.getText());
    }

    @FXML
    public void defineOA(ActionEvent actionEvent) {
    }

    @FXML
    public void updateOA(ActionEvent actionEvent) {
    }
}