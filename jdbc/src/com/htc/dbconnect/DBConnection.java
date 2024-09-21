package com.htc.dbconnect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
String url,username,password;
	
	public Connection getConnection()
	{
		//connection object
		Connection con = null;
		try {
		//opening a file for read
		FileReader fr = new FileReader("C:\\Users\\MSD\\Documents\\workspace-spring-tool-suite-4-4.21.1.RELEASE\\jdbc\\src\\db.properties");
		//object creation for property
		Properties prop = new Properties();
		//loading data from property file
		prop.load(fr);
		this.url = prop.getProperty("jdbc_url");
		this.username = prop.getProperty("jdbc_username");
		this.password = prop.getProperty("jdbc_password");
				
			//System.out.println(url+" "+username);
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}


}
