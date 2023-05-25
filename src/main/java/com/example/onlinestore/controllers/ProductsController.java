package com.example.onlinestore.controllers;

import com.example.onlinestore.model.Product;
import com.example.onlinestore.model.UserData;
import com.example.onlinestore.model.User;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import com.example.onlinestore.servicies.NitriteDB;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductsController implements Initializable {

    @FXML
    private Button HomeButtonFromProductsClick;

    @FXML
    private Button CartButtonFromProductsClick;

    @FXML
    private Button ManageProductsButton;

    @FXML
    private GridPane productsMenu;

    private Stage stage;
    private Scene scene;

    private Parent root;

    private ObservableList<Product> cardlist = FXCollections.observableArrayList();

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

    @FXML
    protected void OnManageProductsButtonClick(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("manageproducts-form.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        manageButtonVisibility();
        menuDisplayCard();
    }

    private void manageButtonVisibility() {
        NitriteDB db = new NitriteDB();
        User currentUser = db.getUser(UserData.username);
        if (currentUser != null && currentUser.getRole().equals("Admin")) {
            ManageProductsButton.setVisible(true);
        } else {
            ManageProductsButton.setVisible(false);
        }
    }

    public void menuDisplayCard(){
        cardlist.clear();
        cardlist = menuGetData();

        int row = 0;
        int column = 0;

        productsMenu.getRowConstraints().clear();
        productsMenu.getColumnConstraints().clear();

        for(int q = 0; q < cardlist.size(); q++)
        {
            try{
                FXMLLoader load = new FXMLLoader();
                load.setLocation(getClass().getClassLoader().getResource("cardProduct.fxml"));
                AnchorPane pane = load.load();
                CardProductController cardc = load.getController();
                cardc.SetData(cardlist.get(q));

                if(column == 5)
                {
                    column = 0;
                    row += 1;
                }



                productsMenu.add(pane, column++, row);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




    public ObservableList<Product> menuGetData() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("manageproducts-form.fxml"));
            Parent root = loader.load();
            ManageProductsController manageProductsController = loader.getController();
            return manageProductsController.getCardList();
        } catch (IOException e) {
            e.printStackTrace();
            return FXCollections.observableArrayList(); // Return an empty list in case of an error
        }
    }



}
