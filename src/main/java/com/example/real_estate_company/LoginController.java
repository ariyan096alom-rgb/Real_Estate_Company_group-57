package com.example.real_estate_company;

import com.example.real_estate_company.KaziTahmidAbtahi.Client.Client;
import com.example.real_estate_company.KaziTahmidAbtahi.Client.ClientDashboardController;
import com.example.real_estate_company.KaziTahmidAbtahi.FinanceOfficer.FinanceOfficer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;

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
    public void initialize(){
        selectUserTypeCB.getItems().addAll("Managing Director", "Sales Manager", "Client", "Finance Officer", "Legal Officer", "Site Engineer", "Project Manager", "Sales Executive");
    }

    @javafx.fxml.FXML
    public void loginButtonOnAction(ActionEvent actionEvent){
        String email = enterEmailAddressTF.getText();
        String password = enterPasswordTF.getText();
        String userType = selectUserTypeCB.getValue();

        if (email.isEmpty() || password.isEmpty() || userType == null){
            feedbackLabel.setText("Missing details.");
            Helper.showAlert("Error", "Please fill all fields.");
            return;

        }

        if (!email.contains("@")){
            feedbackLabel.setText("Bad email.");
            Helper.showAlert("Error", "Invalid email format.");
            return;
        }

        if (password.length() < 8 || password.length() > 16) {
            feedbackLabel.setText("Bad password.");
            Helper.showAlert("Error", "Password must be 8 to 16 characters.");
            return;
        }

        if (userType.equals("Client")){
            ArrayList<Client> clients = new ArrayList<>();
            try {
                Helper.loadFrom("ClientData.bin", clients);
            }

            catch (Exception e) {
                Helper.showAlert("Error", "Data missing.");
                return;
            }

            Client user = null;
            for (Client c : clients) {
                if (c.getEmailAddress().equals(email) && c.getPassword().equals(password)){
                    user = c;
                    break;
                }
            }




            if (user == null) {
                feedbackLabel.setText("Wrong credentials.");
                Helper.showAlert("Failed", "Wrong email or password.");
            }

            else {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/real_estate_company/KaziTahmidAbtahi/Client/ClientDashboard.fxml"));
                    Scene scene = new Scene(loader.load());
                    ClientDashboardController controller = loader.getController();
                    controller.initData(user);
                    Helper.setScene(actionEvent, scene);
                }

                catch (Exception e) {
                    Helper.showAlert("Error", "Cannot open dashboard.");
                }
            }
        }


        else if (userType.equals("Finance Officer")) {
            ArrayList<Object> officers = new ArrayList<>();
            try {
                Helper.loadFrom("FinanceOfficerData.bin", officers);
            }
            catch (Exception e) {
                Helper.showAlert("Error", "Data missing.");
                return;
            }

            FinanceOfficer user = null;
            for (Object obj : officers){
                FinanceOfficer fo = (FinanceOfficer) obj;
                if (fo.getEmailAddress().equals(email) && fo.getPassword().equals(password)){
                    user = fo;
                    break;
                }
            }

            if (user == null) {
                feedbackLabel.setText("Wrong credentials.");
                Helper.showAlert("Failed", "Wrong email or password.");
            }

            else {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/real_estate_company/KaziTahmidAbtahi/Finance Officer/FinanceOfficerDashboard.fxml"));
                    Scene scene = new Scene(loader.load());
                    Helper.setScene(actionEvent, scene);
                }
                catch (Exception e){
                    Helper.showAlert("Error", "Cannot open dashboard.");
                }
            }

        }
        else {
            Helper.showAlert("Info", "Not ready yet.");
        }
    }

    @javafx.fxml.FXML
    public void registerNewAccountOnAction(ActionEvent actionEvent){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/real_estate_company/KaziTahmidAbtahi/Client/ClientRegistration.fxml"));
            Scene scene = new Scene(loader.load());
            Helper.setScene(actionEvent, scene);
        } catch (Exception e) {
            Helper.showAlert("Error", "Cannot open registration.");

        }

    }


}