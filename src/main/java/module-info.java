module com.example.onlinestore {
    requires javafx.controls;
    requires javafx.fxml;
    requires nitrite;


    opens com.example.onlinestore to javafx.fxml;


    exports com.example.onlinestore;
    exports com.example.onlinestore.controllers;
    opens com.example.onlinestore.controllers ;
    exports com.example.onlinestore.model;
    opens com.example.onlinestore.model ;
    exports com.example.onlinestore.servicies;
    opens com.example.onlinestore.servicies ;
    exports com.example.onlinestore.exceptions;
    opens com.example.onlinestore.exceptions ;


}