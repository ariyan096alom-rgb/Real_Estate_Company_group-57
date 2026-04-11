package com.example.real_estate_company.KaziTahmidAbtahi.Client;

import com.example.real_estate_company.Helper;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ClientRegistrationController
{
    @javafx.fxml.FXML
    private Label feedbackLabel;
    @javafx.fxml.FXML
    private TextField fullNameTF;
    @javafx.fxml.FXML
    private ToggleGroup genderRB;
    @javafx.fxml.FXML
    private PasswordField passwordTF;
    @javafx.fxml.FXML
    private Button backToLoginButton;
    @javafx.fxml.FXML
    private CheckBox confirmationCheckBox;
    @javafx.fxml.FXML
    private PasswordField confirmPasswordTF;
    @javafx.fxml.FXML
    private RadioButton femaleRB;
    @javafx.fxml.FXML
    private RadioButton maleRB;
    @javafx.fxml.FXML
    private Button registerButton;
    @javafx.fxml.FXML
    private DatePicker dateOfBirthDP;
    @javafx.fxml.FXML
    private TextField phoneNumberTF;
    @javafx.fxml.FXML
    private TextField emailAddressTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void registerButtonOnAction(ActionEvent actionEvent) {
        String name = fullNameTF.getText();
        String email = emailAddressTF.getText();
        String phoneStr = phoneNumberTF.getText();
        String password = passwordTF.getText();
        String confirmPass = confirmPasswordTF.getText();
        LocalDate dob = dateOfBirthDP.getValue();

        String gender = "";
        if (maleRB.isSelected()) {
            gender = "Male";
        } else if (femaleRB.isSelected()) {
            gender = "Female";
        }

        if (name.isEmpty() || email.isEmpty() || phoneStr.isEmpty() || password.isEmpty() || confirmPass.isEmpty() || dob == null || gender.isEmpty()) {
            feedbackLabel.setText("Error: Please fill in all fields.");
            return;
        }

        if (!confirmationCheckBox.isSelected()) {
            feedbackLabel.setText("Error: You must confirm your information.");
            return;
        }

        if (!email.contains("@")) {
            feedbackLabel.setText("Error: Email format is invalid.");
            return;
        }

        if (!password.equals(confirmPass)) {
            feedbackLabel.setText("Error: Passwords do not match.");
            return;
        }

        if (password.length() < 8 || password.length() > 16) {
            feedbackLabel.setText("Error: Password must be 8-16 characters.");
            return;
        }

        if (phoneStr.length() != 11 || !phoneStr.matches("\\d+")) {
            feedbackLabel.setText("Error: Phone number must be exactly 11 digits.");
            return;
        }

        ArrayList<Client> existingClients = new ArrayList<>();
        try {
            Helper.loadFrom("ClientData.bin", existingClients);

            for (Client existingClient : existingClients) {
                if (existingClient.getEmailAddress().equalsIgnoreCase(email)) {
                    feedbackLabel.setText("Error: Email already registered.");
                    Helper.showAlert("Registration Failed", "Email already exists.");
                    return;
                }
            }
        } catch (IOException e) {

        }


        int randomUserId = (int) (Math.random() * 90000) + 10000;
        Client newClient = new Client(randomUserId, name, email, password, dob, gender, phoneStr);

        try {
            Helper.writeInto("ClientData.bin", newClient);

            feedbackLabel.setText("Registration Successful!");

            Helper.showAlert("Registration Success", "Account created successfully!\n\nYour User ID is: " + randomUserId);

            Helper.logOut(actionEvent);

        } catch (IOException e) {
            feedbackLabel.setText("Error: Could not save data to system.");
            e.printStackTrace();
        }
    }


    @javafx.fxml.FXML
    public void backToLoginButtonOnAction(ActionEvent actionEvent) {
        try {
            Helper.logOut(actionEvent);
        } catch (IOException e) {
            Helper.showAlert("Error", "Could not load the login screen.");
        }
    }

}