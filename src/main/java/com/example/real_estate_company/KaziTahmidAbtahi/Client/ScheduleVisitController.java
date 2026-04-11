package com.example.real_estate_company.KaziTahmidAbtahi.Client;

import com.example.real_estate_company.Helper;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ScheduleVisitController {

    @javafx.fxml.FXML
    private ComboBox<String> selectTimeCB;
    @javafx.fxml.FXML
    private DatePicker selectDateDatePicker;
    @javafx.fxml.FXML
    private Label propertynNameLabel;

    private Property currentProperty;

    @javafx.fxml.FXML
    public void initialize() {
        selectTimeCB.getItems().addAll("10:00 AM", "11:30 AM", "02:00 PM", "03:30 PM", "05:00 PM");
    }

    public void initData(Property property) {
        this.currentProperty = property;
        propertynNameLabel.setText("Scheduling visit for: " + property.getPropertyName());

    }

    @javafx.fxml.FXML
    public void confirmVisitOnAction(ActionEvent actionEvent) {
        LocalDate selectedDate = selectDateDatePicker.getValue();
        String selectedTime = selectTimeCB.getValue();

        if (selectedDate == null || selectedTime == null) {
            Helper.showAlert("Validation Error", "Please select both a date and a time slot.");
            return;
        }

        if (selectedDate.isBefore(LocalDate.now())) {
            Helper.showAlert("Validation Error", "You cannot schedule a visit in the past. Please select a future date.");
            return;
        }

        ArrayList<VisitSiteAppointment> existingAppointments = new ArrayList<>();

        try {
            Helper.loadFrom("VisitAppointments.bin", existingAppointments);
        }

        catch (Exception e) {
            System.out.println("First appointment! System will create a new file.");
        }

        boolean isSlotTaken = false;
        for (VisitSiteAppointment appointment : existingAppointments) {
            if (appointment.getPropertyId() == currentProperty.getPropertyId() && appointment.getVisitDate().equals(selectedDate) && appointment.getVisitTime().equals(selectedTime)) {
                isSlotTaken = true;
                break;

            }
        }

        if (isSlotTaken) {
            Helper.showAlert("Unavailable", "Selected time slot is not available. Please choose another time.");
            return;
        }

        String confirmationNum = "Visit -" + (int) (Math.random() * 100000);

        VisitSiteAppointment newAppointment = new VisitSiteAppointment(currentProperty.getPropertyId(), currentProperty.getPropertyName(), selectedDate, selectedTime, confirmationNum);

        try {

            Helper.writeInto("VisitAppointments.bin", newAppointment);

            Helper.showAlert("Appointment Confirmed", "Successfully booked!\n\nConfirmation Number: " + confirmationNum + "\nDate: " + selectedDate + "\nTime: " + selectedTime);

            Helper.backToClientDashboard(actionEvent);

        } catch (IOException e) {
            Helper.showAlert("System Error", "Could not save the appointment.");

        }


    }



    @javafx.fxml.FXML
    public void returnToPropertyDetailsButtonOnAction(ActionEvent actionEvent) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/com/example/real_estate_company/KaziTahmidAbtahi/Client/PropertyDetails.fxml"));
            javafx.scene.Scene scene = new javafx.scene.Scene(loader.load());

            // We MUST send the property data back to the details screen!
            PropertyDetailsController controller = loader.getController();
            controller.initData(currentProperty);

            Helper.setScene(actionEvent, scene);
        } catch (Exception e) {
            e.printStackTrace();
            Helper.showAlert("Error", "Could not go back to Property Details.");
        }
    }
}