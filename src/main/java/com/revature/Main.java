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
        createProductsTable();
        createProducts();

    }

    // TODO: Document the purpose of this method using JavaDocs
    public static void createProductsTable() {
        Connection conn = ConnectionFactory.getInstance().getConnection();
        String sql = "CREATE TABLE IF NOT EXISTS product (name VARCHAR(255) PRIMARY KEY, price DECIMAL(10,2), calories INT, category VARCHAR(255))";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        // TODO: Document the purpose of this method using JavaDocs
        public static void createProducts () throws IOException {
            ArrayList<Product> products = new ArrayList<>();

            BufferedReader  reader = new BufferedReader(new FileReader(new File("src/main/resources/drink-shop-db.csv")));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                products.add(new Product(values[0], Double.parseDouble(values[1]), Integer.parseInt(values[2]), values[3]));
            }

            Connection conn = ConnectionFactory.getInstance().getConnection();
            String sql = "INSERT INTO product (name, price, calories, category) VALUES (?, ?, ?, ?)";
            try {
                PreparedStatement  ps = conn.prepareStatement(sql);
                for (Product product : products) {
                    System.out.println(product.getName());
                    ps.setString(1, product.getName());
                    ps.setDouble(2, product.getPrice());
                    ps.setInt(3, product.getCalories());
                    ps.setString(4, product.getCategory());
                    ps.executeUpdate();
                }

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
