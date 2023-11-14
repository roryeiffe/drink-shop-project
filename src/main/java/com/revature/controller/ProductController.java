package com.revature.controller;

import com.revature.model.Product;
import com.revature.service.ProductService;
import com.revature.util.HttpHelper;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.util.Map;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

// Create a Product Controller Class using HttpServer, include a constructor, a getAllProducts method, and 
// a method that takes in query parameters and returns a list of products based on the fields:
// This Controller class should utilize the ProductService class

public class ProductController {
    private HttpServer server;

    private ProductService productService;

    public ProductController(HttpServer server,ProductService productService) {
        this.productService = productService;
        this.server = server;
    }

    public void setEndpoints() {
        server.createContext("/products", this::getAllProducts);
        server.createContext("/products/filter", this::getProductsByQuery);
    }

    // set up private methods: getAllProducts and getProductsByQuery
    private void getAllProducts(HttpExchange exchange) throws IOException{
        // get all products
        List<Product> products = productService.getAllProducts();
        // send the response back to the client
        if (products == null) {
            exchange.sendResponseHeaders(404, 0);
        } else {
            exchange.sendResponseHeaders(200, 0);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(products.toString().getBytes());
                os.flush();
                os.close();
                exchange.close();
            } catch (IOException e) {
                e.printStackTrace();    
            }
        }
    }

    private void getProductsByQuery(HttpExchange exchange) throws IOException {
        // get the query parameters from the request, using the helper methods from the HttpHelper class
        Map<String, String> queryParams = HttpHelper.parseQueryParams(exchange.getRequestURI().toString());
        // get the products by query parameters
        List<Product> products = productService.getProductsByQuery(queryParams);
        // send the response back to the client
        if (products == null) {
            exchange.sendResponseHeaders(404, 0);
        } else {
            exchange.sendResponseHeaders(200, 0);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(products.toString().getBytes());
                os.flush();
                os.close();
                exchange.close();
            } catch (IOException e) {
                e.printStackTrace();    
            }   
        }

    }
    

}
