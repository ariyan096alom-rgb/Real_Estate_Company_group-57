package com.example.real_estate_company.KaziTahmidAbtahi.Client;

import com.example.real_estate_company.Helper;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class PropertyDetailsController {

    @javafx.fxml.FXML
    private Label propertyDetailsLabel;
    @javafx.fxml.FXML
    private Label propertyPriceLabel;

    // This holds the data passed from the Search screen
    private Property currentProperty;

    @javafx.fxml.FXML
    public void initialize() {
    }

    // This catches the passed data and updates the screen
    public void initData(Property property) {
        this.currentProperty = property;

        String type = property.getPropertyType();
        String location = property.getLocation();
        int beds = property.getBedrooms();
        double size = property.getSizeSqFt();
        int id = property.getPropertyId();
        String status = property.getStatus();

        String summary = "Welcome to '" + property.getPropertyName() + "'! This is a beautiful " +
                beds + "-bedroom " + type + " located in the heart of " + location + ".\n\n" +
                "It offers a spacious " + size + " sq ft of living space. It is currently " + status + ".\n\n" +
                "Property ID: " + id;

        // Put the text into your Labels
        propertyDetailsLabel.setText(summary);
        propertyPriceLabel.setText(String.valueOf(property.getPrice()));
    }

    @javafx.fxml.FXML
    public void scheduleSiteVisitButtonOnAction(ActionEvent actionEvent) {
        // 1. Validate that a property is loaded
        if (currentProperty == null) {
            Helper.showAlert("Error", "No property loaded.");
            return;
        }

        // 2. Load the Schedule Visit screen and pass the data!
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/com/example/real_estate_company/KaziTahmidAbtahi/Client/ScheduleVisit.fxml"));
            javafx.scene.Scene scene = new javafx.scene.Scene(loader.load());

            // Send the data to your new controller
            ScheduleVisitController controller = loader.getController();
            controller.initData(currentProperty);

            Helper.setScene(actionEvent, scene);
        } catch (Exception e) {
            e.printStackTrace();
            Helper.showAlert("Error", "Could not load the Scheduling screen.");
        }
    }


    @javafx.fxml.FXML
    public void submitBookingRequestButtonOnAction(ActionEvent actionEvent) {
        if (currentProperty == null) {
            Helper.showAlert("Error", "No property loaded.");
            return;
        }

        // Event 4: Verify property status is "Available"
        if (!currentProperty.getStatus().equalsIgnoreCase("Available")) {
            Helper.showAlert("Unavailable", "Sorry, this property is currently " + currentProperty.getStatus() + " and cannot be booked.");
            return;
        }

        // Load the Submit Booking screen and pass the data!
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/com/example/real_estate_company/KaziTahmidAbtahi/Client/SubmitBookingRequest.fxml"));
            javafx.scene.Scene scene = new javafx.scene.Scene(loader.load());

            // Send the data to the booking controller
            SubmitBookingRequestController controller = loader.getController();
            controller.initData(currentProperty);

            Helper.setScene(actionEvent, scene);
        } catch (Exception e) {
            e.printStackTrace();
            Helper.showAlert("Error", "Could not load the Booking screen.");
        }
    }



    @javafx.fxml.FXML
    public void goBackToAvailablePropertiesButtonOnAction(ActionEvent actionEvent) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/com/example/real_estate_company/KaziTahmidAbtahi/Client/PropertySearch.fxml"));
            javafx.scene.Scene scene = new javafx.scene.Scene(loader.load());
            Helper.setScene(actionEvent, scene);
        } catch (Exception e) {
            e.printStackTrace();
            Helper.showAlert("Error", "Could not go back to Search screen.");
        }
    }
}