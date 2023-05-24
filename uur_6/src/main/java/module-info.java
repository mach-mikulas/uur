module com.example.uur_6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.uur_6 to javafx.fxml;
    exports com.example.uur_6;
}