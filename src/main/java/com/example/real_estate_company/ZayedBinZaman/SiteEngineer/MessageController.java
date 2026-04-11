package com.example.real_estate_company.ZayedBinZaman.SiteEngineer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MessageController {

    @FXML
    private TextArea output;
    @FXML
    private TextArea messageContant;
    @FXML
    private TextField receiver;
    @FXML
    private TextField messageID;
    @FXML
    private TextField send;

    @Deprecated
    public void sendMessage(ActionEvent event) {
        output.setText("Message sent: " + messageContant.getText());
    }

    @FXML
    public void SendOA(ActionEvent actionEvent) {
    }
}