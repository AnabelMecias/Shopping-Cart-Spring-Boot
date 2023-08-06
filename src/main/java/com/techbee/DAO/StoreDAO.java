package com.techbee.DAO;

import java.util.ArrayList;
import java.util.List;

import com.techbee.Model.Product;
import com.techbee.Model.Store;

public class StoreDAO {
    private Store store;

    public StoreDAO() {
        setStore();
    }
    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Product searchProductInInventory(String prdName) {
        List<Product> products = store.getProductsAvailables();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().equals(prdName)) {
                return products.get(i);
            }
        }
        return null;
    }

    public List<Product> getProductsAvailables () {
        return store.getProductsAvailables();
    }

    public void setStore() {
        List<Product> productsInInventory = new ArrayList<Product>();
        Product product1 = new Product(1001, "Smartphone", 600.0f, 0.1f, "High-end smartphone with advanced features.",
                0, 5);
        Product product2 = new Product(2002, "Laptop", 900.0f, 0.15f, "Powerful laptop for work and gaming.", 0, 100);
        Product product3 = new Product(3003, "Headphones", 150.0f, 0.05f,
                "Wireless headphones with noise-cancellation.", 0, 200);
        Product product4 = new Product(4004, "Tablet", 250.0f, 0.2f, "Compact tablet with a high-resolution display.",
                0, 3);
        Product product5 = new Product(5005, "Smartwatch", 200.0f, 0.05f, "Fitness tracker with heart rate monitor.", 0,
                20);
        productsInInventory.add(product5);
        productsInInventory.add(product4);
        productsInInventory.add(product3);
        productsInInventory.add(product2);
        productsInInventory.add(product1);
        this.store = new Store(productsInInventory, "Amazon");
    }
}
