module com.example.real_estate_company {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.example.real_estate_company to javafx.fxml;
    exports com.example.real_estate_company;

    opens com.example.real_estate_company.mahhi to javafx.fxml;
    exports com.example.real_estate_company.mahhi;

    opens com.example.real_estate_company.KaziTahmidAbtahi.Client to javafx.fxml;
    exports com.example.real_estate_company.KaziTahmidAbtahi.Client;

    opens com.example.real_estate_company.KaziTahmidAbtahi.FinanceOfficer to javafx.fxml;

    exports com.example.real_estate_company.ZayedBinZaman.SiteEngineer;
    opens com.example.real_estate_company.ZayedBinZaman.SiteEngineer to javafx.fxml;
}