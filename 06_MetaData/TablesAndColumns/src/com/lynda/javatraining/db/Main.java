package com.lynda.javatraining.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {

		Connection conn = ConnectionManager.getInstance().getConnection();
		ResultSet rsTables = null;
		ResultSet rsColumns = null;
		ArrayList<String> tables = new ArrayList<>();
		
		try  {
			
			DatabaseMetaData metadata = conn.getMetaData();
			String[] tableTypes = {"TABLE"};
			rsTables = metadata.getTables(null, "%", "%", tableTypes);
			while (rsTables.next()) {
//				System.out.println(rsTables.getString("TABLE_NAME"));
				tables.add(rsTables.getString("TABLE_NAME"));
			}

			for (String tableName: tables) {
				System.out.println("Tables: " + tableName);
				System.out.println("----------------------");

				rsColumns = metadata.getColumns(null,"%", tableName, "%");

				while(rsColumns.next()){
					StringBuffer buffer = new StringBuffer();
					buffer.append(rsColumns.getString("COLUMN_NAME"));
					buffer.append(": ");
					buffer.append(rsColumns.getString("TYPE_NAME"));
					System.out.println(buffer.toString());
				}

				System.out.println();
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		finally {
			rsTables.close();
			rsColumns.close();
		}
		
		ConnectionManager.getInstance().close();
		
	}

}
