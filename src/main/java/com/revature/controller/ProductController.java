package com.revature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Product;
import com.revature.service.ProductService;
import com.revature.util.HttpHelper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

// TODO: Document the purpose & describe what this class does using JavaDocs
public class ProductController {
    private HttpServer server;
    private ObjectMapper objectMapper = new ObjectMapper();
    private ProductService productService;

    public ProductController(HttpServer server,ProductService productService) {
        this.productService = productService;
        this.server = server;
    }

    // TODO: Document the purpose & describe what this method does using JavaDocs
    public void setEndpoints() {
        server.createContext("/products", this::getAllProducts);
        server.createContext("/products/filter", this::getProductsByQuery);
    }

    // TODO: Document the purpose & describe what this method does using JavaDocs
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

    // TODO: Document the purpose & describe what this method does using JavaDocs
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
