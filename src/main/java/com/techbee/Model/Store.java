package com.techbee.Model;
import java.util.List;

public class Store {
    private List<Product> productsAvailables;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Store(List<Product> productsAvailables, String name) {
        this.productsAvailables = productsAvailables;
        this.name = name;
    }

    public Store(List<Product> products) {
        this.productsAvailables = products;
    }

    public List<Product> getProductsAvailables() {
        return productsAvailables;
    }

    public void setProductsAvailables(List<Product> productsAvailables) {
        this.productsAvailables = productsAvailables;
    }
}
