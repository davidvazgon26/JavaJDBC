package com.lynda.javatraining.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lynda.javatraining.db.tables.Tours;

public class Main {

	public static void main(String[] args) throws Exception {

		try (
				Connection conn = DBUtil.getConnection(DBType.HSQLDB);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(
						"SELECT tourId, tourName, price FROM tours "+"LIMIT 10, 5" );
				) {
			Tours.displayData(rs);
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

}
