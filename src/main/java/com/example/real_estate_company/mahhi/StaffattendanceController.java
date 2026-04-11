package com.example.real_estate_company.mahhi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class StaffattendanceController
{
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private TableColumn<AttendanceRecord, String> nameColumn;
    @javafx.fxml.FXML
    private TableColumn<AttendanceRecord, String> statusColumn;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private TableColumn<AttendanceRecord, String> dateColumn;
    @javafx.fxml.FXML
    private TableView<AttendanceRecord> attendanceTable;

    @javafx.fxml.FXML
    public void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @javafx.fxml.FXML
    public void loadAttendanceOnAction(ActionEvent actionEvent) {
        ObservableList<AttendanceRecord> attendanceList = FXCollections.observableArrayList();

        // 2. Open the .bin file and read objects
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("AttendanceData.bin"))) {
            while (true) {
                try {
                    AttendanceRecord record = (AttendanceRecord) ois.readObject();
                    attendanceList.add(record);
                } catch (Exception e) {
                    // This break happens when we reach the end of the file
                    break;
                }
            }
            // 3. Push the list into the TableView
            attendanceTable.setItems(attendanceList);
            System.out.println("Data loaded into table successfully!");

        } catch (Exception e) {
            System.out.println("Error reading AttendanceData.bin: " + e.getMessage());
        }
    }
}