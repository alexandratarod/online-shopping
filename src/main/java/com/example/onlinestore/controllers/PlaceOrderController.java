package com.example.onlinestore.controllers;

import com.example.onlinestore.model.Orders;
import com.example.onlinestore.model.Product;
import com.example.onlinestore.model.UserData;
import com.example.onlinestore.servicies.NitriteDB;
import com.example.onlinestore.servicies.OrdersDatabase;
import com.example.onlinestore.servicies.ProductDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.onlinestore.controllers.CartController.calculateTotalPrice;
import static com.example.onlinestore.controllers.CartController.cartList;

public class PlaceOrderController  {

    @FXML
    private Button CartButtonFromPlaceOrder;

    @FXML
    private TextField firstname_field;

    @FXML
    private TextField lastname_field;

    @FXML
    private TextField city_field;

    @FXML
    private TextField street_field;

    @FXML
    private TextField postalcode_field;

    private Orders db;

    private Stage stage;
    private Scene scene;

    private Parent root;

    @FXML
    protected void onCartButtonFromPlaceOrderClick(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("cart-form.fxml"));


        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene) ;
        stage.show();

    }

    @FXML
    protected void onPlaceOrderButtonClick(ActionEvent event) throws IOException {


        String clientName = firstname_field.getText() + " " + lastname_field.getText();
        double totalPrice = calculateTotalPrice();
        String address = city_field.getText() + " " + street_field.getText() + " " + postalcode_field.getText();
        //String clientID = UserData.username;
        Orders order = new Orders(clientName, totalPrice, address, cartList);

        OrdersDatabase.addOrder(order); // Call the method to add the product to the database

        clearFields();

    }
    private void clearFields() {
        firstname_field.clear();
        lastname_field.clear();
        city_field.clear();
        street_field.clear();
        postalcode_field.clear();
    }

}
