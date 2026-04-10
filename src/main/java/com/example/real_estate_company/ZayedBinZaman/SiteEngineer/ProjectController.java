package com.example.real_estate_company.ZayedBinZaman.SiteEngineer;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ProjectController {
}
package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ProjectController {

    @FXML
    private TextField projectName;
    @FXML private TextArea output;

    @FXML
    public void defineProject(){
        output.setText("Project defined: " + projectName.getText());
    }
}

