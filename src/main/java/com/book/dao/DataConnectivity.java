package com.book.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnectivity {
	public Connection dbconnection() {
		Connection conn=null;
				
				String url="jdbc:mysql://localhost:3306/bookapp";
				String username="root";
				String password="mysql";
				
				try {
					conn=DriverManager.getConnection(url, username, password);
					if (conn != null) {
						System.out.println();
					}
				} catch (SQLException e) {
					
					System.out.println("Server Problem!..");
				}

		     return conn;
		}

}
