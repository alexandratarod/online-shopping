package com.example.onlinestore.model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.dizitart.no2.objects.Id;

public class Orders {
    @Id
    private String orderId;
    private String clientName;
    private double totalPrice;
    private String address;

    public static ObservableList<Product> productsList = FXCollections.observableArrayList();

    public Orders(String orderId, String clientName, double totalPrice, String address, ObservableList<Product> productsList) {
        this.orderId = orderId;
        this.clientName = clientName;
        this.totalPrice = totalPrice;
        this.address = address;
        this.productsList = productsList;
    }



}