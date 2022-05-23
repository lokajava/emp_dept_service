package com.employee.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.employee.demo.exception.DepartmentNotFoundException;
import com.employee.demo.exception.EmployeeAlreadyExistsException;
import com.employee.demo.exception.EmployeeNotFoundException;
import com.employee.demo.model.Employee;
import com.employee.demo.model.EmployeeDepartment;
import com.employee.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class  EmployeeController {
	@Autowired
	EmployeeService service;
	
	@RequestMapping("/")
	public ModelAndView home()
	{
		return new ModelAndView("home");
	}
	 @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	 @ExceptionHandler(value=EmployeeAlreadyExistsException.class)
	 public ResponseEntity addEmployee(Employee employee)	
		{
			
		 try {
			 return new ResponseEntity(service.addEmployee(employee), HttpStatus.OK);
		 }
			catch(RuntimeException e)
		 {
				if(employee.getEmployeeNumber()>9999999999L||employee.getEmployeeName().length()>100||employee.getSalary()>9999999999L)
				{
					return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
				}
				if(employee.getEmployeeName().matches("[a-zA-Z]+")==false)
				{
					return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT); 
				}
				return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		 }
		}
	@GetMapping("/get/{employeeNumber}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long employeeNumber)
	{
		try {
			return new ResponseEntity<Employee>(service.getEmployee(employeeNumber), HttpStatus.OK) ;
		}
		catch(EmployeeNotFoundException e)
		{
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		}


	}
	@PutMapping("/update/{employeeNumber}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeNumber, @RequestBody Employee employee)
	{
		try
		{
			return new ResponseEntity<Employee>(service.updateEmployee(employeeNumber, employee), HttpStatus.OK);
		}
		catch(EmployeeNotFoundException e)
		{
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long empId)
	{
		try
		{
			return new ResponseEntity<String>(service.deleteEmployee(empId), HttpStatus.OK);
		}
		catch(EmployeeNotFoundException e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		
	}
	@GetMapping("/list/{departmentCode}")
	public ResponseEntity list(@PathVariable String departmentCode)
	{
		try
		{
			return new ResponseEntity<EmployeeDepartment>(service.listOfEmployeeWithDepartmentDetails(departmentCode), HttpStatus.OK);
		}
		catch(DepartmentNotFoundException e)
		{
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

}
