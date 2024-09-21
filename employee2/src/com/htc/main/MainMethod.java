package com.htc.main;

import java.util.ArrayList;

import com.htc.dao.DeptDAOImpl;
import com.htc.entity.Employee;
import com.htc.entity.Department;
import com.htc.exceptions.EmployeeNotFoundException;

public class MainMethod {
  public static void main(String [] args) throws EmployeeNotFoundException {
	  System.out.println("Hello");
	  DeptDAOImpl impl=new DeptDAOImpl();
	   ArrayList<Employee> empList = new ArrayList<Employee>();
	  //Employee emp=new Employee();
	  Department Dept1= new Department(1,"Board",empList);
	  Department Dept2= new Department(1,"Marketing");
	  Department Dept3= new Department(1,"Finance");
	  impl.addEmployee(new Employee(101,"Vimal","Remote","CEO"));
	  impl.addEmployee(new Employee(102,"Bharath","Remote","CTO"));
	  System.out.println(impl.getEmployee(102));
	  System.out.println(impl.updateEmployee(102, "Terminated"));
	  try {
		  System.out.println(impl.updateEmployee(103, "Terminated")); 
	  }finally {
	  
	  System.out.println(impl.getEmployee(102));
	  System.out.println(impl.deleteEmployee(102));
	  System.out.println(impl.getAllEmployee());
	  System.out.println(impl);
	  
	  }
  }
}
