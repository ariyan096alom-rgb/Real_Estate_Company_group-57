package com.example.real_estate_company.KaziTahmidAbtahi.Client;

import com.example.real_estate_company.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.File;
import java.util.ArrayList;

public class SubmitBookingRequestController {

    @javafx.fxml.FXML private ComboBox<String> paymentPlanCB;
    @javafx.fxml.FXML private TextField installmentDetailsTF;
    @javafx.fxml.FXML private Label feedbackLabel;

    private Property currentProperty;

    @javafx.fxml.FXML
    public void initialize() {
        paymentPlanCB.getItems().addAll("Full Payment", "12-Month Installment Plan");
    }

    public void initData(Property property) {
        this.currentProperty = property;
        feedbackLabel.setText("Property: " + property.getPropertyName() + " | Price: " + property.getPrice() + " Taka");
    }

    @javafx.fxml.FXML
    public void showPaymentDetailsONAction(ActionEvent actionEvent) {
        String selectedPlan = paymentPlanCB.getValue();
        if (selectedPlan == null) {
            Helper.showAlert("Error", "Please select a payment plan first.");
            return;
        }

        if (selectedPlan.equals("Full Payment")) {
            installmentDetailsTF.setText("Total Due: " + currentProperty.getPrice() + " Taka");
        } else {
            double monthly = currentProperty.getPrice() / 12.0;
            installmentDetailsTF.setText(String.format("12 Monthly Installments of: %.2f Taka", monthly));
        }
    }

    @javafx.fxml.FXML
    public void confirmBookingButtonOnAction(ActionEvent actionEvent) {
        String selectedPlan = paymentPlanCB.getValue();
        if (selectedPlan == null) {
            Helper.showAlert("Error", "Please select a payment plan.");
            return;
        }

        String refNum = "Book-" + (int)(Math.random() * 900000 + 100000);
        BookingRequest newBooking = new BookingRequest(refNum, currentProperty.getPropertyId(), currentProperty.getPropertyName(), selectedPlan, currentProperty.getPrice(), "Pending");

        try {
            Helper.writeInto("BookingRequests.bin", newBooking);
            updatePropertyStatusInSystem();

            Helper.showAlert("Booking Confirmed", "Success! Your reference number is: " + refNum);
            Helper.backToClientDashboard(actionEvent);
        }

        catch (Exception e) {
            Helper.showAlert("Error", "Could not process booking request.");
        }
    }

    private void updatePropertyStatusInSystem() {
        ArrayList<Property> allProperties = new ArrayList<>();
        try {
            Helper.loadFrom("PropertyData.bin", allProperties);

            for (Property p : allProperties) {
                if (p.getPropertyId() == currentProperty.getPropertyId()) {
                    p.setStatus("Pending Approval");
                    break;
                }
            }

            File file = new File("PropertyData.bin");
            if (file.exists()) file.delete();

            for (Property p : allProperties) {
                Helper.writeInto("PropertyData.bin", p);
            }
        }

        catch (Exception e) {
            System.out.println("Status update failed.");

        }
    }

    @javafx.fxml.FXML
    public void returnToPropertyDetailsButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/real_estate_company/KaziTahmidAbtahi/Client/PropertyDetails.fxml"));
            Scene scene = new Scene(loader.load());

            PropertyDetailsController controller = loader.getController();
            controller.initData(currentProperty);

            Helper.setScene(actionEvent, scene);
        }

        catch (Exception e) {
            Helper.showAlert("Error", "Could not return to details.");
        }

    }
}