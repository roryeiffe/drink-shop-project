package com.revature.repository;

import com.revature.model.Product;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// Create a Class that connects to our h2 database and finds all products within the table. It should also have methods to
// filter products in the list by name and/or category. All methods will return a list of products.
public class ProductRepository {
	public List<Product> findAll() {
        // Create a Product list to return
        List<Product> products = null;
        // Connect to the database using a try with resources block
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            // Generate a sql query to find all products
            String sql = "SELECT * FROM products";
            // Create a prepared statement
            PreparedStatement ps = conn.prepareStatement(sql);
            // Execute the query
            ResultSet rs = ps.executeQuery();
            // Check if query successful, iterate through the results creating a new Product object for each row
            // and add it to a list. If successful, return the list.
            if (rs.next()) {
                products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
            } else {
                // If unsuccessful, return the Empty list.
                return products;
            }
            // Close the connection to the database.
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    public List<Product> findByName(String name) {
        // Create a Product list to return
        List<Product> products = null;
        // Connect to the database using a try with resources block
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            // Generate a sql query to find all products
            String sql = "SELECT * FROM products WHERE name = ?";
            // Create a prepared statement
            PreparedStatement ps = conn.prepareStatement(sql);
            // Set the parameter for the prepared statement
            ps.setString(1, name);
            // Execute the query
            ResultSet rs = ps.executeQuery();
            // Check if query successful, iterate through the results creating a new Product object for each row
            // and add it to a list. If successful, return the list.
            if (rs.next()) {
                products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
            return products;
        }
        return products;
    }

}
