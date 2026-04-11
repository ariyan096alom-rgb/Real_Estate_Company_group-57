package com.example.real_estate_company.KaziTahmidAbtahi.Client;

import com.example.real_estate_company.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class PropertyDetailsController {

    @javafx.fxml.FXML private Label propertyDetailsLabel, propertyPriceLabel;

    private Property currentProperty;

    @javafx.fxml.FXML
    public void initialize() {
    }

    public void initData(Property property) {
        this.currentProperty = property;

        String summary = "Welcome to '" + property.getPropertyName() + "'!\n" +
                "This is a beautiful " + property.getBedrooms() + "-bedroom " + property.getPropertyType() +
                " located in " + property.getLocation() + ".\n\n" +
                "Size: " + property.getSizeSqFt() + " sq ft\n" +
                "Status: " + property.getStatus() + "\n" +
                "Property ID: " + property.getPropertyId();

        propertyDetailsLabel.setText(summary);

        propertyPriceLabel.setText(property.getPrice() + "");
    }

    @javafx.fxml.FXML
    public void scheduleSiteVisitButtonOnAction(ActionEvent actionEvent) {
        if (currentProperty == null) {
            Helper.showAlert("Error", "No property found.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/real_estate_company/KaziTahmidAbtahi/Client/ScheduleVisit.fxml"));
            Scene scene = new Scene(loader.load());

            ScheduleVisitController controller = loader.getController();
            controller.initData(currentProperty);

            Helper.setScene(actionEvent, scene);
        }

        catch (Exception e) {
            Helper.showAlert("Error", "Could not load the visit schedule screen.");
        }

    }

    @javafx.fxml.FXML
    public void submitBookingRequestButtonOnAction(ActionEvent actionEvent) {
        if (currentProperty == null) {
            Helper.showAlert("Error", "No property found.");
            return;
        }

        String currentStatus = currentProperty.getStatus().toLowerCase();
        if (!currentStatus.equals("available")) {
            Helper.showAlert("Unavailable", "This property is " + currentProperty.getStatus() + ".");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/real_estate_company/KaziTahmidAbtahi/Client/SubmitBookingRequest.fxml"));
            Scene scene = new Scene(loader.load());

            SubmitBookingRequestController controller = loader.getController();
            controller.initData(currentProperty);

            Helper.setScene(actionEvent, scene);
        }


        catch (Exception e) {
            Helper.showAlert("Error", "Could not load the booking screen.");
        }
    }

    @javafx.fxml.FXML
    public void goBackToAvailablePropertiesButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/real_estate_company/KaziTahmidAbtahi/Client/PropertySearch.fxml"));
            Scene scene = new Scene(loader.load());
            Helper.setScene(actionEvent, scene);
        }

        catch (Exception e) {
            Helper.showAlert("Error", "Could not return to property search.");

        }


    }
}