package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
			conn = DriverManager.getConnection("jdbc:h2:mem:test;INIT=runscript from 'src/main/resources/create.sql'\\;runscript from 'src/main/resources/init.sql'", "sa", "");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

        return conn;
	}
}