package com.techbee.DAO;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.techbee.Model.Product;
import com.techbee.Model.ShoppingCart;

public class ShoppingCartDAO {
    private StoreDAO storeDAO;
    private ShoppingCart shoppingCart;

    public ShoppingCartDAO() {
        this.storeDAO = new StoreDAO();
        this.shoppingCart = new ShoppingCart("Anabel");
    }

    public double getSubTotal() {
        int count = 0;
        for (Product product : shoppingCart.getProducts()) {
            double price = product.getPrice() * product.getProductQuantity();
            count += price - (price * product.getDiscount());
        }
        return count;
    }

    public double getTotalTax() {
        return getSubTotal() * shoppingCart.getSalesTax();
    }

    public Product addProduct(String prdName, int quantity) {
        Product product =  null;
        int productsInCart = shoppingCart.getProductsInCart();
        if ((productsInCart + quantity) <= shoppingCart.getProductsQuantityLimit()) {
            Product prd = getProductByName(prdName);
            if (prd != null) {
                int pos = shoppingCart.getProducts().indexOf(prd);
                product = shoppingCart.getProducts().get(pos);
                if ((product.getProductQuantity() + quantity) <= product.getProductQuantityLimit()) {
                    product.setProductQuantity(product.getProductQuantity() + quantity);
                    productsInCart += quantity;
                    shoppingCart.setProductsInCart(productsInCart);
                    return product;
                }
            } else {
                product = storeDAO.searchProductInInventory(prdName);
                if (product != null) {
                    if ((product.getProductQuantity() + quantity) <= product.getProductQuantityLimit()) {
                        product.setProductQuantity(quantity);
                        shoppingCart.getProducts().add(product);
                        productsInCart += quantity;
                        shoppingCart.setProductsInCart(productsInCart);
                        return product;
                    }
                }
            }
        }
        return product;
    }

    public Product deleteProduct(String prdName, int quantity) {
        Product product = null;
        if (!shoppingCart.getProducts().isEmpty()) {
            product = getProductByName(prdName);
            if (product != null) {
                int productsInCart = shoppingCart.getProductsInCart();
                if ((product.getProductQuantity() - quantity) <= 0) {
                    shoppingCart.getProducts().remove(product);
                    if ((product.getProductQuantity() - quantity) < 0) {
                        productsInCart -= product.getProductQuantity();
                        shoppingCart.setProductsInCart(productsInCart);
                    } else {
                        productsInCart -= quantity;
                        shoppingCart.setProductsInCart(productsInCart);
                    }
                } else if ((product.getProductQuantity() - quantity) > 0) {
                    product.setProductQuantity(product.getProductQuantity() - quantity);
                    productsInCart -= quantity;
                    shoppingCart.setProductsInCart(productsInCart);
                }
            }
        }
        return product;
    }

    public Product getProductByName(String prdName) {
        for (Product product : shoppingCart.getProducts()) {
            if (product.getProductName().equals(prdName)) {
                return product;
            }
        }
        return null;
    }

    public Product editProductQuantity(String prdName, int quantity) {
        Product prd = null;
        if (!shoppingCart.getProducts().isEmpty()){
            prd = getProductByName(prdName);
            if (prd != null) {
                int pos = shoppingCart.getProducts().indexOf(prd);
                prd = shoppingCart.getProducts().get(pos);
                if (quantity <= prd.getProductQuantityLimit()) {
                    shoppingCart.setProductsInCart(shoppingCart.getProductsInCart() - prd.getProductQuantity());
                    prd.setProductQuantity(quantity);
                    shoppingCart.setProductsInCart(shoppingCart.getProductsInCart() + quantity);
                }
            }
        }
        return prd;
    }

    public List<Product> showProductsAlphabetical() {
        LinkedList<Product> productsList = new LinkedList<>(getAllProductsInCart());
        Collections.sort(getAllProductsInCart(), Comparator.comparing(Product::getProductName));
        return  productsList ; 
    }

    public List<Product> getAllProductsInCart() {
        return shoppingCart.getProducts();
    }

    public String showShoppingCartDetails() {
        return "Shopping Cart \"" + shoppingCart.getShoppingCartName() + "\" details: Subtotal= " + getSubTotal()
                + " Products Quantity= " + shoppingCart.getProductsInCart() + " Sales Tax= " + getTotalTax();
    }

}
