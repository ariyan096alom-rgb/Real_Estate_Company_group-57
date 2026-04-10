package com.example.real_estate_company.ZayedBinZaman.LeagalUser;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ContactController {
}
package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ContractController {

    @FXML
    private TextField contractId;
    @FXML private TextArea output;

    @FXML
    public void uploadContract(){
        output.setText("Contract uploaded.");
    }

    @FXML
    public void validateContract(){
        output.setText("Contract validated.");
    }
}
