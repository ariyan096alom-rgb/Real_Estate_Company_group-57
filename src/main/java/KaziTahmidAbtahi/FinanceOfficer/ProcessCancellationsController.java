package KaziTahmidAbtahi.FinanceOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ProcessCancellationsController
{
    @javafx.fxml.FXML
    private TextField daysSinceBookingTF;
    @javafx.fxml.FXML
    private TextField totalPaidTF;
    @javafx.fxml.FXML
    private Label feedbackLabel;
    @javafx.fxml.FXML
    private TextField refundAmountTF;
    @javafx.fxml.FXML
    private TextArea reasonTextArea;
    @javafx.fxml.FXML
    private ComboBox cancellationRequestCB;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void rejectCancellationButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void approveCancellationButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void calculateRefundButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewRequestDetailsOnAction(ActionEvent actionEvent) {
    }
}