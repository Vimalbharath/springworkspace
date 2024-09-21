package com.htc.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.htc.dbconnect.DBConnection;
import com.htc.entity.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void readFromExcel() throws IOException, SQLException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\MSD\\Documents\\workspace-spring-tool-suite-4-4.21.1.RELEASE\\jdbc\\src\\com\\htc\\dao\\employee.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rows = sheet.iterator();
		rows.next();
		while(rows.hasNext())
		{
			Row row = rows.next();
			Iterator<Cell> cells = row.cellIterator();
			while(cells.hasNext())
			{
				Cell cell = cells.next();
				double empid = (double)cell.getNumericCellValue();
				
				cell = cells.next();
				String empname = cell.getStringCellValue();
				
				cell = cells.next();
				String address = cell.getStringCellValue();
				
				cell = cells.next();
				String designation = cell.getStringCellValue();
				
				cell = cells.next();
				double salary = (double)cell.getNumericCellValue();
				
				loadEmployeeData(new Employee(empid,empname,address,designation,salary));
			}
			
		}
		
	}

	@Override
	public void loadEmployeeData(Employee emp) throws SQLException {
		// TODO Auto-generated method stub
		DBConnection dbconnect = new DBConnection();
		Connection con = dbconnect.getConnection();
		PreparedStatement pstmt = con.prepareStatement("insert into emp values(?,?,?,?,?)");
		pstmt.setDouble(1, emp.getEmpId());
		pstmt.setString(2, emp.getEmpName());
		pstmt.setString(3, emp.getAddress());
		pstmt.setString(4, emp.getDesignation());
		pstmt.setDouble(5, emp.getSalary());
		pstmt.execute();
	}

	
}
