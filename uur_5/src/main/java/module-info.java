module com.example.uur_5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.uur_5 to javafx.fxml;
    exports com.example.uur_5;
}