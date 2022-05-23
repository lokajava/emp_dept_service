package com.employee.demo.model;

import java.util.List;

public class EmployeeDepartment {

	private Department department;
	private List<Employee> employees;
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
