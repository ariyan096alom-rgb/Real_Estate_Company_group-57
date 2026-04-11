package com.example.real_estate_company;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Helper {

    public static void showAlert(String title, String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static <T> void writeInto(String fileName, T data) throws IOException {

        File file = new File(fileName);
        FileOutputStream fileOut;
        ObjectOutputStream objOut;

        if (file.exists()) {
            fileOut = new FileOutputStream(file, true);
            objOut = new AppendableObjectOutputStream(fileOut);

        }

        else {
            fileOut = new FileOutputStream(file);
            objOut = new ObjectOutputStream(fileOut);

        }

        objOut.writeObject(data);
        objOut.close();


    }

    public static <T> void loadFrom(String fileName, ArrayList<T> list) throws IOException {
        File file = new File(fileName);

        if (!file.exists()) {
            showAlert("Error", "File missing.");
            return;

        }

        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream objIn = new ObjectInputStream(fileIn);

        try {
            while (true) {
                T obj = (T) objIn.readObject();
                list.add(obj);
            }
        }

        catch (EOFException e) {
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            objIn.close();

        }


    }

    public static boolean appendTextFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content + "\n");
            writer.close();
            return true;
        }

        catch (Exception e) {
            showAlert("Error", "Cannot save text.");
            return false;
        }
    }

    public static void setScene(ActionEvent event, Scene scene) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            showAlert("Error", "Cannot load page.");
        }
    }

    public static void backToClientDashboard(ActionEvent event) throws IOException {
        String path = "/com/example/real_estate_company/KaziTahmidAbtahi/Client/ClientDashboard.fxml";
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(path));
        Scene scene = new Scene(loader.load());
        setScene(event, scene);
    }

    public static void logOut(ActionEvent event) throws IOException {

        String path = "/com/example/real_estate_company/Login.fxml";
        FXMLLoader loader = new FXMLLoader(Helper.class.getResource(path));
        Scene scene = new Scene(loader.load());
        setScene(event, scene);

    }


}