package com.example.real_estate_company.ZayedBinZaman.SiteEngineer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

<<<<<<< HEAD

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MessageController {

    @FXML private TextArea messageContent;
    @FXML private TextArea output;
=======
public class MessageController {
>>>>>>> 2ac478c33a71ad8835db5eeb1a29b32355017c94

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