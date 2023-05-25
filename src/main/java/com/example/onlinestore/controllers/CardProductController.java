package com.example.onlinestore.controllers;

import com.example.onlinestore.model.Product;
import com.example.onlinestore.servicies.NitriteDB;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.onlinestore.controllers.CartController.cartList;

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

        productNameLabel.setText(prodData.getProductName() );
        productPriceLabel.setText(String.valueOf(prodData.getPrice()) + "$");


        if(prodData.getPicture().isEmpty()){
            String imagePath = "/nophoto.jpg";
            Image image = new Image(getClass().getResourceAsStream(imagePath), 130, 147, false, true);
            ImageView_product.setImage(image);
        }
        else {
            image = new Image(prodData.getPicture(), 130, 147, false, true);
            ImageView_product.setImage(image);
        }
    }

    public String getProductName() {
        return productNameLabel.getText();
    }

    public String getProductPrice() {
        return productPriceLabel.getText();
    }


    @FXML
    protected void onAddToCartButtonClick(ActionEvent event) throws IOException {

        String productName = getProductName();

        String priceString = productPriceLabel.getText().replace("$", "");
        double price = Double.parseDouble(priceString);

        Product product = new Product(productName, Double.parseDouble(String.valueOf(price)));

        cartList.add(product);
    }

}
