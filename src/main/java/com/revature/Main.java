package com.revature;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.revature.controller.ProductController;
import com.revature.service.ProductService;
import com.sun.net.httpserver.HttpServer;

// create a main class with empty main method:
public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize the server on port 8080 and use the ProductController
        HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);

        new ProductController(server, new ProductService()).setEndpoints();

        server.start();

    }
}
