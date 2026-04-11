package com.example.real_estate_company.mahhi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;

public class ProjectprogressController {

    @FXML private TableView<ProjectData> projectTable;
    @FXML private TableColumn<ProjectData, String> nameColumn;
    @FXML private TableColumn<ProjectData, String> deadlineColumn;
    @FXML private ProgressBar taskProgressBar;
    @FXML private Label percentageLabel;

    @FXML
    public void initialize() {
        // Link Table Columns to Project Model variables
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("projectName"));
        deadlineColumn.setCellValueFactory(new PropertyValueFactory<>("deadline"));

        // Listener: This detects when you click a row in the table
        projectTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Update the progress bar (0.0 to 1.0)
                taskProgressBar.setProgress(newSelection.getProgress());
                // Update the label (e.g., 0.75 becomes 75%)
                percentageLabel.setText((int)(newSelection.getProgress() * 100) + "% Complete");
            }
        });
    }

    @FXML
    public void loadProjectsOnAction(ActionEvent event) {
        ObservableList<ProjectData> list = FXCollections.observableArrayList();

        // Read from the binary file created by DummyDataGenerator
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ProjectData.bin"))) {
            while (true) {
                try {
                    ProjectData p = (ProjectData) ois.readObject();
                    list.add(p);
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
            projectTable.setItems(list);
            System.out.println("Project data loaded successfully.");

        } catch (Exception e) {
            System.out.println("Error reading ProjectData.bin: " + e.getMessage());
        }
    }

    @FXML
    public void backToDashboardOnAction(ActionEvent event) {
        try {
            // Navigate back to the main dashboard
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard-view.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Managing Director Dashboard");
            stage.show();
        } catch (IOException e) {
            System.out.println("Error: Could not load ManagingDirectorDashboard.fxml");
            e.printStackTrace();
        }
    }
}