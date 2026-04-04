package KaziTahmidAbtahi.Client;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MyBookingsController
{
    @javafx.fxml.FXML
    private TableColumn bookingDateTC;
    @javafx.fxml.FXML
    private TableView bookingsTableView;
    @javafx.fxml.FXML
    private TableColumn propertyNameTC;
    @javafx.fxml.FXML
    private TableColumn statusTC;
    @javafx.fxml.FXML
    private Label feedbackLabel;
    @javafx.fxml.FXML
    private TableColumn bookingIdTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void provideDocsButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void provideDocumentInformationButtonOnAction(ActionEvent actionEvent) {
    }
}