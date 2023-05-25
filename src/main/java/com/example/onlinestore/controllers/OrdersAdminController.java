package com.example.onlinestore.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;

public class OrdersAdminController {
    @FXML
    private Button ApplyButton;

    @FXML
    private Button HomeButton;

    @FXML
    private ChoiceBox<?> SelectOrderStatusChoiceBox;

    private Stage stage;
    private Scene scene;

    private Parent root;

    @FXML
    protected void OnHomeButton(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("homepage-form.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
