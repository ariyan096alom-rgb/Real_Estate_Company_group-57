package com.example.real_estate_company.ZayedBinZaman.LeagalUser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PropertyController {

    @FXML
    private TextField propertyId;

    @FXML
    private TextField ownerName;

    @FXML
    private TextField legalStatus;

    @FXML
    private TextArea outputArea;

    @FXML
    public void verifyOwnership() {
        if (propertyId.getText().isEmpty()) {
            outputArea.setText("Enter Property ID first.");
        } else {
            outputArea.setText("Ownership verified for Property ID: " + propertyId.getText());
        }
    }

    @FXML
    public void updateLegalStatus() {
        if (legalStatus.getText().isEmpty()) {
            outputArea.setText("Enter Legal Status.");
        } else {
            outputArea.setText("Legal status updated to: " + legalStatus.getText());
        }
    }

    @FXML
    public void goBack(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}