/**
 * DB connector class for linking to the database
 */
package com.swift.java.battle.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class DBConnector {
	private static final String CONNECT_STRING = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static final String USERNAME = "HR";
	private static final String PASSWORD = "hr";

	static Connection conn = null;

	public static void open() throws SQLException {
		DriverManager.registerDriver(new OracleDriver());
		conn = DriverManager.getConnection(CONNECT_STRING, USERNAME, PASSWORD);
	}

	public static void close() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
