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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;

public class SalarysummaryController {

    @FXML private ComboBox<String> monthComboBox;
    @FXML private Label totalSalaryLabel;
    @FXML private Label bonusLabel;
    @FXML private Label grandTotalLabel;

    @FXML
    public void initialize() {
        // Optional: Fill the ComboBox with months
        monthComboBox.getItems().addAll("January", "February", "March", "April");
    }

    @FXML
    public void loadSalaryOnAction(ActionEvent event) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SalaryData.bin"))) {
            SalaryData data = (SalaryData) ois.readObject();

            totalSalaryLabel.setText("BDT" + data.getBaseSalary());
            bonusLabel.setText("BDT" + data.getBonus());
            grandTotalLabel.setText("BDT" + data.getGrandTotal());

        } catch (Exception e) {
            System.out.println("Error loading salary data: " + e.getMessage());
        }
    }

    @FXML
    public void backToDashboardOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard-view.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}