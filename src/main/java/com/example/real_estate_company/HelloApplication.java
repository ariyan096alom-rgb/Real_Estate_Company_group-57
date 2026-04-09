package com.example.real_estate_company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // This assumes Login.fxml is now directly in com/example/real_estate_company/
        String fxmlPath = "Login.fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlPath));

        if (fxmlLoader.getLocation() == null) {
            System.err.println("Error: Could not find Login.fxml in the authorized package.");
            return;
        }

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Real Estate System - Login");
        stage.setScene(scene);
        stage.show();
    }

}


