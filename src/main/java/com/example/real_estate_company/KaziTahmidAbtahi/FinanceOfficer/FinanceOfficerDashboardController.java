package com.example.real_estate_company.KaziTahmidAbtahi.FinanceOfficer;

import com.example.real_estate_company.Helper;
import com.example.real_estate_company.KaziTahmidAbtahi.Client.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


import java.io.IOException;
import java.util.ArrayList;

public class FinanceOfficerDashboardController
{
    @javafx.fxml.FXML
    private BorderPane mainBorderPane;
    @javafx.fxml.FXML
    private AnchorPane homeAnchorPane;
    @javafx.fxml.FXML
    private TextArea recentPaymentsNotificationsTextArea;
    @javafx.fxml.FXML
    private Label totalPendingPaymentsLabel;
    @javafx.fxml.FXML
    private Label pendingBookingRequestLabel;
    @javafx.fxml.FXML
    private PieChart financeOfficerDashboardPieChart;

    private ObservableList<PieChart.Data> pieChartList = FXCollections.observableArrayList();
    private int pendingBookings = 0;
    private int approvedBookings = 0;
    private double totalPendingAmount = 0.0;

    @javafx.fxml.FXML
    public void initialize() {
        // Event 3: Fetch and calculate dashboard summary data using Helper
        ArrayList<Property> propertyList = new ArrayList<>();

        try {
            // Replaced messy FileInputStream logic with your Helper method!
            Helper.loadFrom("PropertyData.bin", propertyList);

            for (Property p : propertyList) {
                if (p.getStatus().equalsIgnoreCase("Pending")) {
                    pendingBookings++;
                    totalPendingAmount += p.getPrice();
                } else if (p.getStatus().equalsIgnoreCase("Approved")) {
                    approvedBookings++;
                }
            }
        } catch (IOException e) {
            Helper.showAlert("Data Error", "Could not load property data for dashboard calculation.");
        }

        // Event 4: Display text summary
        pendingBookingRequestLabel.setText(Integer.toString(pendingBookings));
        totalPendingPaymentsLabel.setText("$" + totalPendingAmount);
        recentPaymentsNotificationsTextArea.setText("System updated from PropertyData.bin successfully.\nNew pending payments calculated.");

        // Event 4: Visually show bookings using PieChart
        pieChartList.add(new PieChart.Data("Pending Bookings", pendingBookings));
        pieChartList.add(new PieChart.Data("Approved Bookings", approvedBookings));
        financeOfficerDashboardPieChart.setData(pieChartList);
    }

    @javafx.fxml.FXML
    public void generateInvoiceButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void paymentRecordsButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void reportsButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void processCancellationsButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML

    public void signOutButtonOnAction(ActionEvent actionEvent) {
        try {
            Helper.logOut(actionEvent);
        } catch (Exception e) {
            e.printStackTrace();
            Helper.showAlert("Error", "Could not sign out.");
        }
    }

    @javafx.fxml.FXML
    public void verifyDocumentsButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void approveRejectButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void pendingBookingsButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void DailySummaryButtonOnAction(ActionEvent actionEvent) {
        // Event 6 & 7: Generate and export summary as .txt
        String filename = "Daily_Finance_Summary.txt";

        String content = "=== FINANCE OFFICER DAILY SUMMARY ===\n" +
                "Total Pending Bookings: " + pendingBookings + "\n" +
                "Total Approved Bookings: " + approvedBookings + "\n" +
                "Total Pending Payments Amount: $" + totalPendingAmount + "\n" +
                "=====================================";

        boolean isSuccess = Helper.appendTextFile(filename, content);

        // Event 8: Display confirmation message
        if (isSuccess) {
            Helper.showAlert("Download Complete", "Summary downloaded successfully to " + filename);
        }

    }
}