package com.revature;

import com.revature.controller.ProductController;
import com.revature.model.Product;
import com.revature.repository.ProductRepository;
import com.revature.util.ConnectionFactory;
import com.sun.net.httpserver.HttpServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// create a main class with empty main method:
public class Main {
    public static void main(String[] args) {
        // set up the HttpServer to use ProductController on port 8080:
        // AI GENERATED CODE:
        // HttpServer server = HttpServer.create();
        // ProductRepository productRepository = new ProductRepository();
        // server.bind(new ProductController(new ProductService(productRepository)), 8080);

        // server.start();

    }

    // Create a static method that would generate a h2 database table with a list of 25 products for our users to query
    // when the application is initialized.
    // This method would be called from the main method.
    public static void createProductsTable() {
        Connection conn = ConnectionFactory.getInstance().getConnection();
        String sql = "CREATE TABLE products (id SERIAL PRIMARY KEY, name VARCHAR(255), price DECIMAL(10,2))";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        // Create another static method that would generate a list of 25 products for our users to query
        // when the application is initialized.
        // This method would be called from the main method.
        public static void createProducts () {
            Connection conn = ConnectionFactory.getInstance().getConnection();
            String sql = "INSERT INTO products (name, price) VALUES (?, ?)";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                for (int i = 1; i <= 25; i++) {
                    stmt.setString(1, "Product " + i);
                    stmt.setDouble(2, (double) i);
                    stmt.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
