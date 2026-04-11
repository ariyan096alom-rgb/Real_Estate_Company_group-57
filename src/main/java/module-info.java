
module com.example.real_estate_company {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.example.real_estate_company to javafx.fxml;
    exports com.example.real_estate_company;
    opens com.example.real_estate_company.mahhi to javafx.fxml;

    opens com.example.real_estate_company.KaziTahmidAbtahi.Client to javafx.fxml;
    exports com.example.real_estate_company.KaziTahmidAbtahi.Client;
<<<<<<< HEAD
    exports com.example.real_estate_company.mahhi;
=======
<<<<<<< HEAD
    exports com.example.real_estate_company.ZayedBinZaman.SiteEngineer;
    opens com.example.real_estate_company.ZayedBinZaman.SiteEngineer to javafx.fxml;
=======

    opens com.example.real_estate_company.KaziTahmidAbtahi.FinanceOfficer to javafx.fxml;
>>>>>>> d7f721ad95d51be02c4162efa3c52b660deb50f2
>>>>>>> 2ac478c33a71ad8835db5eeb1a29b32355017c94
}