package com.revature.service;

import com.revature.model.Product;
import com.revature.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// TODO: Document the purpose & describe what this class does using JavaDocs
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    // TODO: Document the purpose & describe what this method does using JavaDocs
    // TODO: Add unit tests for this method
    public List<Product> getProductsByQuery(Map<String, String> queryParams) {
        if(!checkParams(queryParams)) return null;

        return productRepository.findByName(queryParams.get("name"));
    }

    // TODO: Document the purpose & describe what this method does using JavaDocs
    // TODO: Add unit tests for this method
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // TODO: Document the purpose & describe what this method does using JavaDocs
    // TODO: Add unit tests for this method
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
