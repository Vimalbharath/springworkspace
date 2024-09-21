package com.htc.main;

import com.htc.dao.DeptDAOImpl;
import com.htc.entity.Employee;
import com.htc.exceptions.EmployeeNotFoundException;

public class MainMethod {
  public static void main(String [] args) throws EmployeeNotFoundException {
	  System.out.println("Hello");
	  //Employee emp=new Employee();
	  DeptDAOImpl Dept1= new DeptDAOImpl(1,"Board");
	  DeptDAOImpl Dept2= new DeptDAOImpl(1,"Marketing");
	  DeptDAOImpl Dept3= new DeptDAOImpl(1,"Finance");
	  Dept1.addEmployee(new Employee(101,"Dhoni","Remote","CEO"));
	  Dept1.addEmployee(new Employee(102,"Raina","Remote","CTO"));
	  System.out.println(Dept1.getEmployee(102));
	  Dept1.updateEmployee(102, "Terminated");
	  System.out.println(Dept1.deleteEmployee());
	  System.out.println(Dept1.getAllEmployee());
	  System.out.println(Dept1);
	  
	  
  }
}
