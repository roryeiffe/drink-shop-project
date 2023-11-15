package com.revature.service;

import com.revature.model.Product;
import com.revature.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The ProductService class is responsible for handling product-related business logic.
 * It uses an instance of ProductRepository to fetch product data from the database.
 * This class provides methods for getting all products and getting products based on query parameters, current iteration specifically requires 'name' param only.
 */
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    /**
     * Fetches products from the database based on the provided query parameters, using the ProductRepository.
     * If the query parameters are not valid, it returns null.
     * @param queryParams a Map of query parameters where the key is the parameter name and the value is the parameter value.
     * @return a List of Product objects representing the products with a name matching the provided name, or null if the query parameters are not valid.
     */
    public List<Product> getProductsByQuery(Map<String, String> queryParams) {
        if(!checkParams(queryParams)) return null;

        return productRepository.findByName(queryParams.get("name"));
    }

    /**
     * Fetches all products from the database using the productRepository.
     * @return a List of Product objects representing all products in the database.
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Checks the validity of the provided query parameters.
     * A query parameter is considered valid if it is not null, not empty, and its name is "name".
     * @param queryParams a Map of query parameters where the key is the parameter name and the value is the parameter value.
     * @return true if all query parameters are valid, false otherwise.
     */
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
