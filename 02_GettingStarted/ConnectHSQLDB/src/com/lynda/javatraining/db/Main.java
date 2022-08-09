package com.lynda.javatraining.db;

import java.sql.*;

public class Main {

	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "Qwerty78.";
	private static final String CONN_STRING =
			"jdbc:hsqldb:data/explorecalifornia";
	
	public static void main(String[] args) throws SQLException {
		
		//Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = null;
		Statement stmr = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			stmr = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmr.executeQuery("SELECT * FROM states");

			rs.last();
			System.out.println("Number of rows: " + rs.getRow());

//			System.out.println("Connected!");
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmr != null) {
				stmr.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		
	}

}
