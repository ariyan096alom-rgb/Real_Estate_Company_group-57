package com.example.real_estate_company.KaziTahmidAbtahi.Client;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class MakePaymentsController
{
    @javafx.fxml.FXML
    private TableColumn dueDateTC;
    @javafx.fxml.FXML
    private DatePicker paymentDateDatePicker;
    @javafx.fxml.FXML
    private ComboBox paymentMethodCB;
    @javafx.fxml.FXML
    private TableColumn dueAmountTC;
    @javafx.fxml.FXML
    private TextField paymentAmountTF;
    @javafx.fxml.FXML
    private TableColumn paymentTypeTC;
    @javafx.fxml.FXML
    private TextField transactionReferenceTF;
    @javafx.fxml.FXML
    private Label feedbackLabel;
    @javafx.fxml.FXML
    private TableView paymentsTableView;
    @javafx.fxml.FXML
    private TableColumn paymentStatusTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submitPaymentButtonOnAction(ActionEvent actionEvent) {
    }
}