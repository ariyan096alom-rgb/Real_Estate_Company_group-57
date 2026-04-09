package com.example.real_estate_company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Use the relative path starting from / (which represents the resources folder)
        // Make sure the path below matches your folder names exactly!
        String fxmlPath = "/com/example/real_estate_company/KaziTahmidAbtahi/Main/Login.fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlPath));

        if (fxmlLoader.getLocation() == null) {
            System.err.println("Error: Could not find FXML file at " + fxmlPath);
            return;
        }

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Real Estate System - Login");
        stage.setScene(scene);
        stage.show();
    }
}


