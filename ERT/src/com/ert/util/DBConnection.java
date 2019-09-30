package com.ert.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private DBConnection() {

	}

	public static Connection createConnection() {
		// TODO Move connection details to a properties file.
		// TODO Implement Log4j and replace Sysouts for logging.

		// Specify parameters to create a connection
		Connection con = null;
		final String DB_URL = "jdbc:mysql://localhost:3306/d3now";
		final String DB_USERNAME = "admin";
		final String DB_PASSWORD = "Q1w2e3r4t5y6";
		final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

		// create a connection and return it
		try {
			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ERROR: DBConnection.createConnection ->" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("ERROR: DBConnection.createConnection ->" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("ERROR: DBConnection.createConnection ->" + e.getMessage());
		}

		return con;
	}
}