package KaziTahmidAbtahi.FinanceOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class InvoiceGenerationController
{
    @javafx.fxml.FXML
    private TextArea calculationSummaryTextArea;
    @javafx.fxml.FXML
    private TextField downPaymentPercentTF;
    @javafx.fxml.FXML
    private TextField installmentsTF;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private ComboBox approvedBookingCB;
    @javafx.fxml.FXML
    private Label feedbackLabel;
    @javafx.fxml.FXML
    private ComboBox frequencyCB;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void generateInvoiceButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void calculateAmountsButtonOnAction(ActionEvent actionEvent) {
    }
}