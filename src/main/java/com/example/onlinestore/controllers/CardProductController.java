package com.example.onlinestore.controllers;

import com.example.onlinestore.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CardProductController {
    @FXML
    private Button AddToCartButton;

    @FXML
    private ImageView ImageView_product;

    @FXML
    private Label productNameLabel;

    @FXML
    private Label productPriceLabel;

    @FXML
    private AnchorPane cardProductAnchor;

    private Product prodData;
    private Image image;


    public void SetData(Product prodData){
        this.prodData = prodData;
        image = new Image(prodData.getPicture(), 130,147, false, true);
        productNameLabel.setText(prodData.getProductName());
        productPriceLabel.setText(String.valueOf(prodData.getPrice()));
        ImageView_product.setImage(image);
    }


}
