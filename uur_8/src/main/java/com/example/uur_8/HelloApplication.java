package com.example.uur_8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(CreateRootPane(), 400, 400);
        stage.setTitle("TreeView");
        stage.setScene(scene);
        stage.show();
    }

    private Parent CreateRootPane(){
        BorderPane rootPane = new BorderPane();


        return rootPane;
    }

    public static void main(String[] args) {
        launch();
    }
}