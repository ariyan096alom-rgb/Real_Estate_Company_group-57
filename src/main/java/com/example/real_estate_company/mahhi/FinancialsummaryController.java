package com.example.real_estate_company.mahhi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;

public class FinancialsummaryController {

    @FXML private PieChart incomeExpenseChart;

    @FXML
    public void loadChartOnAction(ActionEvent event) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("FinancialData.bin"))) {
            FinancialData data = (FinancialData) ois.readObject();

            // Creating the data slices
            PieChart.Data slice1 = new PieChart.Data("Total Income", data.getTotalIncome());
            PieChart.Data slice2 = new PieChart.Data("Total Expense", data.getTotalExpense());

            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(slice1, slice2);
            incomeExpenseChart.setData(pieChartData);

        } catch (Exception e) {
            System.out.println("Error loading chart: " + e.getMessage());
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