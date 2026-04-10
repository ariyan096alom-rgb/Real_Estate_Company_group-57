package com.example.real_estate_company;

import com.example.real_estate_company.KaziTahmidAbtahi.Client.Client;
import com.example.real_estate_company.KaziTahmidAbtahi.Client.ClientDashboardController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;

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
    public void initialize() {
        selectUserTypeCB.getItems().addAll(
                "Managing Director", "Sales Manager", "Client",
                "Finance Officer", "Legal Officer", "Site Engineer",
                "Project Manager", "Sales Executive"
        );
    }

    @javafx.fxml.FXML
    public void loginButtonOnAction(ActionEvent actionEvent) {
        String email = enterEmailAddressTF.getText();
        String password = enterPasswordTF.getText();
        String userType = selectUserTypeCB.getValue();

        if (email.isEmpty() || password.isEmpty() || userType == null) {
            feedbackLabel.setText("Fill all the informations properly.");
            Helper.showAlert("Validation Error", "Please fill out all fields and select a user type.");
            return;
        }

        if (!email.contains("@")) {
            feedbackLabel.setText("Email format is incorrect.");
            Helper.showAlert("Validation Error", "Email must contain '@'.");
            return;
        }

        if (password.length() < 8 || password.length() > 16) {
            feedbackLabel.setText("Password length should be between 8-16 digits.");
            Helper.showAlert("Validation Error", "Password length should be between 8-16 characters.");
            return;
        }

        if (userType.equals("Client")) {

            ArrayList<Client> clientList = new ArrayList<>();
            try {
                Helper.loadFrom("ClientData.bin", clientList);
            } catch (IOException e) {
                Helper.showAlert("System Error", "Could not access client data.");
                return;
            }

            Client loggedInClient = null;

            for (Client c : clientList) {
                if (c.getEmailAddress().equals(email) && c.getPassword().equals(password)) {
                    loggedInClient = c;
                    break;
                }
            }

            if (loggedInClient == null) {
                feedbackLabel.setText("Invalid Informations");
                Helper.showAlert("Login Failed", "Incorrect email or password.");
            } else {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/real_estate_company/KaziTahmidAbtahi/Client/ClientDashboard.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());

                    ClientDashboardController receiverController = fxmlLoader.getController();
                    receiverController.initData(loggedInClient);

                    Helper.setScene(actionEvent, scene);

                } catch (Exception e) {
                    e.printStackTrace();
                    Helper.showAlert("Navigation Error", "Could not load the client dashboard.");
                }
            }
        } else {
            Helper.showAlert("Under Construction", "Login for " + userType + " is not set up yet.");
        }
    }

    @javafx.fxml.FXML
    public void registerNewAccountOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/real_estate_company/KaziTahmidAbtahi/Client/ClientRegistration.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Helper.setScene(actionEvent, scene);
        } catch (Exception e) {
            e.printStackTrace();
            Helper.showAlert("Error", "Could not load the registration screen.");
        }
    }
}