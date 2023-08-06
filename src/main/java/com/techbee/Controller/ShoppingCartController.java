package com.techbee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techbee.Service.ShoppingCartService;
import com.techbee.Service.StoreService;
import com.techbee.Model.Product;

@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private StoreService storeService;

    //Get Requests
    @GetMapping("/products-store")
    public List<Product> getProductsAvailables() {
        return storeService.getProductsAvailables();
    }

    @GetMapping("/products-cart")
    public List<Product> getAllProductsInCart() {
        return shoppingCartService.getAllProductsInCart();
    }

    @GetMapping("/cart-subtotal")
    public double getSubTotal() {
        return shoppingCartService.getSubTotal();
    }

    @GetMapping("/cart-taxes")
    public double getTotalTax() {
        return shoppingCartService.getTotalTax();
    }
    
    @GetMapping("/cart-details")
    public String showShoppingCartDetails() {
        return shoppingCartService.showShoppingCartDetails();
    }

    @GetMapping("/products-cart-alphabetical")
    public List<Product> showProductsAlphabetical() {
        return shoppingCartService.showProductsAlphabetical();
    }
    
    @GetMapping("/product-cart/{name}")
    public ResponseEntity<Product> getProductInCartByName(@PathVariable("name") String prdName) {
        Product product = shoppingCartService.getProductInCartByName(prdName);
        if(product == null) {
            return new ResponseEntity<Product> (HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product> (product, HttpStatus.OK);
    }

    @GetMapping("/product-store/{name}")
    public ResponseEntity<Product> getProductInInventoryByName(@PathVariable("name") String prdName) {
        Product product = storeService.getProductInInventoryByName(prdName);
        if(product == null) {
            return new ResponseEntity<Product> (product, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product> (product, HttpStatus.OK);
    }

    // POST requests
    @PostMapping("/product/add/{name}/{quantity}")
    public Product addProduct(@PathVariable("name") String prdName,@PathVariable("quantity") int quantity) {
        return shoppingCartService.addProduct(prdName, quantity);
    }

    //PUT requests
    @PutMapping("/product/edit-quantity/{name}/{quantity}")
    public Product editProductQuantity(@PathVariable("name") String prdName,@PathVariable("quantity") int quantity) {
        return shoppingCartService.editProductQuantity(prdName, quantity);
    }

    //DELETE requests
    @DeleteMapping("/product/delete/{name}/{quantity}")
    public Product deleteProduct(@PathVariable("name") String prdName,@PathVariable("quantity") int quantity) {
        return shoppingCartService.deleteProduct(prdName, quantity);
     }
}

