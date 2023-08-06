package com.techbee.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techbee.DAO.StoreDAO;
import com.techbee.Model.Product;

@Service
public class StoreService {

    @Autowired
    private StoreDAO storeDAO;

    public StoreService() {
        this.storeDAO = new StoreDAO();
    }

    public Product getProductInInventoryByName(String prdName) {
        return storeDAO.getProductInInventoryByName(prdName);
    }

    public List<Product> getProductsAvailables() {
        return storeDAO.getProductsAvailables();
    }
}
