package com.example.dyrehandel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class DyrehandelApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DyrehandelApplication.class.getResource("dyrehandel.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Dyrehandel!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

    }
}