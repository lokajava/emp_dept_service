package com.employee.demo.service;
import com.employee.demo.model.Employee;
import com.employee.demo.model.EmployeeDepartment;

public interface EmployeeService {

	Employee addEmployee(Employee employee);
	Employee getEmployee(Long employeeNumber);
	Employee updateEmployee(Long employeeNumber,Employee employee);
	String deleteEmployee(Long employeeNumber);
	//List<Employee> listOfEmployeeWithSameDepartment(String departmentCode);
	EmployeeDepartment listOfEmployeeWithDepartmentDetails(String departmentCode);
}
