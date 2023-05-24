package com.example.uur3;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class HelloApplication extends Application {

    private FlowPane panel;
    private Stage primaryStage;
    private Button bt2, bt3, bt4, bt5;

    @Override
    public void start(Stage stage) throws IOException {

        System.out.println("Starting start");


        Scene mainScene = new Scene(CreateRootPane(), 200, 300);
        this.primaryStage = stage;
        stage.setTitle("UUR3");
        stage.setScene(mainScene);
        stage.show();
    }

    protected Parent CreateRootPane() {

        panel = new FlowPane();

        final Tooltip show = new Tooltip();
        show.setText("Zobrazi skryta tlacitka");
        final Tooltip print = new Tooltip();
        print.setText("Vypise kratky text do konzole");
        final Tooltip change = new Tooltip();
        change.setText("Zmeni title na aktualni systemovi cas");
        final Tooltip lable = new Tooltip();
        lable.setText("Vytvori novy lable");
        final Tooltip hide = new Tooltip();
        hide.setText("Skryje vsechny tlacitka krome show");

        Button showBT = new Button("show");
        showBT.setTooltip(show);

        Button printBT = new Button("Print something");
        printBT.setTooltip(print);
        printBT.setOnAction(e -> printSomething());

        Button changeTitleBT = new Button("Change Title");
        changeTitleBT.setTooltip(change);
        changeTitleBT.setOnAction(e -> newTitle());

        Button addLable = new Button("add lable");
        addLable.setTooltip(lable);
        addLable.setOnAction(e -> addNewLable());

        //Button deleteBT = new Button("Delete");
        //deleteBT.setOnAction(e -> deleteLabelFromMainPane());

        Button hideBT = new Button("Hide");
        hideBT.setTooltip(hide);

        ArrayList<Button> btns = new ArrayList<>();
        btns.add(printBT);
        btns.add(changeTitleBT);
        //btns.add(deleteBT);
        btns.add(hideBT);
        btns.add(addLable);

        hideBT.setOnAction(e -> hideAllButtons(btns));

        showBT.setOnAction(e -> showAllButtons(btns));

        panel.getChildren().addAll(showBT, printBT, changeTitleBT, addLable, hideBT);
        hideAllButtons(btns);

        return panel;
    }

    private void showAllButtons(ArrayList<Button> btns) {
        btns.forEach(e -> e.setVisible(true));
    }

    private void hideAllButtons(ArrayList<Button> btns) {
        btns.forEach(e -> e.setVisible(false));
    }

    private void printSomething() {
        System.out.println("Kratky text");
    }

/*
    private void deleteLabelFromMainPane(){
        for (Node node : panel.getChildren()) {
            if(node instanceof Label){
                panel.getChildren().remove(node);
                break;
            }
        };
    }
 */

    private void newTitle() {
        System.out.println("setting new title");
        primaryStage.setTitle(System.currentTimeMillis() + "");
        //panel.getChildren().add(new Label(System.currentTimeMillis() + ""));
    }

    private void addNewLable() {
        panel.getChildren().add(new Label("Lable"));
    }

    public static void main(String[] args) {

        System.out.println("Starting main");
        launch();
        System.out.println("Stopping main");
    }
}