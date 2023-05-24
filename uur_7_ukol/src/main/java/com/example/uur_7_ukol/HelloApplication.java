package com.example.uur_7_ukol;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private TableView<> fontTable;

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(CreateRootPane(), 500, 500);
        stage.setTitle("PlaceHolder");
        stage.setScene(scene);
        stage.show();
    }

    private Parent CreateRootPane(){
        BorderPane rootPane = new BorderPane();
        rootPane.setCenter(createTablePane());

        return rootPane;
    }

    private Node createTablePane(){
        fontTable = new TableView<>();

        return fontTable;
    }

    public static void main(String[] args) {
        launch();
    }
}