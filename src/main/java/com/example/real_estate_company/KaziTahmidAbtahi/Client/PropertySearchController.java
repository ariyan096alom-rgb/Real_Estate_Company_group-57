package com.example.real_estate_company.KaziTahmidAbtahi.Client;

import com.example.real_estate_company.Helper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class PropertySearchController {

    @javafx.fxml.FXML private ComboBox<String> locationCB, propertyTypeCB;
    @javafx.fxml.FXML private TextField maxPriceTF;
    @javafx.fxml.FXML private TableView<Property> propertyDataTableView;
    @javafx.fxml.FXML private TableColumn<Property, Integer> propertyIdTC;
    @javafx.fxml.FXML private TableColumn<Property, String> propertyNameTC, propertyLocationTC, propertyStatusTC;
    @javafx.fxml.FXML private TableColumn<Property, Double> propertyPriceTC, propertySizeTC;
    @javafx.fxml.FXML private TableColumn<Property, Integer> propertyBedroomsTC;

    private ArrayList<Property> allProperties = new ArrayList<>();
    private ObservableList<Property> displayedProperties = FXCollections.observableArrayList();

    ArrayList<Property> filtered = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

        locationCB.getItems().addAll("Any", "Gulshan", "Banani", "Dhanmondi", "Uttara", "Bashundhara", "Mirpur", "Mohammadpur");
        propertyTypeCB.getItems().addAll("Any", "Apartment", "House", "Commercial");
        locationCB.setValue("Any");
        propertyTypeCB.setValue("Any");


        propertyIdTC.setCellValueFactory(new PropertyValueFactory<>("propertyId"));
        propertyNameTC.setCellValueFactory(new PropertyValueFactory<>("propertyName"));
        propertyLocationTC.setCellValueFactory(new PropertyValueFactory<>("location"));
        propertyPriceTC.setCellValueFactory(new PropertyValueFactory<>("price"));
        propertySizeTC.setCellValueFactory(new PropertyValueFactory<>("sizeSqFt"));
        propertyBedroomsTC.setCellValueFactory(new PropertyValueFactory<>("bedrooms"));
        propertyStatusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadAllProperties();
    }

    private void loadAllProperties() {
        allProperties.clear();
        try {
            Helper.loadFrom("PropertyData.bin", allProperties);
            displayedProperties.setAll(allProperties);
            propertyDataTableView.setItems(displayedProperties);

        }

        catch (Exception e) {
            System.out.println("No property file found yet.");


        }

    }

    @javafx.fxml.FXML
    public void filterPropertiesButtonOnAction(ActionEvent actionEvent) {

        String loc = locationCB.getValue();
        String type = propertyTypeCB.getValue();
        String priceText = maxPriceTF.getText();

        ArrayList<Property> filteredResults = new ArrayList<>();

        for (Property p : allProperties) {
            boolean locMatch = loc.equals("Any") || loc.equals(p.getLocation());
            boolean typeMatch = type.equals("Any") || type.equals(p.getPropertyType());

            boolean priceMatch = true;

            if (!priceText.isEmpty()) {
                try {
                    double limit = Double.parseDouble(priceText);
                    priceMatch = p.getPrice() <= limit;
                }

                catch (Exception e) {
                    Helper.showAlert("Invalid Input", "Please enter a valid number for the price.");
                    return;
                }

            }

            if (locMatch && typeMatch && priceMatch) {
                filteredResults.add(p);
            }

        }
        displayedProperties.setAll(filteredResults);
    }

    @javafx.fxml.FXML
    public void showPropertyDetailsButtonOnAction(ActionEvent actionEvent) {
        Property selected = propertyDataTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            Helper.showAlert("Selection Required", "Please select a property from the list.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/real_estate_company/KaziTahmidAbtahi/Client/PropertyDetails.fxml"));
            Scene scene = new Scene(loader.load());
            PropertyDetailsController controller = loader.getController();
            controller.initData(selected);
            Helper.setScene(actionEvent, scene);
        }

        catch (Exception e) {
            Helper.showAlert("Error", "Could not load property details.");


        }

    }

    @javafx.fxml.FXML
    public void goBackToDashboardButtonOnAction(ActionEvent actionEvent) {
        try {
            Helper.backToClientDashboard(actionEvent);
        }

        catch (Exception e) {
            Helper.showAlert("Error", "Could not return to Dashboard.");

        }
    }


}