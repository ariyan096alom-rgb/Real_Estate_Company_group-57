package KaziTahmidAbtahi.FinanceOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ManageBookingsController
{
    @javafx.fxml.FXML
    private TableColumn clientNameTC;
    @javafx.fxml.FXML
    private TableColumn docStatusTC;
    @javafx.fxml.FXML
    private DatePicker filterStartDatePicker;
    @javafx.fxml.FXML
    private TableView pendingBookingsTableView;
    @javafx.fxml.FXML
    private TableColumn propertyNameTC;
    @javafx.fxml.FXML
    private TableColumn paymentPlanTC;
    @javafx.fxml.FXML
    private Label feedbackLabel;
    @javafx.fxml.FXML
    private ComboBox paymentPlanFilterCB;
    @javafx.fxml.FXML
    private DatePicker filterEndDatePicker;
    @javafx.fxml.FXML
    private TableColumn bookingIdTC;
    @javafx.fxml.FXML
    private TableColumn requestDateTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void applyFiltersButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewBookingDetailsButtonOnAction(ActionEvent actionEvent) {
    }
}