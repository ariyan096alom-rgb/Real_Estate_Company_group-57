package KaziTahmidAbtahi.Client;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PropertySearchController
{
    @javafx.fxml.FXML
    private TableColumn propertySizeTC;
    @javafx.fxml.FXML
    private TextField maxPriceTF;
    @javafx.fxml.FXML
    private ComboBox minBedroomsCB;
    @javafx.fxml.FXML
    private TableColumn propertyLocationTC;
    @javafx.fxml.FXML
    private TableColumn propertyNameTC;
    @javafx.fxml.FXML
    private TableColumn propertyIdTC;
    @javafx.fxml.FXML
    private ComboBox sortingFilterCB;
    @javafx.fxml.FXML
    private TableColumn propertyBedroomsTC;
    @javafx.fxml.FXML
    private ComboBox locationCB;
    @javafx.fxml.FXML
    private TableColumn propertyStatusTC;
    @javafx.fxml.FXML
    private ComboBox propertyTypeCB;
    @javafx.fxml.FXML
    private TableColumn propertyPriceTC;
    @javafx.fxml.FXML
    private TableView propertyDataTableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void filterPropertiesButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void showPropertyDetailsButtonOnAction(ActionEvent actionEvent) {
    }
}