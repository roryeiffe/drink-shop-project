package com.revature;

import com.revature.controller.ProductController;
import com.revature.repository.ProductRepository;
import com.revature.service.ProductService;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);

        new ProductController(server, new ProductService(new ProductRepository())).setEndpoints();

        server.start();
    }

}
