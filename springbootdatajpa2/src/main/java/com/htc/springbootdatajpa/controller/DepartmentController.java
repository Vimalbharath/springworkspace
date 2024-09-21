package com.htc.springbootdatajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.htc.springbootdatajpa.dto.DepartmentDTO;
import com.htc.springbootdatajpa.dto.EmployeeDTO;
import com.htc.springbootdatajpa.model.Department;
import com.htc.springbootdatajpa.model.Employee;
import com.htc.springbootdatajpa.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
	
	@RequestMapping(value="/dto/info",method=RequestMethod.GET)
	public String info() {
		return "{'msg':'Welcome to Springboot'}";
	}
	@PostMapping(value="/dto/department", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addDepartment(@RequestBody@Validated DepartmentDTO dept) {
          String response = "";
          if( departmentService.addDepartmentDTO(dept) )
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
	
	@PostMapping(value="/dto/employee/{deptid}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String addEmployee(@PathVariable(name="deptid")int deptid,
			@RequestBody@Validated EmployeeDTO emp) {
		String response = "";
      if( departmentService.addEmployeeDTO(deptid, emp) )
      {
            response =  "{'status': 'success'}";
      }
      else {
            response=  "{'status': 'fail'}";
      }
		return response;
	}
	
}
