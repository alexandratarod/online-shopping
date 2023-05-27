package com.example.onlinestore.model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.dizitart.no2.objects.Id;

public class Orders {

    private int orderId;

    //private String clientID;

    private String clientName;
    private double totalPrice;
    private String address;

    //private String status;

    public static ObservableList<Product> productsList ;



    public Orders(String clientName, double totalPrice, String address, ObservableList<Product> productsList) {
        orderId++;
        //this.clientID = clientID;
        this.clientName = clientName;
        this.totalPrice = totalPrice;
        this.address = address;
        this.productsList = productsList;
        //this.status = "Pending";
    }

    public Orders(){
        orderId++;
        //this.clientID = "";
        this.clientName = "";
        this.totalPrice = 0;
        this.address = "";
        this.productsList = null;
        //this.status = "Canceled";
    }

    private String getProductsIdForOrders() {
        if (productsList != null) {
            StringBuilder text = new StringBuilder();
            for (int i = 0; i < productsList.size(); i++) {
                text.append(productsList.get(i).getProductId());
            }
            return text.toString();
        }
        return null;
    }


    public void setOrderId(int orderId) {
        this.orderId = orderId;
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
