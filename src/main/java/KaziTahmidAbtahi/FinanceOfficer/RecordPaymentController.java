package KaziTahmidAbtahi.FinanceOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RecordPaymentController
{
    @javafx.fxml.FXML
    private ComboBox paymentMethodCB;
    @javafx.fxml.FXML
    private ComboBox paymentTypeCB;
    @javafx.fxml.FXML
    private Label feedbackLabel;
    @javafx.fxml.FXML
    private ComboBox clientBookingCB;
    @javafx.fxml.FXML
    private DatePicker paymentDatePicker;
    @javafx.fxml.FXML
    private TextField amountTF;
    @javafx.fxml.FXML
    private TextField transactionRefTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void recordPaymentButtonOnAction(ActionEvent actionEvent) {
    }
}