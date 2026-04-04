package KaziTahmidAbtahi.Client;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class ScheduleVisitController
{
    @javafx.fxml.FXML
    private Label feedbackLabel;
    @javafx.fxml.FXML
    private DatePicker visitDatePicker;
    @javafx.fxml.FXML
    private ComboBox timeSlotCB;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void confirmAppointmentOnAction(ActionEvent actionEvent) {
    }
}