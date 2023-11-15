package com.revature.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Main;
import com.revature.model.Product;
import com.revature.service.ProductService;
import com.revature.util.HttpHelper;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.util.Map;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * The ProductController class is responsible for handling HTTP requests related to products.
 * It defines endpoints for retrieving all products and filtering products based on query parameters.
 * This class uses an instance of ProductService to fetch product data and ObjectMapper to convert product data to JSON format.
 */
public class ProductController {
    private HttpServer server;
    private ObjectMapper objectMapper = new ObjectMapper();
    private ProductService productService;

    public ProductController(HttpServer server,ProductService productService) {
        this.productService = productService;
        this.server = server;
    }

    /**
     * Sets up the endpoints for this controller.
     * Currently, it creates two contexts: "/products" for getting all products and "/products/filter" for getting products based on query parameters.
     */
    public void setEndpoints() {
        server.createContext("/products", this::getAllProducts);
        server.createContext("/products/filter", this::getProductsByQuery);
    }

    /**
     * Handles the GET request to fetch all products.
     * It uses the ProductService to fetch all products and then sends the products as a JSON response.
     * If no products are found, it sends a 404 response.
     * @param exchange the HttpExchange representing the HTTP request and response.
     */
    private void getAllProducts(HttpExchange exchange) {
        List<Product> products = productService.getAllProducts();
        String payload = null;
        try {
            payload = objectMapper.writeValueAsString(products);


            if (products == null) {
                exchange.sendResponseHeaders(404, 0);
            } else {
                exchange.sendResponseHeaders(200, payload.getBytes().length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(payload.getBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the GET request to fetch products based on query parameters.
     * It parses the query parameters from the request URL, uses the ProductService to fetch matching products, and then sends the products as a JSON response.
     * If no matching products are found, it sends a 404 response.
     * @param exchange the HttpExchange representing the HTTP request and response.
     * @throws IOException if an I/O error occurs.
     */
    void getProductsByQuery(HttpExchange exchange) throws IOException {
        Map<String, String> queryParams = HttpHelper.parseQueryParams(exchange.getRequestURI().toString());
        List<Product> products = productService.getProductsByQuery(queryParams);

        String payload = objectMapper.writeValueAsString(products);

        if (products == null) {
            exchange.sendResponseHeaders(404, 0);
        } else {
            exchange.sendResponseHeaders(200, payload.getBytes().length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(payload.getBytes());
                os.flush();
                exchange.close();
            } catch (IOException e) {
                e.printStackTrace();    
            }   
        }
    }
}
