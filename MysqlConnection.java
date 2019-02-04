package com.connectionprovider;

import java.sql.Connection;
import java.sql.DriverManager;


public class MysqlConnection {
public static Connection getMysqlConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/companypractice","root","root");	
        
		return con;
}
}