package com.example.testproject.retrofit;

public class Product {
    private int id;
    private String productImg;
    private String productText;
    private int productCost;


    public Product(int id,String productImg, String productText, int productCost) {
        this.id = id;
        this.productImg = productImg;
        this.productText = productText;
        this.productCost = productCost;

    }

    public int getId() {
        return id;
    }
    public String getProductImg() {
        return productImg;
    }

    public String getProductText() {
        return productText;
    }

    public int getProductCost() {
        return productCost;
    }


}
