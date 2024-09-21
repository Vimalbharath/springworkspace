package com.htc.dao;

import java.io.IOException;
import java.sql.SQLException;

import com.htc.entity.Employee;

public interface EmployeeDAO {
	public void readFromExcel()throws IOException,SQLException;
	public void loadEmployeeData(Employee emp)throws SQLException;

}
