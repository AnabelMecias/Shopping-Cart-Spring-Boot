package com.techbee.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techbee.DAO.ShoppingCartDAO;
import com.techbee.Model.Product;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartDAO shoppingCartDAO;

    public ShoppingCartService() {
        this.shoppingCartDAO = new ShoppingCartDAO();
    }

    public double getSubTotal() {
        return shoppingCartDAO.getSubTotal();
    }

    public double getTotalTax() {
        return shoppingCartDAO.getTotalTax();
    }

    public Product addProduct(String prdName, int quantity) {
        return shoppingCartDAO.addProduct(prdName, quantity);
    }

    public Product deleteProduct(String prdName, int quantity) {
       return shoppingCartDAO.deleteProduct(prdName, quantity);
    }

    public Product getProductInCartByName(String prdName) {
        return shoppingCartDAO.getProductInCartByName(prdName);
    }

    public Product editProductQuantity(String prdName, int quantity) {
        return shoppingCartDAO.editProductQuantity(prdName, quantity);
    }

    public List<Product> showProductsAlphabetical() {
        return shoppingCartDAO.showProductsAlphabetical();
    }

    public List<Product> getAllProductsInCart() {
        return shoppingCartDAO.getAllProductsInCart();
    }

    public String showShoppingCartDetails() {
        return shoppingCartDAO.showShoppingCartDetails();
    }    
}
