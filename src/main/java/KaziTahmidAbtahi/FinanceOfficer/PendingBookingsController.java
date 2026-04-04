package KaziTahmidAbtahi.FinanceOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PendingBookingsController
{
    @javafx.fxml.FXML
    private TableColumn clientNameTC;
    @javafx.fxml.FXML
    private TableColumn docStatusTC;
    @javafx.fxml.FXML
    private TableView pendingBookingsTableView;
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private TableColumn propertyNameTC;
    @javafx.fxml.FXML
    private TableColumn paymentPlanTC;
    @javafx.fxml.FXML
    private ComboBox paymentPlanFilterCB;
    @javafx.fxml.FXML
    private TableColumn bookingIdTC;
    @javafx.fxml.FXML
    private TableColumn requestDateTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void filterBookingsButtonOnAction(ActionEvent actionEvent) {
    }
}