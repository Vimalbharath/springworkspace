package com.htc.dao;

import java.util.ArrayList;
import java.util.Date;

import com.htc.entity.Employee;
import com.htc.exceptions.EmployeeNotFoundException;

public class DeptDAOImpl implements DeptInterface {
	
	public int deptId;
	public String deptName;
	//public Employee emp;
	public ArrayList<Employee> empList = new ArrayList<Employee>();
	@Override
	public String toString() {
		return "DeptDAOImpl [deptId=" + deptId + ", deptName=" + deptName + ", empList=" + empList + "]";
	}
	
	
	
	public DeptDAOImpl(int deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}

	
	public DeptDAOImpl() {
		super();
	}

	
	
//	public DeptDAOImpl(int deptId, String deptName, Employee emp) {
//		super();
//		this.deptId = deptId;
//		this.deptName = deptName;
//		this.emp = emp;
//	}

	
	
	
	
	

	@Override
	public boolean addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		empList.add(emp);
		
		return true;
	}

	@Override
	public Employee getEmployee(int empId) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		Employee e=null;
		for (Employee temp : empList) {
			if(temp.getEmpId()==empId)
				e=temp;
		}
		if(e==null)
			throw new EmployeeNotFoundException("Employee Not found",new Date());
		
		
		return e;
	}

	@Override
	public ArrayList<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
//		ArrayList<Employee> empList1 = new ArrayList<Employee>();
//		
//		for (Employee temp : empList) {
//			empList1.add(temp);
//		}
		
		
		return empList;
		
	}

	@Override
	public Employee updateEmployee (int empId, String Designation) throws EmployeeNotFoundException{
		// TODO Auto-generated method stub
		Employee e=null;
		for (Employee temp : empList) {
			if(temp.getEmpId()==empId)
				temp.setDesignation(Designation);
			return e;
		}
		if(e==null)
			throw new EmployeeNotFoundException("Employee Not found",new Date());
		
		
		return e;
		
	}

	@Override
	public boolean deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		for (Employee temp : empList) {
			if(temp.getEmpId()==empId) {
				empList.remove(temp);
				return true;
			}
				
		}
		return false;
	}
	public boolean deleteEmployee() {
		// TODO Auto-generated method stub
		for (Employee temp : empList) {
			if(temp.getDesignation()=="Terminated") {
				empList.remove(temp);
				return true;
			}
				
		}
		return false;
	}

}
