package com.example.real_estate_company.ZayedBinZaman.SiteEngineer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class MessageController {

    @FXML
    private TextArea messageContent;

    @FXML
    private TextArea output;

    @FXML
    public void sendMessage(ActionEvent event) {
        output.setText("Message sent: " + messageContent.getText());
    }
}