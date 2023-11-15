package com.revature.repository;

import com.revature.model.Product;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The ProductRepository class is responsible for interacting with the database to fetch product data.
 * It uses the ConnectionFactory to establish a connection with the database and executes SQL queries to fetch data.
 * The data fetched from the database is then used to create Product objects which are returned by the methods.
 */
public class ProductRepository {

    /**
     * Fetches all products from the database.
     * It establishes a connection with the database, executes a SQL query to fetch all products, and then creates Product objects from the fetched data,
     * inserting them into the 'products' ArrayList.
     * @return a List of Product objects representing all products in the database.
     */
	public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM product";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) throw new RuntimeException("No products found");
            while (rs.next()) {
                products.add(new Product(rs.getString("name"), rs.getDouble("price"), rs.getInt("calories"), rs.getString("category")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;

    }

    /**
     * Fetches products from the database based on the product name.
     * It establishes a connection with the database, executes a SQL query to fetch products with a name matching the provided name,
     * and then creates Product objects from the fetched data, inserting them into the 'products' ArrayList.
     * @param name the name of the product to fetch from the database.
     * @return a List of Product objects representing the products with a name matching the provided name.
     */
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM product WHERE LOWER(name) LIKE lower(?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                products.add(new Product(rs.getString("name"), rs.getDouble("price"), rs.getInt("calories"), rs.getString("category")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

}
