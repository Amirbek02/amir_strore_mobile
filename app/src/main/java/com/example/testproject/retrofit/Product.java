package com.example.testproject.retrofit;

public class Product {
    private int id;
    private String productText;
    private String productCost;

    public Product(int id, String productText, String productCost) {
        this.id = id;
        this.productText = productText;
        this.productCost = productCost;
    }

    public int getId() {
        return id;
    }

    public String getProductText() {
        return productText;
    }

    public String getProductCost() {
        return productCost;
    }
}
