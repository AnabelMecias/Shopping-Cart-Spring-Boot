package com.techbee.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techbee.DAO.ProductDAO;

@Service
public class ProductService {
    
    @Autowired
    private ProductDAO productDAO;

    public String getMessageProductTest(){
        return productDAO.getMessageProductTest();
    }
}
