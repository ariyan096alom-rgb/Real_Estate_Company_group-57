package com.example.real_estate_company.ZayedBinZaman.SiteEngineer;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MessageController {

    @FXML private TextArea messageContent;
    @FXML private TextArea output;

    @FXML
    public void sendMessage(){
        output.setText("Message sent: " + messageContent.getText());
    }
}
