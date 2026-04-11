package com.example.real_estate_company.mahhi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CompanysummaryController implements Initializable {

    @FXML
    private TextField totalprojectTF;
    @FXML
    private TextField totalpropertiesTF;
    @FXML
    private TextField totalemployeesTF;
    @FXML
    private TextField bussinessstatusTF;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Make fields read-only
        totalprojectTF.setEditable(false);
        totalpropertiesTF.setEditable(false);
        totalemployeesTF.setEditable(false);
        bussinessstatusTF.setEditable(false);

        // Call the method to load data from the .bin file
        loadBusinessDataFromFile();
    }

    private void loadBusinessDataFromFile() {
        File f = new File("CompanyData.bin");

        // Check if the file exists before trying to read it
        if (f.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {

                // Read the object from the file and cast it to CompanyData
                CompanyData loadedData = (CompanyData) ois.readObject();

                // Set the text fields using the getters from the loaded object
                totalprojectTF.setText(loadedData.getTotalProjects());
                totalpropertiesTF.setText(loadedData.getTotalProperties());
                totalemployeesTF.setText(loadedData.getTotalEmployees());
                bussinessstatusTF.setText(loadedData.getBusinessStatus());

            } catch (Exception e) {
                e.printStackTrace();
                bussinessstatusTF.setText("Error reading file!");
            }
        } else {
            // If the user forgot to run SetupDummyData.java first
            totalprojectTF.setText("File Not Found");
            bussinessstatusTF.setText("Please run SetupDummyData first.");
        }
    }

    @FXML
    public void backToDashboardOnAction(ActionEvent actionEvent) {
        try {
            // Points back to your main MD dashboard
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard-view.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Managing Director Dashboard");
            stage.show();
        } catch (IOException e) {
            System.out.println("Error: Could not load ManagingDirectorDashboard.fxml");
            e.printStackTrace();
        }
    }
}