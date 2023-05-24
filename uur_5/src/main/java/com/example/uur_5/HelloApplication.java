package com.example.uur_5;

import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;

public class HelloApplication extends Application {

    private Colors color = new Colors();
    private Rectangle ctverec;

    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(CreateRootPane(), 500, 500);
        stage.setTitle("Mikuláš Mach, A21B0202P");
        stage.setMinHeight(500);
        stage.setMinWidth(500);
        stage.setScene(scene);
        stage.show();
    }

    public Parent CreateRootPane() {
        VBox rootPane = new VBox();

        rootPane.getChildren().addAll(CreateColorPicker(), CreateColorBox());

        rootPane.setAlignment(Pos.CENTER);

        rootPane.addEventFilter(EventType.ROOT, event -> {
            try {
                redraw();
            } catch (Exception e) {
                System.out.println("Chyba");
            }
        });

        return rootPane;
    }

    public Node CreateColorPicker() {
        HBox colors = new HBox();

        colors.getChildren().addAll(CreateColorR(), CreateColorG(), CreateColorB());

        colors.setAlignment(Pos.CENTER);

        return colors;
    }

    public Node CreateColorR() {
        VBox colorR = new VBox();

        Text txtR = new Text("RED");

        TextField tfR = new TextField();
        tfR.textProperty().bindBidirectional(color.getRed(), new NumberStringConverter());

        Slider slR = new Slider();
        slR.setMin(0);
        slR.setMax(255);
        slR.valueProperty().bindBidirectional(color.getRed());

        colorR.getChildren().addAll(txtR, tfR, slR);

        return colorR;
    }

    public Node CreateColorG() {
        VBox colorG = new VBox();

        Text txtG = new Text("GREEN");

        TextField tfG = new TextField();
        tfG.textProperty().bindBidirectional(color.getGreen(), new NumberStringConverter());

        Slider slG = new Slider();

        slG.setOnDragDone(e -> redraw());


        slG.setMin(0);
        slG.setMax(255);
        slG.valueProperty().bindBidirectional(color.getGreen());

        colorG.getChildren().addAll(txtG, tfG, slG);

        return colorG;
    }

    public Node CreateColorB() {
        VBox colorB = new VBox();

        Text txtB = new Text("BLUE");

        TextField tfB = new TextField();
        tfB.textProperty().bindBidirectional(color.getBlue(), new NumberStringConverter());

        Slider slB = new Slider();
        slB.setMin(0);
        slB.setMax(255);
        slB.valueProperty().bindBidirectional(color.getBlue());

        colorB.getChildren().addAll(txtB, tfB, slB);

        return colorB;
    }


    public Node CreateColorBox() {
        HBox colorBox = new HBox();

        Rectangle rec = new Rectangle(50, 50);
        ctverec = rec;

        rec.setFill(color.getColor());

        colorBox.getChildren().addAll(rec);

        colorBox.setAlignment(Pos.CENTER);

        return colorBox;
    }

    public void redraw() {
        ctverec.setFill(color.getColor());
        ;
    }

    public static void main(String[] args) {
        launch();
    }
}