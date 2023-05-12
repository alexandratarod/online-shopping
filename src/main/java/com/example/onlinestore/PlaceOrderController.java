package com.example.onlinestore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PlaceOrderController {

    @FXML
    private Button CartButtonFromPlaceOrder;

    private Stage stage;
    private Scene scene;

    private Parent root;

    @FXML
    protected void onCartButtonFromPlaceOrderClick(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("cart-form.fxml"));


        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene) ;
        stage.show();

    }
}
