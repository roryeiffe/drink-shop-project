package com.revature.repository;

import com.revature.model.Product;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// TODO: Document the purpose & describe what this class does using JavaDocs
public class ProductRepository {

    // TODO: Document the purpose & describe what this method does using JavaDocs
	public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM products";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) throw new RuntimeException("No products found");
            while (rs.next()) {
                products.add(new Product(rs.getString("name"), rs.getDouble("price"), rs.getInt("calories"), rs.getString("category")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;

    }

    // TODO: Document the purpose & describe what this method does using JavaDocs
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM products WHERE LOWER(name) LIKE lower(?)";
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
