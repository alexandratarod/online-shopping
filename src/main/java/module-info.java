module com.example.onlinestore {
    requires javafx.controls;
    requires javafx.fxml;
    requires nitrite;


    opens com.example.onlinestore to javafx.fxml;


    exports com.example.onlinestore;
}