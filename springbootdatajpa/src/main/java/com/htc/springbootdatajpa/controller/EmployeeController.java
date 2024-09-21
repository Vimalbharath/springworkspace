package com.htc.springbootdatajpa.controller;




import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.htc.springbootdatajpa.model.Department;
import com.htc.springbootdatajpa.model.Employee;
import com.htc.springbootdatajpa.model.Skill;
import com.htc.springbootdatajpa.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="/info",method=RequestMethod.GET)
	public String info() {
		return "{'msg':'Welcome to Springboot'}";
	}
	
//	@PostMapping(value="/employee", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> addEmployee(@RequestBody Employee emp) {
//          String response = "";
//          if( employeeService.addEmployee(emp) )
//          {
//                response =  "{'status': 'success'}";
//          }
//          else {
//                response=  "{'status': 'fail'}";
//          }
//          
//          HttpHeaders headers = new HttpHeaders();
//          headers.add("Content-Type", "application/json");
//          headers.add("Access-Control-Allow-Origin", "*");
//          headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
//          headers.add("Access-Control-Allow-Methods", "GET,PUT,DELETE,POST,OPTIONS");
//          
//          ResponseEntity<String> respEntity = new ResponseEntity<String>(response, headers, HttpStatus.CREATED);
//          return respEntity;
//    }
	@PostMapping(value="/department", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addDepartment(@RequestBody Department dept) {
          String response = "";
          if( employeeService.addDepartment(dept) )
          {
                response =  "{'status': 'success'}";
          }
          else {
                response=  "{'status': 'fail'}";
          }
          
          HttpHeaders headers = new HttpHeaders();
          headers.add("Content-Type", "application/json");
          headers.add("Access-Control-Allow-Origin", "*");
          headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
          headers.add("Access-Control-Allow-Methods", "GET,PUT,DELETE,POST,OPTIONS");
          
          ResponseEntity<String> respEntity = new ResponseEntity<String>(response, headers, HttpStatus.CREATED);
          return respEntity;
    }
	
	@PostMapping(value="/employee/{deptid}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String addEmployee(@PathVariable(name="deptid")int deptid,
			@RequestBody Employee emp) {
		String response = "";
      if( employeeService.addEmployee(deptid, emp) )
      {
            response =  "{'status': 'success'}";
      }
      else {
            response=  "{'status': 'fail'}";
      }
		return response;
	}
	@PostMapping(value="/skill", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String addSkill(@RequestBody Skill sk) {
		String response = "";
      if( employeeService.addSkill(sk) )
      {
            response =  "{'status': 'success'}";
      }
      else {
            response=  "{'status': 'fail'}";
      }
		return response;
	}
	@RequestMapping(value="/employee/{empid}",method=RequestMethod.GET)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(name="empid")int empid) {
		Employee emp=employeeService.getEmployeeById(empid);
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Employee> respEntity;
		
		if( emp!=null )
        {
			 respEntity = new ResponseEntity<Employee>(emp, headers, HttpStatus.OK);
        }
        else {
             respEntity = new ResponseEntity<Employee>( HttpStatus.NOT_FOUND);
        }
		return respEntity;
	}
	 
	@GetMapping(value="/employees/{empid}")
	public Employee getEmployeeById2(@PathVariable(name="empid")int empid){
		Employee employees=employeeService.getEmployeeById(empid);
		System.out.println(employees);
		return employees;
	}
	
	@GetMapping(value="/employees")
	public List<Employee> getAllEmployees(){
		List<Employee> employees=employeeService.getAllEmployees();
		System.out.println(employees);
		return employees;
	}
	
	@GetMapping(value="/employees/{lower}/{upper}")
	public List<Employee> getEmployeesbetween(@PathVariable(name="lower")int lower,
			@PathVariable(name="upper")int upper){
		List<Employee> employees=employeeService.getByageBetween(lower, upper);
		System.out.println(employees);
		return employees;
	}
	
	@GetMapping(value="/emplocation")
	public List<Employee> getEmployeesByLocation(@RequestBody Collection<String> locations){
		List<Employee> employees=employeeService.getByLocation(locations);
		System.out.println(employees);
		return employees;
	}
	
	@GetMapping(value="/skills")
	public List<Skill> getAllSkills(){
		List<Skill> employees=employeeService.getAllSkills(); 
		System.out.println(employees);
		return employees;
	}
	
	@GetMapping(value="/departments")
	public List<Department> getAllDepartments(){
		List<Department> employees=employeeService.getAllDepartments(); 
		System.out.println(employees);
		return employees;
	}
	
	@PutMapping(value="/employee/{empid}/skill/{skillid}")
	public String addEmpSkill(@PathVariable(name="empid")int empid,
			@PathVariable(name="skillid")int skillid) {
		String response = "";
	      if( employeeService.emphasthisskill(empid, skillid) )
	      {
	            response =  "{'status': 'success'}";
	      }
	      else {
	            response=  "{'status': 'fail'}";
	      }
			return response;
	}
	
}
