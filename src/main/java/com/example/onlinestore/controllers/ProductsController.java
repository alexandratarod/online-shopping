package com.example.onlinestore.controllers;

import com.example.onlinestore.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ProductsController {

    @FXML
    private Button HomeButtonFromProductsClick;

    @FXML
    private Button CartButtonFromProductsClick;

    private Stage stage;
    private Scene scene;

    private Parent root;


    @FXML
    protected void onHomeButtonFromProductsClick(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("homepage-form.fxml"));



        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene) ;
        stage.show();

    }

    @FXML
    protected void onCartButtonFromProductsClick(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("cart-form.fxml"));

        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene) ;
        stage.show();

    }

}
