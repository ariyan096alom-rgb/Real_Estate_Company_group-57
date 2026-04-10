package com.example.real_estate_company;

import com.example.real_estate_company.KaziTahmidAbtahi.Client.AOOStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Helper {

    public static void showAlert(String title) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText(title);
        a.showAndWait();
    }

    public static void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static <T> void writeInto(String binFile, T data) throws IOException {
        File file = new File(binFile);
        FileOutputStream fos;
        ObjectOutputStream oos;

        if (file.exists()) {
            fos = new FileOutputStream(file, true);
            oos = new AOOStream(fos);
        } else {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
        }

        oos.writeObject(data);
        oos.close();
    }

    public static <T> void loadFrom(String binFile, ArrayList<T> lst) throws IOException {
        File file = new File(binFile);

        if (!file.exists()) {
            showAlert("File Error", "File not found");
            return;
        }

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            while (true) {
                T obj = (T) ois.readObject();
                lst.add(obj);
            }
        } catch (EOFException e) {
            System.out.println("We have reached the end of file");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            ois.close();
        }
    }

    public static Object loadFromSingleObject(String fileName) {
        try {
            File file = new File(fileName);

            if (!file.exists()) {
                showAlert("File Error", "File not found");
                return null;
            }

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Object data = ois.readObject();

            ois.close();
            fis.close();

            return data;
        } catch (Exception e) {
            showAlert("File Error", "Could not read from " + fileName);
            return null;
        }
    }

    public static void deleteFile(String binFile) {
        File file = new File(binFile);
        if (!file.exists()) {
            showAlert("File Error", "File not found");
        } else {
            file.delete();
        }
    }

    public static <T> void rewriteFile(String binFile, ArrayList<T> list) throws IOException {
        File file = new File(binFile);
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for (T obj : list) {
            oos.writeObject(obj);
        }

        oos.close();
        fos.close();
    }

    public static boolean appendTextFile(String fileName, String content) {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            fw.write(content + "\n");
            fw.close();
            return true;
        } catch (Exception e) {
            showAlert("File Error", "Could not append to " + fileName);
            return false;
        }
    }

    public static void closeWindow(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            Helper.showAlert("Error", "Could not close window");
        }
    }

    public static void setScene(ActionEvent actionEvent, Scene scene) {
        try {
            javafx.stage.Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            showAlert("Error", "Could not load scene");
        }
    }

    public static void backToClientDashboard(ActionEvent actionEvent) throws IOException {
        String fxmlPath = "/com/example/real_estate_company/KaziTahmidAbtahi/Client/ClientDashboard.fxml";
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxmlPath));
        Scene scene = new Scene(loader.load());
        setScene(actionEvent, scene);
    }


    public static void logOut(ActionEvent actionEvent) throws IOException {

        String fxmlPath = "/com/example/real_estate_company/Login.fxml";
        FXMLLoader loader = new FXMLLoader(Helper.class.getResource(fxmlPath));
        Scene scene = new Scene(loader.load());
        setScene(actionEvent, scene);
    }
}