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

import java.util.ArrayList;

public class FinanceOfficerDashboardController {

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


    private int pendingBookings = 0;
    private int approvedBookings = 0;
    private double totalPendingAmount = 0.0;

    private ObservableList<PieChart.Data> chartData = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        ArrayList<Property> properties = new ArrayList<>();

        try {
            Helper.loadFrom("PropertyData.bin", properties);

            for (Property p : properties) {
                if (p.getStatus().toLowerCase().equals("pending")) {
                    pendingBookings = pendingBookings + 1;
                    totalPendingAmount = totalPendingAmount + p.getPrice();

                }

                else if (p.getStatus().toLowerCase().equals("approved")) {
                    approvedBookings = approvedBookings + 1;

                }
            }

        }

        catch (Exception e) {
            System.out.println("Data missing or file not found.");

        }

        pendingBookingRequestLabel.setText(pendingBookings + "");
        totalPendingPaymentsLabel.setText(totalPendingAmount + " Tk");
        recentPaymentsNotificationsTextArea.setText("Welcome to the Finance Dashboard. You have " + pendingBookings + " pending bookings to review today.");


        chartData.add(new PieChart.Data("Pending", pendingBookings));
        chartData.add(new PieChart.Data("Approved", approvedBookings));
        financeOfficerDashboardPieChart.setData(chartData);

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
        }
        catch (Exception e) {
            Helper.showAlert("Error", "Cannot sign out.");
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

        String filename = "Daily_Finance_Summary.txt";
        String content = " FINANCE DAILY SUMMARY \n" +
                "Pending Bookings: " + pendingBookings + "\n" +
                "Approved Bookings: " + approvedBookings + "\n" +
                "Pending Payments Amount: " + totalPendingAmount + " Tk\n";

        boolean b = Helper.appendTextFile(filename, content);

        if (b) {
            Helper.showAlert("Done", "Summary downloaded Successfuly.");
        } else {
            Helper.showAlert("Error", "Download failed.");
        }
    }
}