package com.example.onlinestore.controllers;

import com.example.onlinestore.model.Orders;
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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OrdersAdminController implements Initializable {
    @FXML
    private TableColumn<Orders, String> Address_Column;

    @FXML
    private TableColumn<Orders, String> ClientID_Column;

    @FXML
    private Button ApplyButton;

    @FXML
    private TableColumn<Orders, String> ClientName_Column;

    @FXML
    private Button HomeButton;

    @FXML
    private TableColumn<Orders, String> OrderID_column;

    @FXML
    private TableView<Orders> Orders_TableView;

    @FXML
    private TableColumn<Orders, String> ProductsID_column;

    @FXML
    private TableColumn<Orders, String> ProductsName_Column;

    @FXML
    private ChoiceBox<String> SelectOrderStatusChoiceBox;

    @FXML
    private TableColumn<Orders, String> Status_Column;

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

        OrderID_column.setCellValueFactory(new PropertyValueFactory<>("orderId"));
       // ProductsID_column.setCellValueFactory(new PropertyValueFactory<>("productsID"));
       // ClientID_Column.setCellValueFactory(new PropertyValueFactory<>("clientID"));
        Address_Column.setCellValueFactory(new PropertyValueFactory<>("address"));
        ClientName_Column.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        TotalPrice_Column.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        //Status_Column.setCellValueFactory(new PropertyValueFactory<>("status"));

        ObservableList<Orders> orderslistdata = FXCollections.observableArrayList(OrdersDatabase.getAllOrders());
        Orders_TableView.setItems(orderslistdata);


    }

    private void initializeOrderStatusChoiceBox() {
        // Define the list of order status options
        ObservableList<String> orderStatusOptions = FXCollections.observableArrayList(
                "Pending", "Processing", "Completed"
        );

        // Set the options in the choice box
        SelectOrderStatusChoiceBox.setItems(orderStatusOptions);
    }

    /*private void onApplyButtonClicked(ActionEvent event) {
        String selectedOption = SelectOrderStatusChoiceBox.getValue();
        if (selectedOption != null) {
            String message = "Option selected: " + selectedOption;
            displayAlert(Alert.AlertType.INFORMATION, "Selection", message);
        } else {
            displayAlert(Alert.AlertType.WARNING, "Selection", "Please select an option.");
        }
    }

    private void displayAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }*/


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        OrdersShowData();
        initializeOrderStatusChoiceBox();
    }
}
