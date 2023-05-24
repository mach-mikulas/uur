package uur4.uur_4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    TextArea text;

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(createRootPane(), 500, 400);
        stage.setTitle("Mikuláš Mach, A21B0202P");
        stage.setMinHeight(400);
        stage.setMinWidth(500);
        stage.setScene(scene);
        stage.show();
    }

    protected Parent createRootPane() {


        BorderPane rootPane = new BorderPane();

        rootPane.setTop(createMenuBar());
        rootPane.setLeft(createOptionPane());
        rootPane.setRight(createInfoPane());
        rootPane.setCenter(createStatusPane());
        rootPane.setBottom(createControlPane());

        return rootPane;
    }

    private Node createMenuBar() {

        MenuBar mainMenu = new MenuBar();

        Menu programMenu = new Menu("_Program");

        MenuItem turnOn = new MenuItem("Turn on");
        MenuItem turnOff = new MenuItem("Turn off");

        Menu dataMenu = new Menu("_Data");

        MenuItem download = new MenuItem("Download");
        MenuItem update = new MenuItem("Update");
        MenuItem upload = new MenuItem("Upload");

        programMenu.getItems().addAll(turnOn, turnOff);
        dataMenu.getItems().addAll(download, update, upload);

        mainMenu.getMenus().addAll(programMenu, dataMenu);

        return mainMenu;
    }

    private Node createControlPane() {

        GridPane controlPane = new GridPane();


        Button btnForward = new Button("Forward");
        controlPane.add(btnForward, 2, 1);
        Button btnLeft = new Button("Left");
        controlPane.add(btnLeft, 1, 2);
        Button btnRight = new Button("Right");
        controlPane.add(btnRight, 3, 2);
        Button btnBack = new Button("Back");
        controlPane.add(btnBack, 2, 3);

        Button btnInvisible = new Button();
        btnInvisible.setVisible(false);
        controlPane.add(btnInvisible, 4, 1);


        controlPane.getChildren().forEach(e -> ((Button) e).setMinWidth(60));

        controlPane.setPadding(new Insets(5));

        CheckBox cbAku = new CheckBox("Akustický");
        controlPane.add(cbAku, 5, 1);
        CheckBox cbOpt = new CheckBox("Optický");
        controlPane.add(cbOpt, 5, 2);
        CheckBox cbTepl = new CheckBox("Tepelný");
        controlPane.add(cbTepl, 5, 3);
        CheckBox cbTlak = new CheckBox("Tlakový");
        controlPane.add(cbTlak, 6, 1);
        CheckBox cbRad = new CheckBox("Radarový");
        controlPane.add(cbRad, 6, 2);

        controlPane.setAlignment(Pos.CENTER);

        return controlPane;
    }

    private Node createOptionPane() {

        int minWidth = 100;

        VBox optionPane = new VBox();

        ToggleGroup tgEnergy = new ToggleGroup();

        RadioButton rbSolar = new RadioButton("Solar Energy");
        RadioButton rbBaterry = new RadioButton("Baterry");
        RadioButton rbRtg = new RadioButton("RTG");

        optionPane.getChildren().addAll(rbSolar, rbBaterry, rbRtg);
        optionPane.getChildren().forEach(e -> ((RadioButton) e).setMinWidth(100));
        optionPane.getChildren().forEach(e -> ((RadioButton) e).setToggleGroup(tgEnergy));

        Button btnTurnOn = new Button("Turn on");
        btnTurnOn.setMinWidth(minWidth);
        Button btnTurnOff = new Button("Turn off");
        btnTurnOff.setMinWidth(minWidth);
        Button btnRestart = new Button("Restart");
        btnRestart.setMinWidth(minWidth);
        optionPane.getChildren().addAll(btnTurnOn, btnTurnOff, btnRestart);

        optionPane.setAlignment(Pos.CENTER);

        return optionPane;
    }

    private Node createInfoPane() {

        VBox infoPane = new VBox();


        Text labelNatoceni = new Text("Aktualni natočení a rychlost");
        TextArea natoceni = new TextArea();
        natoceni.setPrefColumnCount(2);
        natoceni.setPrefRowCount(4);

        Text labelBaterry = new Text("Stav baterie");
        TextField tfBaterry = new TextField();
        Text labelDistance = new Text("Ujedá vzdálenost");
        TextField tfdistance = new TextField();
        Text labelLifeTime = new Text("Čas běhu");
        TextField tfLifeTime = new TextField();
        Text labelState = new Text("Stav robota");
        TextField tfState = new TextField();

        infoPane.getChildren().addAll(labelNatoceni, natoceni, labelBaterry, tfBaterry, labelDistance, tfdistance, labelLifeTime, tfLifeTime, labelState, tfState);

        infoPane.setAlignment(Pos.CENTER);

        return infoPane;
    }

    private Node createStatusPane() {
        text = new TextArea();
        return text;
    }

    public static void main(String[] args) {
        launch();
    }
}