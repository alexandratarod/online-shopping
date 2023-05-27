package com.example.onlinestore.controllers;

import com.example.onlinestore.model.Orders;
import com.example.onlinestore.model.UserData;
import com.example.onlinestore.servicies.OrdersDatabase;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class OrdersClientController implements Initializable {
    @FXML
    private Button HomeButton;

    @FXML
    private TableView<Orders> MyOrders_TableView;

    @FXML
    private TableColumn<Orders, String> OrderID_Column;

    @FXML
    private TableColumn<Orders, String> ProductsID_Column;

    @FXML
    private TableColumn<Orders, String> ProductsName_Column;

    @FXML
    private TableColumn<Orders, String > Status_Column;

    @FXML
    private TableColumn<Orders, String> TotalPrice_Column;


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

    @FXML
    public void OrdersShowData() {
        OrderID_Column.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        //ProductsID_Column.setCellValueFactory(new PropertyValueFactory<>("productsID"));
        //ProductsName_Column.setCellValueFactory(new PropertyValueFactory<>("productsName"));
        TotalPrice_Column.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        //Status_Column.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Get the client's orders
        List<Orders> clientOrders = OrdersDatabase.getOrdersByClientId(UserData.username);
        ObservableList<Orders> orderslistdata = FXCollections.observableArrayList(clientOrders);
        MyOrders_TableView.setItems(orderslistdata);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        OrdersShowData();
    }


}

