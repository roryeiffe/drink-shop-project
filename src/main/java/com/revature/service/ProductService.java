package com.revature.service;

import com.revature.model.Product;
import com.revature.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public List<Product> getProductsByQuery(Map<String, String> queryParams) {
        if(!checkParams(queryParams)) return null;

        return productRepository.findByName(queryParams.get("name"));
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public boolean checkParams(Map<String, String> queryParams) {
        if (queryParams.isEmpty()) {
            return false;
        }
        for (String key : queryParams.keySet()) {
            if (queryParams.get(key) == null || queryParams.get(key).isEmpty()) {
                return false;
            }
            if (!key.equals("name")) {
                return false;
            }
        }
        return true;
    }


}
