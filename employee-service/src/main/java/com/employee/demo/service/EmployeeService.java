package com.employee.demo.service;
import com.employee.demo.model.Employee;
import com.employee.demo.model.EmployeeDepartment;

public interface EmployeeService {

	Employee addEmployee(Employee employee);
	Employee getEmployee(int employeeNumber);
	Employee updateEmployee(int employeeNumber,Employee employee);
	String deleteEmployee(int employeeNumber);
	//List<Employee> listOfEmployeeWithSameDepartment(String departmentCode);
	EmployeeDepartment listOfEmployeeWithDepartmentDetails(String departmentCode);
}
