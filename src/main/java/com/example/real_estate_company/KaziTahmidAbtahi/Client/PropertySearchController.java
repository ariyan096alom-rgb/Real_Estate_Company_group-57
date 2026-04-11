package com.example.real_estate_company.KaziTahmidAbtahi.Client;

import com.example.real_estate_company.Helper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;

public class PropertySearchController {

    @javafx.fxml.FXML
    private ComboBox<String> locationCB;
    @javafx.fxml.FXML
    private ComboBox<String> propertyTypeCB;
    @javafx.fxml.FXML
    private TextField maxPriceTF;
    @javafx.fxml.FXML
    private TableView<Property> propertyDataTableView;
    @javafx.fxml.FXML
    private TableColumn<Property, Integer> propertyIdTC;
    @javafx.fxml.FXML
    private TableColumn<Property, String> propertyNameTC;
    @javafx.fxml.FXML
    private TableColumn<Property, String> propertyLocationTC;
    @javafx.fxml.FXML
    private TableColumn<Property, Double> propertyPriceTC;
    @javafx.fxml.FXML
    private TableColumn<Property, Double> propertySizeTC;
    @javafx.fxml.FXML
    private TableColumn<Property, Integer> propertyBedroomsTC;
    @javafx.fxml.FXML
    private TableColumn<Property, String> propertyStatusTC;

    private ArrayList<Property> allProperties = new ArrayList<>();
    private ObservableList<Property> displayedProperties = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        // Goal-2, Event-4: Setup Filter Options
        locationCB.getItems().addAll("Any", "Gulshan", "Banani", "Dhanmondi", "Uttara", "Bashundhara", "Mirpur", "Mohammadpur");
        propertyTypeCB.getItems().addAll("Any", "Apartment", "House", "Commercial");

        locationCB.setValue("Any");
        propertyTypeCB.setValue("Any");

        // Goal-2, Event-7: Display Property List Details
        propertyIdTC.setCellValueFactory(new PropertyValueFactory<>("propertyId"));
        propertyNameTC.setCellValueFactory(new PropertyValueFactory<>("propertyName"));
        propertyLocationTC.setCellValueFactory(new PropertyValueFactory<>("location"));
        propertyPriceTC.setCellValueFactory(new PropertyValueFactory<>("price"));
        propertySizeTC.setCellValueFactory(new PropertyValueFactory<>("sizeSqFt"));
        propertyBedroomsTC.setCellValueFactory(new PropertyValueFactory<>("bedrooms"));
        propertyStatusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Load actual data from the binary file (will be empty until a manager adds some)
        loadAllProperties();
    }

    private void loadAllProperties() {
        allProperties.clear();
        try {
            // Fetch initial properties from file
            Helper.loadFrom("PropertyData.bin", allProperties);
            displayedProperties.setAll(allProperties);
            propertyDataTableView.setItems(displayedProperties);
        } catch (IOException e) {
            System.out.println("No properties found in system yet.");
        }
    }

    @javafx.fxml.FXML
    public void filterPropertiesButtonOnAction(ActionEvent actionEvent) {
        String maxPriceStr = maxPriceTF.getText();
        String selectedLocation = locationCB.getValue();
        String selectedType = propertyTypeCB.getValue();

        // Goal-2, Event-5: Validate filter inputs
        double maxPrice = Double.MAX_VALUE; // Default if left empty
        if (!maxPriceStr.isEmpty()) {
            try {
                maxPrice = Double.parseDouble(maxPriceStr);
                if (maxPrice <= 0) {
                    Helper.showAlert("Validation Error", "Maximum price must be a positive number.");
                    return;
                }
            } catch (NumberFormatException e) {
                Helper.showAlert("Validation Error", "Please enter a valid number for price.");
                return;
            }
        }

        if (selectedLocation == null || selectedType == null) {
            Helper.showAlert("Validation Error", "Please ensure Location and Type are selected.");
            return;
        }

        // Goal-2, Event-6: Fetch properties matching filter criteria
        ArrayList<Property> filteredList = new ArrayList<>();
        for (Property p : allProperties) {
            boolean matchesPrice = p.getPrice() <= maxPrice;
            boolean matchesLocation = selectedLocation.equals("Any") || p.getLocation().equals(selectedLocation);
            boolean matchesType = selectedType.equals("Any") || p.getPropertyType().equals(selectedType);

            if (matchesPrice && matchesLocation && matchesType) {
                filteredList.add(p);
            }
        }

        // Update TableView
        displayedProperties.setAll(filteredList);
    }

    @javafx.fxml.FXML
    public void showPropertyDetailsButtonOnAction(ActionEvent actionEvent) {
        // 1. Get the selected property from the table
        Property selectedProperty = propertyDataTableView.getSelectionModel().getSelectedItem();

        // 2. Validate that the user actually clicked on a row
        if (selectedProperty == null) {
            Helper.showAlert("Selection Error", "Please select a property from the table first.");
            return;
        }

        // 3. Load the Property Details scene and pass the data
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/com/example/real_estate_company/KaziTahmidAbtahi/Client/PropertyDetails.fxml"));
            javafx.scene.Scene scene = new javafx.scene.Scene(loader.load());

            // 4. Get the controller and send the selected property!
            PropertyDetailsController controller = loader.getController();
            controller.initData(selectedProperty);

            // 5. Switch the scene
            Helper.setScene(actionEvent, scene);
        } catch (IOException e) {
            e.printStackTrace();
            Helper.showAlert("Error", "Could not load the Property Details screen.");
        }
    }

    @javafx.fxml.FXML
    public void goBackToDashboardButtonOnAction(ActionEvent actionEvent) {
        try {
            Helper.backToClientDashboard(actionEvent);
        } catch (IOException e) {
            // Print to console for you (the developer) to debug
            e.printStackTrace();
            // Show a popup to the user so they aren't confused
            Helper.showAlert("Navigation Error", "Sorry, could not load the dashboard.");
        }
    }
}