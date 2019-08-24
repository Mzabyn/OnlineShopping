package com.example.onlineshopping.Model;

/**
 * Created by Milon Hossain on 8/22/2019.
 */

public class Product {


    public String getProduct_name() {

        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    String product_name, image, details;
    double price;

    public Product(String details) {
        this.details = details;
    }

    public Double getPrice() {

        return price;
    }

    public Product(String product_name, String image, String details, double price) {
        this.product_name = product_name;
        this.image = image;
        this.details = details;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
