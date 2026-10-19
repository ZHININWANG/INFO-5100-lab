package com.mycompany.lab5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(
                getClass().getResource("/com/mycompany/lab5/view/form.fxml"));
        stage.setTitle("Lab 5 - JavaFX MVC Form");
        stage.setScene(new Scene(root, 380, 240));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
