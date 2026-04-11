package com.example.real_estate_company.mahhi;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void salesreportOnAction(ActionEvent actionEvent) {
        try {
            // Load the Sales Report FXML
            // Make sure the filename matches your FXML file exactly!
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("salesreport-view.fxml")));

            // Create the new scene
            Scene scene = new Scene(root);

            // Get the current window (Stage) and set the new scene
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Sales Performance Report");
            stage.show();

        } catch (IOException e) {
            System.out.println("Error: Could not find SalesReport.fxml. Check the file name and path.");
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void staffattendenceOnAction(ActionEvent actionEvent) {
        try {
            // Make sure the FXML name matches your file exactly!
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("staffattendance-view.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void salarysummaryOnAction(ActionEvent actionEvent) {
        try {
            // Load the Salary Summary FXML
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("salarysummary-view.fxml")));

            // Create the scene and get the stage
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            // Switch the scene
            stage.setScene(scene);
            stage.setTitle("Salary Summary");
            stage.show();
        } catch (IOException e) {
            System.out.println("Error: Could not find SalarySummary.fxml");
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void projectProgessOnAction(ActionEvent actionEvent) {
        try {
            // IMPORTANT: The name here must match your FXML file exactly (case-sensitive!)
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("projectprogress-view.fxml")));

            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error: Could not find ProjectProgress.fxml");
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void financialsummaryOnAction(ActionEvent actionEvent) {
        try {
            // Double-check this filename! It must match your FXML file exactly.
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("financialsummary-view.fxml")));

            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("LOG: Could not find the FXML file!");
            e.printStackTrace(); // This will tell you the EXACT error in the console
        }
    }

    @javafx.fxml.FXML
    public void companyoverviewOnAction(ActionEvent actionEvent) {
        try {
            // 1. Load the FXML file for the Company Summary page
            // Adjust the exact spelling of "companysummary.fxml" to match your actual file name
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("companysummary-view.fxml")));

            // 2. Create a new Scene with this FXML
            Scene scene = new Scene(root);

            // 3. Get the current window (Stage) from the button that was clicked
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            // 4. Set the new scene on the window and show it
            stage.setTitle("Company Summary");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            System.out.println("Error loading Company Summary screen!");
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void projectapprovalOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void propertysaleapprovalOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logoutOnAction(ActionEvent actionEvent) {
    }
}