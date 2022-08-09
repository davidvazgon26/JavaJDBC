package com.lynda.javatraining.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lynda.javatraining.db.tables.States;

public class Main {

	public static void main(String[] args) throws Exception {

		try (Connection conn = DBUtil.getConnection(DBType.HSQLDB);
				Statement stmt = conn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery(
						"SELECT stateId, stateName FROM states");
				) {

			States.displayData(rs);

			rs.last();
			System.out.println("El total de renglones es de: "+ rs.getRow());

			rs.first();
			System.out.println(("El primer valor de la lista es: "+ rs.getString("stateName")));

			rs.last();
			System.out.println(("El ultimo valor de la lista es: "+ rs.getString("stateName")));

			rs.absolute(10);
			System.out.println(("El decimo valor de la lista es: "+ rs.getString("stateName")));

		} catch (SQLException e) {
			System.err.println(e);
		}
	}

}
