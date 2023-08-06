package com.techbee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techbee.Service.ShoppingCartService;
import com.techbee.Service.StoreService;
import com.techbee.Service.ProductService;

@RestController
@RequestMapping("/products")
public class StoreController {
    
    @Autowired
    private ProductService productService;
    private ShoppingCartService shoppingCartService;
    private StoreService storeService;

    @RequestMapping(method = RequestMethod.GET)
    public String getMessageProductTest (){
        return productService.getMessageProductTest();
    }
}

