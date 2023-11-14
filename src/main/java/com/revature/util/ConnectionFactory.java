package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Create a class that will handle all connections to our h2 database following a singleton and factory design pattern
public class ConnectionFactory {

	private static ConnectionFactory cf = new ConnectionFactory();

	private ConnectionFactory() {
		super();
	}



	public static ConnectionFactory getInstance() {
		return cf;
	}

	public Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return conn;
	}
}