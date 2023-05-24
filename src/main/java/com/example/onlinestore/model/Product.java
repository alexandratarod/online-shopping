package com.example.onlinestore.model;

import javafx.scene.image.Image;
import org.dizitart.no2.objects.Id;

public class Product {
    @Id
    private String productId;
    private String productName;
    private double price;
    private int stock;
    private String picture;

    public Product(String productId, String productName, double price, int stock, String picture) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.picture = picture;
    }

    public Product(){
        this.productId = "";
        this.productName = "";
        this.price = 0;
        this.stock = 0;
        this.picture = "";
    }

    public Product(String productName, double price, String picture){
        this.productName = productName;
        this.price = price;
        setPicture(picture);
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }



}
