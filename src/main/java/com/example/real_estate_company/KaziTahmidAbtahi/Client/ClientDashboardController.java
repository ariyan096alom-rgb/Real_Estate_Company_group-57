package com.example.real_estate_company.KaziTahmidAbtahi.Client;

import com.example.real_estate_company.Main.Client;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class ClientDashboardController {
    // A placeholder label to show it worked (make sure you add this fx:id in your Dashboard FXML)
    @javafx.fxml.FXML
    private Label welcomeLabel;

    // This variable will hold the logged-in user's data
    private Client loggedInClient;

    @javafx.fxml.FXML
    public void initialize() {
        // This runs automatically when the dashboard loads, but BEFORE initData is called
    }

    // ==========================================================
    // THIS IS THE FIX: The method your LoginController is calling
    // ==========================================================
    public void initData(Client client) {
        // 1. Catch the passed client object and save it to this controller
        this.loggedInClient = client;

        // 2. Test it to make sure it works!
        if (welcomeLabel != null) {
            welcomeLabel.setText("Welcome back, " + loggedInClient.getUserName() + "!");
        }

        // You can print to the console just to verify the data arrived safely
        System.out.println("Data successfully passed to Dashboard: " + loggedInClient.toString());
    }

    @javafx.fxml.FXML
    private StackPane contentArea;

    @javafx.fxml.FXML
    public void searchPropertiesButtonOnAction(ActionEvent actionEvent) {
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
}
