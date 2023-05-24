module com.example.uur3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.uur3 to javafx.fxml;
    exports com.example.uur3;
}