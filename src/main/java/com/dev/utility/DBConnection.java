package com.dev.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection con;
	
	public static Connection getConnection() {
		try {
			String url="jdbc:postgresql://localhost:5432/LibraryMgmt";
			String user="postgres";
			String pwd="jvd";
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(url,user,pwd);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
}
