package com.htc.main;

import java.io.IOException;
import java.sql.SQLException;

import com.htc.dao.EmployeeDAO;
import com.htc.dao.EmployeeDAOImpl;

public class Main {
	public static void main(String[] args) throws IOException, SQLException {
		// TODO Auto-generated method stub
		EmployeeDAO empdao = new EmployeeDAOImpl();
		
		empdao.readFromExcel();
		
	}
}
