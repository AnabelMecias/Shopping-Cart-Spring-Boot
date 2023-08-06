package com.techbee.Model;

import java.util.LinkedList;

public class ShoppingCart {
    private String shoppingCartName;
    private LinkedList<Product> products;
    private int productsInCart;
    private int productsQuantityLimit;
    private double salesTax;
    
    public ShoppingCart(String shoppingCartName) {
        this.shoppingCartName = shoppingCartName;
        products = new LinkedList<>();
        this.salesTax = 0.1;
        this.productsQuantityLimit = 100;
        this.productsInCart = 0;
    }

    public int getProductsQuantityLimit() {
        return productsQuantityLimit;
    }


    public int getProductQuantity() {
        return products.size();
    }

    public String getShoppingCartName() {
        return shoppingCartName;
    }

    public void setShoppingCartName(String shoppingCartName) {
        this.shoppingCartName = shoppingCartName;
    }

    public LinkedList<Product> getProducts() {
        return products;
    }

    public void setProducts(LinkedList<Product> products) {
        this.products = products;
    }

    public int getproductsQuantityLimit() {
        return productsQuantityLimit;
    }


    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public int getProductsInCart() {
        return productsInCart;
    }

    public void setProductsInCart(int productsInCart) {
        this.productsInCart = productsInCart;
    }

    public void setProductsQuantityLimit(int productsQuantityLimit) {
        this.productsQuantityLimit = productsQuantityLimit;
    }
}
