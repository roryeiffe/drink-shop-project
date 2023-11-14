package com.revature.service;

import com.revature.model.Product;
import com.revature.repository.ProductRepository;


import java.util.List;
import java.util.Map;

public class ProductService {
    private final ProductRepository productRepository;
    // generate 2 methods: getAllProducts and getProductsByQuery
    // Ensure the parameters of these methods are tested for nulls/empty strings
    // getProductsByQuery should take in a map of query parameters and return a list of products
    // that correspond to those parameters:

    // Include an instance of the ProductRepository to call
    // the getProductsByQuery method from the ProductRepository class
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getProductsByQuery(Map<String, String> queryParams) {
        // Return a list of products that the name value in queryParams matches
        return productRepository.getProductsByQuery(queryParams);
    }

    public List<Product> getAllProducts() {
        // Return a list of all products
        return productRepository.getAllProducts();
    }

// Create method to check params are not null or empty from a HashMap
    public boolean checkParams(Map<String, String> queryParams) {
        // If any of the params are null or empty, return false
        if (queryParams.isEmpty()) {
            return false;
        }
        // If any of the values for the keys are null or empty strings, return false
        for (String key : queryParams.keySet()) {
            if (queryParams.get(key) == null || queryParams.get(key).isEmpty()) {
                return false;
            }
            // If any of the keys are not "category" or "price", return false
            if (!key.equals("category") && !key.equals("price")) {
                return false;
            }
        }
        // If all the params are valid, return true
        return true;
    }


}
