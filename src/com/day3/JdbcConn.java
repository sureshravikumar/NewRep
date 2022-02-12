package com.day3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcConn {
	public static void main(String[] args) {
		try {

			// 1. Load the Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connect To DB
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "admin");

			// 3. Write SQL Query
			String query = "select * from course";

			// 4. Prepare Statement
			PreparedStatement ps = con.prepareStatement(query);

			// 5. Execute Query
			ResultSet rs = ps.executeQuery();

			// 6. Iterate the Results
			// In table row is presented -----> next() - it will return true
			// In table row is not presented -----> next() - it will return false
			while (rs.next()) {
				int id = rs.getInt("cid");
				String name = rs.getString("cname");
				System.out.println("CID : " + id + " CNAME : " + name);
			}

			// 7. Close DB Connection
			con.close();

		} catch (ClassNotFoundException | SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some Error Occured");
			System.out.println("Error Occured");
			System.out.println("Error Occured");
		}
	}
}
