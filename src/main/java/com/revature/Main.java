package com.revature;

import java.io.*;
import java.net.InetSocketAddress;

import com.revature.controller.ProductController;
import com.revature.service.ProductService;
import com.revature.model.Product;
import com.revature.repository.ProductRepository;
import com.revature.util.ConnectionFactory;
import com.sun.net.httpserver.HttpServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);

        new ProductController(server, new ProductService(new ProductRepository())).setEndpoints();

        server.start();
    }

}
