package com.example.real_estate_company.KaziTahmidAbtahi.Client;

import com.example.real_estate_company.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class ClientDashboardController
{
    @javafx.fxml.FXML
    private AnchorPane areaForSceneSwitching;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void paymentsButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void signOutButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void bookingsAndDocsButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void trackStatusButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewPropertiesButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/real_estate_company/KaziTahmidAbtahi/Client/PropertySearch.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Helper.setScene(actionEvent, scene);
        } catch (Exception e) {
            e.printStackTrace();
            Helper.showAlert("Error", "Could not load the Property Search screen.");
        }
    }


    public void initData(Client loggedInClient) {
    }
}