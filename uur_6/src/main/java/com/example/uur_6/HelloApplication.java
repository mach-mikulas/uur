package com.example.uur_6;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.text.Collator;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class HelloApplication extends Application {


    private TableView<Animal> zooTable;
    private ObservableList<Animal> zoo = FXCollections.observableArrayList();

    private void createAnimal(){
        zoo.add(new Animal(0.05, "Spider", "", 8));
        zoo.add(new Animal(0.5, "Mutated Spider", "", 12));
        zoo.add(new Animal(150, "Zebra", "ihahá", 4));
        zoo.add(new Animal(1.5, "Činčila", "písk", 4, LocalDate.of(1992,1,25), false));
    }

    @Override
    public void start(Stage stage) throws IOException {

        createAnimal();

        Scene scene = new Scene(CreateRootPane(), 500, 500);
        stage.setTitle("Zoo");
        stage.setScene(scene);
        stage.show();
    }

    private Parent CreateRootPane(){
        BorderPane rootPane = new BorderPane();
        rootPane.setCenter(createTablePane());
        rootPane.setBottom(CreateStatusBar());

        return rootPane;
    }

    private Node CreateStatusBar(){
        HBox statursBar = new HBox();

        Button addBtn = new Button("Add random animal");
        addBtn.setOnAction(e -> addRandomAnimal());

        statursBar.getChildren().addAll(addBtn);

        return statursBar;
    }

    private void addRandomAnimal() {
        Random rnd = new Random();

        Animal newAnimal = new Animal();
        newAnimal.setSpecies("New adnimal");
        newAnimal.setWeight(rnd.nextDouble(500));
        newAnimal.setLegCount(rnd.nextInt(20));
        newAnimal.setSound("xd");

        zoo.add(newAnimal);
    }

    private Node createTablePane(){
        zooTable = new TableView<>();

        zooTable.setItems(zoo);
        zooTable.setEditable(true);

        TableColumn<Animal,String> speciesColumn = new TableColumn<>("Species");
        speciesColumn.setCellValueFactory(new PropertyValueFactory<Animal,String>("species"));
        speciesColumn.setComparator(Collator.getInstance(new Locale("cs", "CZ"))::compare);
        speciesColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        //speciesColumn.setOnEditCommit(e -> e.getRowValue().setSpecies(e.getNewValue()));

        TableColumn<Animal,Double> weightColumn = new TableColumn<>("Weight");
        weightColumn.setCellValueFactory(new PropertyValueFactory<Animal,Double>("weight"));
        weightColumn.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Double>() {

            double oldValue;

            @Override
            public String toString(Double object) {
                oldValue = object;
                return object + "";
            }

            @Override
            public Double fromString(String string) {
                try{
                    double oldValue = Double.parseDouble(string);
                    return oldValue;
                }
                catch (NumberFormatException e){
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("This " + string + " is not a number");
                    a.show();

                }

                return oldValue;
            }
        }));

        TableColumn<Animal,String> soundColumn = new TableColumn<>("Sound");
        soundColumn.setCellValueFactory(new PropertyValueFactory<Animal,String>("sound"));

        TableColumn<Animal,Integer> legCountColumn = new TableColumn<>("Leg cCount");
        legCountColumn.setCellValueFactory(new PropertyValueFactory<Animal,Integer>("legCount"));

        TableColumn<Animal, LocalDate> dateColumn = new TableColumn<>("BirthDate");
        dateColumn.setCellValueFactory(new PropertyValueFactory<Animal,LocalDate>("date"));
        dateColumn.setCellFactory(e -> new DatePickerTableCell<Animal, LocalDate>());

        TableColumn<Animal,Boolean> aliveColumn = new TableColumn<>("Is alive");
        aliveColumn.setCellValueFactory(new PropertyValueFactory<Animal,Boolean>("alive"));
        aliveColumn.setCellFactory(CheckBoxTableCell.forTableColumn(aliveColumn));


        zooTable.getColumns().addAll(speciesColumn,weightColumn,soundColumn,legCountColumn,dateColumn,aliveColumn);
        zooTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        //zooTable.getSelectionModel().getSelectedItems().addListener((ListChangeListener<? super Animal>) e -> showPrintDialog(zooTable));

        return zooTable;
    }

    private void showPrintDialog(Node data) {
        PrinterJob job = PrinterJob.createPrinterJob();
        if(job != null){
            boolean succesful = job.printPage(data);
            if(succesful){
                job.endJob();
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}