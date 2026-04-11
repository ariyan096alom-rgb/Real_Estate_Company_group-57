package com.example.real_estate_company.KaziTahmidAbtahi.Client;

import com.example.real_estate_company.Helper;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SubmitBookingRequestController {

    @javafx.fxml.FXML
    private ComboBox<String> paymentPlanCB;
    @javafx.fxml.FXML
    private TextField installmentDetailsTF;
    @javafx.fxml.FXML
    private Label feedbackLabel;

    private Property currentProperty;

    @javafx.fxml.FXML
    public void initialize() {
        // Event 5: Setup Payment Options
        paymentPlanCB.getItems().addAll("Full Payment", "12-Month Installment Plan");
        installmentDetailsTF.setEditable(false);
    }

    public void initData(Property property) {
        this.currentProperty = property;
        // Event 5: Show Property Name and Price
        feedbackLabel.setText("Property: " + property.getPropertyName() + " | Price: $" + property.getPrice());
    }

    @javafx.fxml.FXML
    public void showPaymentDetailsONAction(ActionEvent actionEvent) {
        String selectedPlan = paymentPlanCB.getValue();
        if (selectedPlan == null) {
            Helper.showAlert("Error", "Please select a payment plan first.");
            return;
        }

        // Event 6: Logic for calculating and displaying the plan
        if (selectedPlan.equals("Full Payment")) {
            installmentDetailsTF.setText("Total Due: $" + currentProperty.getPrice());
        } else if (selectedPlan.equals("12-Month Installment Plan")) {
            double monthly = currentProperty.getPrice() / 12.0;
            installmentDetailsTF.setText(String.format("12 Monthly Installments of: $%.2f", monthly));
        }
    }

    @javafx.fxml.FXML
    public void confirmBookingButtonOnAction(ActionEvent actionEvent) {
        String selectedPlan = paymentPlanCB.getValue();
        if (selectedPlan == null) {
            Helper.showAlert("Validation Error", "Please select a payment plan.");
            return;
        }

        // Event 8: Create Booking object
        String refNum = "BOOK-" + (int)(Math.random() * 1000000);
        BookingRequest newBooking = new BookingRequest(
                refNum, currentProperty.getPropertyId(), currentProperty.getPropertyName(),
                selectedPlan, currentProperty.getPrice(), "Pending"
        );

        try {
            // Save booking to binary file
            Helper.writeInto("BookingRequests.bin", newBooking);

            // Event 9: Update property status and SAVE to file
            updatePropertyStatusInSystem();

            // Event 10: Show confirmation with reference number
            Helper.showAlert("Booking Confirmed",
                    "Success! Your booking reference number is: " + refNum);

            Helper.backToClientDashboard(actionEvent);

        } catch (IOException e) {
            Helper.showAlert("System Error", "Could not process booking request.");
        }
    }

    private void updatePropertyStatusInSystem() {
        ArrayList<Property> allProperties = new ArrayList<>();
        try {
            // Event 9 logic: Load, Update, and REWRITE the file
            Helper.loadFrom("PropertyData.bin", allProperties);

            for (Property p : allProperties) {
                if (p.getPropertyId() == currentProperty.getPropertyId()) {
                    p.setStatus("Pending Approval");
                    break;
                }
            }

            // Overwrite the file with updated data
            File f = new File("PropertyData.bin");
            if (f.exists()) f.delete();

            for (Property p : allProperties) {
                Helper.writeInto("PropertyData.bin", p);
            }
        } catch (Exception e) {
            System.out.println("Error updating property file: " + e.getMessage());
        }
    }
}