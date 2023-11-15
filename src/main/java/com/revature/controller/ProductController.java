package com.revature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Product;
import com.revature.service.ProductService;
import com.revature.util.HttpHelper;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.util.Map;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ProductController {
    private HttpServer server;
    private ObjectMapper objectMapper = new ObjectMapper();
    private ProductService productService;

    public ProductController(HttpServer server,ProductService productService) {
        this.productService = productService;
        this.server = server;
    }

    public void setEndpoints() {
        server.createContext("/products", this::getAllProducts);
        server.createContext("/products/filter", this::getProductsByQuery);
    }

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

    private void getProductsByQuery(HttpExchange exchange) throws IOException {
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
