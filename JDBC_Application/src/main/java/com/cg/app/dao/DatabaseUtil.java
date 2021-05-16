package com.cg.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {
	
	public static Connection con;
	
	static {
		try {
			String path = "jdbc:oracle:thin:@localhost:1521:XE";
			String username = "system";
			String password = "Suhana@123";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(path, username, password);
			System.out.println("----------->Check Connection:-"+con);
		
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	

}