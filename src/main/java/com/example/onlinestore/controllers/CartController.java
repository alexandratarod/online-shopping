package com.example.onlinestore.controllers;

import com.example.onlinestore.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CartController implements Initializable {

    @FXML
    private Button PlaceorderButtonFormCart;

    @FXML
    private Button ProductsButtonFromCart;


    private Stage stage;
    private Scene scene;

    private Parent root;

    public static ObservableList<Product> cartList = FXCollections.observableArrayList();

    @FXML
    protected void onPlaceorderButtonFromCartClick(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("placeorder-form.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene) ;
        stage.show();

    }

    @FXML
    protected void onProductsButtonFromCartClick(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("products-form.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene) ;
        stage.show();

    }
    @FXML
    private TableColumn<Product, String> Price_col;

    @FXML
    private TableColumn<Product, String> Product_col;

    @FXML
    private TableView<Product> CartTableView;

    @FXML
    private Label total_Price;


    public void ShowProductsToCart() {


        Product_col.setCellValueFactory(new PropertyValueFactory<>("productName"));
        Price_col.setCellValueFactory(new PropertyValueFactory<>("price"));

        CartTableView.setItems(cartList);
    }

    public static double calculateTotalPrice(){

        double total_price = 0;

        for (Product product : cartList) {
            double price = product.getPrice();
            total_price += price;
        }

        return total_price;

    }


    public void ShowTotalPrice() {


        total_Price.setText(String.valueOf(calculateTotalPrice()) + " $");

    }

    public void initialize(URL url, ResourceBundle resourceBundle) {

        ShowProductsToCart();
        ShowTotalPrice();
    }


    public String getTotalPriceLabelText() {

        return String.valueOf(calculateTotalPrice());
    }
}

