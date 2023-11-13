package com.revature.service;

import com.revature.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductService {
    public List<Product> getProductsByQuery(Map<String, String> queryParams) {
        boolean hasCategory = queryParams.containsKey("category");
        boolean hasName = queryParams.containsKey("name");
        List<Product> products = new ArrayList<>();
        if(hasCategory && hasName) {
            products.add(new Product("Fuzzy Taun-Taun", 11.99, 300, "Cocktail"));
        }
        else if(hasCategory) {
            products.add(new Product("Fuzzy Taun-Taun", 11.99, 300, "Cocktail"));
            products.add(new Product("Gin and Tonic", 9.99, 300, "Cocktail"));
        }
        return products;        
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        // add some drinks to the list:
        products.add(new Product("Fuzzy Taun-Taun", 11.99, 300, "Cocktail"));
        products.add(new Product("Gin and Tonic", 9.99, 300, "Cocktail"));
        products.add(new Product("Wake-Up Punch", 12.99, 200, "Coffee"));
        products.add(new Product("Up and About", 12.99, 400, "Coffee"));
        return products;
    }




}
