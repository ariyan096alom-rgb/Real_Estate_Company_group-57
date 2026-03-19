module com.example.real_estate_company {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.real_estate_company to javafx.fxml;
    exports com.example.real_estate_company;
}