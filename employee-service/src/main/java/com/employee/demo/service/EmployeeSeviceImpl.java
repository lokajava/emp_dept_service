package com.employee.demo.service;

import java.util.List;

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
@Service
public class EmployeeSeviceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	@Override
	public Employee addEmployee(Employee employee) {
		if(employeeRepository.existsById(employee.getEmployeeNumber())) {
			throw new EmployeeAlreadyExistsException("employee already exists with given employee number");
		}
		if(employee.getEmployeeName().matches("[a-zA-Z]+")==false)
		{
			throw new LimitExceedException("only alphabet characters are allowed for employee name");
		}
		else if(employee.getEmployeeNumber()>9999999999L||employee.getEmployeeName().length()>100||employee.getSalary()>9999999999L)
		{
			throw new LimitExceedException("Entered value is beyond limit");
		}
		else
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployee(Long employeeNumber) {
		if(employeeRepository.existsById(employeeNumber)==false)
		{
			throw new EmployeeNotFoundException("employee with given employee Number not found");
		}
		return employeeRepository.getById(employeeNumber);
	}

	@Override
	public Employee updateEmployee(Long employeeNumber,Employee employee) {

		if(employeeRepository.existsById(employeeNumber)==false)
		{
			throw new EmployeeNotFoundException("employee with given employee Number not found");
		}
		Employee emp=employeeRepository.getById(employeeNumber);
		emp.setDateOfJoining(employee.getDateOfJoining());
		emp.setEmployeeName(employee.getEmployeeName());
		emp.setDepartment(employee.getDepartment());
		return employeeRepository.save(emp);
	}

	@Override
	public String deleteEmployee(Long employeeNumber) {
		if(employeeRepository.existsById(employeeNumber)==false)
		{
			throw new EmployeeNotFoundException("employee with given employee Number not found");
		}
		employeeRepository.deleteById(employeeNumber);
		 return "Employee with id "+employeeNumber+" deleted successfully";
	}
	@Override
	public EmployeeDepartment listOfEmployeeWithDepartmentDetails(String departmentCode)
	{
		if(departmentRepository.existsByDepartmentCode(departmentCode)==false)
		{
			throw new DepartmentNotFoundException("department with given department code not exists");
		}
		EmployeeDepartment employeeDepartment=new EmployeeDepartment();
		
		List<Employee> employees=employeeRepository.getEmployeeByDepartmentCode(departmentCode);
		Department department=departmentRepository.getByDepartmentCode(departmentCode);
		employeeDepartment.setDepartment(department);
		employeeDepartment.setEmployees(employees);
		return employeeDepartment;
	}
}
