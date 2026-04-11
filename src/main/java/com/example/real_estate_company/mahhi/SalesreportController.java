package com.example.real_estate_company.mahhi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class SalesreportController {

    @FXML private ComboBox<String> timeRangeComboBox;
    @FXML private Label totalRevenueLabel;
    @FXML private Label unitsSoldLabel;
    @FXML private Label statusMessageLabel;

    @FXML
    public void initialize() {
        timeRangeComboBox.getItems().addAll("Monthly", "Yearly");
    }

    @FXML
    public void generateReportOnAction(ActionEvent event) {
        String selected = timeRangeComboBox.getValue();

        // Handle Event-6: Validation
        if (selected == null) {
            statusMessageLabel.setText("Invalid time period! Please select one.");
            statusMessageLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        // Simulating the "Fetch and Calculate" logic (Event-4)
        SalesReport report;
        if (selected.equals("Monthly")) {
            report = new SalesReport("BDT 4,500,000", "12 Units");
        } else {
            report = new SalesReport("BDT 52,000,000", "145 Units");
        }

        // Update UI (Event-5)
        statusMessageLabel.setText("Data fetched successfully.");
        statusMessageLabel.setStyle("-fx-text-fill: green;");
        totalRevenueLabel.setText(report.getRevenue());
        unitsSoldLabel.setText(report.getUnits() + " Sold");
    }

    @FXML
    public void backToDashboardOnAction(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard-vire.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}