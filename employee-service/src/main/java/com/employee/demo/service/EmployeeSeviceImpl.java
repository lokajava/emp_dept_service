package com.employee.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.demo.exception.DepartmentNotFoundException;
import com.employee.demo.exception.EmployeeAlreadyExistsException;
import com.employee.demo.exception.EmployeeNotFoundException;
import com.employee.demo.exception.LimitExceedException;
import com.employee.demo.model.Department;
import com.employee.demo.model.Employee;
import com.employee.demo.model.EmployeeDepartment;
import com.employee.demo.repository.DepartmentRepository;
import com.employee.demo.repository.EmployeeRepository;
import com.employee.demo.util.DateValidator;
@Service
public class EmployeeSeviceImpl implements EmployeeService {

	Employee employee;
	@Autowired
	EmployeeRepository employeeRepository;
	Logger logger = LoggerFactory.getLogger(EmployeeSeviceImpl.class);
	@Autowired
	DepartmentRepository departmentRepository;
	@Override
	public Employee addEmployee(Employee employee) {
		long startTime = System.currentTimeMillis();
		logger.info("EmployeeSeviceImpl.addEmployee started");
		
		if(employeeRepository.existsById(employee.getEmployeeNumber())) {
			throw new EmployeeAlreadyExistsException("Employee already exists with given employee number");
		}
		if(employee.getEmployeeName().matches("[a-zA-Z]+") == false)
		{
			throw new LimitExceedException("Only alphabet characters are allowed for employee name");
		}
		if(employee.getEmployeeNumber()>9999999999L||employee.getEmployeeName().length()>100||employee.getSalary()>9999999999L)
		{
			throw new LimitExceedException("Entered value is beyond limit");
		}
		String date=employee.getDateOfJoining();
		if(DateValidator.isvalidformat("dd/MM/yyyy", date) == false) {
			throw new LimitExceedException("Date format is invalid,please enter date in DD/MM/YYYY format. Example:01/01/2000");
		}
		else
		employee=employeeRepository.save(employee);
		
		long endtime = System.currentTimeMillis();	
		logger.info("Class Name: EmployeeSeviceImpl, Method Name:updateEmployee(), execution is ended and time taken for Execution is : " + (endtime-startTime) +"ms");
		
		return employee;
		
	}

	@Override
	public Employee getEmployee(Long employeeNumber) {
		logger.info("EmployeeSeviceImpl.getEmployee started");
		long startTime = System.currentTimeMillis();
		
        if(employeeRepository.existsById(employeeNumber) == false)
		{
			throw new EmployeeNotFoundException("Employee with given employee number not found");
		}

		employee = employeeRepository.getById(employeeNumber);
		
		long endtime = System.currentTimeMillis();
		logger.info("Class Name: EmployeeSeviceImpl, Method Name:getEmployee(), execution is ended and time taken for Execution is : " + (endtime-startTime) +"ms");
		
        return employee;
	}

	@Override
	public Employee updateEmployee(Long employeeNumber,Employee employee) {
		long startTime = System.currentTimeMillis();
		logger.info("EmployeeSeviceImpl.updateEmployee started");
		
		if(employeeRepository.existsById(employeeNumber) == false)
		{
			throw new EmployeeNotFoundException("Employee with given employee number not found");
		}
		Employee emp=employeeRepository.getById(employeeNumber);
		emp.setDateOfJoining(employee.getDateOfJoining());
		emp.setEmployeeName(employee.getEmployeeName());
		emp.setDepartment(employee.getDepartment());
		emp.setSalary(employee.getSalary());
		
		employee = employeeRepository.save(emp);
		
		long endtime = System.currentTimeMillis();
		logger.info("Class Name: EmployeeSeviceImpl, Method Name:updateEmployee(), execution is ended and time taken for Execution is : " + (endtime-startTime) +"ms");
		
		return employee;
	}

	@Override
	public String deleteEmployee(Long employeeNumber) 
	{
		long startTime = System.currentTimeMillis();
		logger.info("EmployeeSeviceImpl.deleteEmployee started");
		
		if(employeeRepository.existsById(employeeNumber) == false)
		{
			throw new EmployeeNotFoundException("Employee with given employee number not found");
		}
		employeeRepository.deleteById(employeeNumber);
		
		long endtime = System.currentTimeMillis();
		logger.info("Class Name: EmployeeSeviceImpl, Method Name:deleteEmployee(), execution is ended and time taken for Execution is : " + (endtime-startTime) +"ms"); 
		
		return "Employee with id "+employeeNumber+" deleted successfully";
	}
	@Override
	public EmployeeDepartment listOfEmployeeWithDepartmentDetails(String departmentCode)
	{
		long startTime = System.currentTimeMillis();
		logger.info("EmployeeSeviceImpl.listOfEmployeeWithDepartmentDetails started");
		
		if(departmentRepository.existsByDepartmentCode(departmentCode)==false)
		{
			throw new DepartmentNotFoundException("Department with given department code not exists");
		}
		EmployeeDepartment employeeDepartment = new EmployeeDepartment();
		
		List<Employee> employees=employeeRepository.getEmployeeByDepartmentCode(departmentCode);
		Department department=departmentRepository.getByDepartmentCode(departmentCode);
		employeeDepartment.setDepartment(department);
		employeeDepartment.setEmployees(employees);
		
		long endtime = System.currentTimeMillis();
		logger.info("Class Name: EmployeeSeviceImpl, Method Name:listOfEmployeeWithDepartmentDetails(), execution is ended and time taken for Execution is : " + (endtime-startTime) +"ms");
		
		return employeeDepartment;
	}
}
