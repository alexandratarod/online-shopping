package com.example.onlinestore.model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.dizitart.no2.objects.Id;

public class Orders {

    private static int orderId;

    private String clientName;
    private double totalPrice;
    private String address;

    public static ObservableList<Product> productsList ;



    public Orders(String clientName, double totalPrice, String address, ObservableList<Product> productsList) {

        orderId++;
        this.clientName = clientName;
        this.totalPrice = totalPrice;
        this.address = address;
        this.productsList = productsList;
    }


    public static void setOrderId(int orderId) {
        Orders.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static ObservableList<Product> getProductsList() {
        return productsList;
    }

    public static void setProductsList(ObservableList<Product> productsList) {
        Orders.productsList = productsList;
    }
}