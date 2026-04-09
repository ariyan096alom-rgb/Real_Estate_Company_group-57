package com.example.real_estate_company.KaziTahmidAbtahi.Main;

import com.example.real_estate_company.KaziTahmidAbtahi.Client.ClientDashboardController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoginController {
    @javafx.fxml.FXML
    private ComboBox<String> selectUserTypeCB;
    @javafx.fxml.FXML
    private PasswordField enterPasswordTF;
    @javafx.fxml.FXML
    private Label feedbackLabel;
    @javafx.fxml.FXML
    private TextField enterEmailAddressTF;
    @javafx.fxml.FXML



    public void initialize(){
        selectUserTypeCB.getItems().addAll("Managing Director"," Sales Manager","CLient","Finance Officer","Legal Officer"," Site Engineer","Project Manager","Sales Executive");
    }


    @javafx.fxml.FXML
    public void loginButtonOnAction(ActionEvent actionEvent) {
        String email = enterEmailAddressTF.getText();
        String password = enterPasswordTF.getText();
        String userType = selectUserTypeCB.getValue();

        if (email.isEmpty() || password.isEmpty() || userType == "null") {
            feedbackLabel.setText("Fill all the informations properly.");

            Alert emptyalert = new Alert(Alert.AlertType.ERROR);
            emptyalert.setContentText("Fill all the informations properly.");
            emptyalert.show();
            return;
        }

        if (!email.contains("@")) {
            feedbackLabel.setText("Email format is incorrect.");
            Alert formatalert = new Alert(Alert.AlertType.ERROR);
            formatalert.setContentText("Fill all the informations properly.");
            formatalert.show();
            return;

        }

        if (password.length() < 8 || password.length() > 16) {
            feedbackLabel.setText("Password length should be between 8-16 digits.");

            Alert lenghtalert = new Alert(Alert.AlertType.ERROR);
            lenghtalert.setContentText("Password length should be between 8-16 digits.");
            lenghtalert.show();
            return;

        }
// Reading the binary file the faculty's way
        Client loggedInClient = null;

        if (userType.equals("Client")) {
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try {
                File f = new File("ClientData.bin");
                if (f.exists()) {
                    fis = new FileInputStream(f);
                    ois = new ObjectInputStream(fis);

                    // Infinite loop to read objects
                    while (true) {
                        Client c = (Client) ois.readObject();
                        // If we find a match, save it and break the loop
                        if (c.getEmailAddress().equals(email) && c.getPassword().equals(password)) {
                            loggedInClient = c;
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                // The file ended, close the stream safely
                try {
                    if (ois != null) ois.close();
                } catch (IOException ex) {
                    // Ignored, just like faculty code
                }
            }
        }

        // Success or Failure
        if (loggedInClient == null) {
            // Failed login
            feedbackLabel.setText("Invalid Informations");
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Invalid Informations");
            errorAlert.show();
        } else {
            // Successful login - Load Dashboard
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/real_estate_company/KaziTahmidAbtahi/Client/ClientDashboard.fxml"));
                Scene scene = new Scene(fxmlLoader.load());

                // Pass the data to the next controller!
                ClientDashboardController receiverController = fxmlLoader.getController();
                receiverController.initData(loggedInClient);

                // Get current window and swap the scene
                Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                currentStage.setTitle("Client Dashboard");
                currentStage.setScene(scene);
                currentStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    } // End of loginButtonOnAction

    // Filled in the Registration button logic so you can get to the next screen!
    @javafx.fxml.FXML
    public void registerNewAccountOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/real_estate_company/KaziTahmidAbtahi/Client/ClientRegistration.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.setTitle("Client Registration");
            currentStage.setScene(scene);
            currentStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}