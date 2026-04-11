package com.example.real_estate_company.JakiaJumana;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ProjectViewController
{
    @javafx.fxml.FXML
    private TextField filterPriceTextfiled;
    @javafx.fxml.FXML
    private ComboBox <String>availabilityCombobox;
    @javafx.fxml.FXML
    private TextField priceTextfield;
    @javafx.fxml.FXML
    private TableColumn <Project, String>locationTableview;
    @javafx.fxml.FXML
    private AnchorPane nameTextField;
    @javafx.fxml.FXML
    private TableColumn <Project, Integer>priceTableview;
    @javafx.fxml.FXML
    private ComboBox <String>locationCombobox;
    @javafx.fxml.FXML
    private TableColumn<Project, Integer> availabilityEndTableview;
    @javafx.fxml.FXML
    private Button handleCreatePackage;
    @javafx.fxml.FXML
    private Text errorText;
    @javafx.fxml.FXML
    private TableColumn<Project, String> availabilityTableview;
    @javafx.fxml.FXML
    private TableView<Project> projectTableView;
    @javafx.fxml.FXML
    private Button bestProjectButton;
    @javafx.fxml.FXML
    private TextField availabilityEndTextfield;
    @javafx.fxml.FXML
    private TableColumn<Project, String> nameTableview;
    @javafx.fxml.FXML
    private Button handleFilterButton;
    @javafx.fxml.FXML
    private Text bestProjectText;
    @javafx.fxml.FXML
    private Button resetFilterButton;
    @javafx.fxml.FXML
    private ComboBox <String>filterLocationCombobox;
    private ArrayList<Project> projects = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        locationTableview.setCellValueFactory(new PropertyValueFactory<>("location"));
        nameTableview.setCellValueFactory(new PropertyValueFactory<>("ProjectName"));
        availabilityEndTableview.setCellValueFactory(new PropertyValueFactory<>("availabilityEnds"));
        availabilityTableview.setCellValueFactory(new PropertyValueFactory<>("availability"));
        priceTableview.setCellValueFactory(new PropertyValueFactory<>("price"));

        locationCombobox.getItems().addAll("Recidential", "Commercial", "Industrial");
        availabilityCombobox.getItems().addAll("Large-Scale Investment", "Small-Scale Investment","Specialized");
        filterLocationCombobox.getItems().addAll("Recidential", "Commercial", "Industrial");



    }

    @javafx.fxml.FXML
    public void filterO(ActionEvent actionEvent) {
    }
}