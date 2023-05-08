module com.example.onlinestore {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.onlinestore to javafx.fxml;
    exports com.example.onlinestore;
}