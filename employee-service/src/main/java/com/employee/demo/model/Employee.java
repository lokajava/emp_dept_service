package com.employee.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Employee {

	private static final long MAX_RANGE = 9999999999L;
	@Id
	@Column(name = "employee_no")
	@Range(min=0, max=MAX_RANGE)
	private int employeeNumber;
	@Column(name = "employee_name")
	@Size(max = 100)
	private String employeeName;
	@Column(name = "date_of_joining")
	@Size(max = 10)
	private String dateOfJoining;
	@Column(name = "department_code")
	@Size(max = 2)
	private String departmentCode;
	@Column(name="salary")
	@Max(value = MAX_RANGE)
	private Double salary;
	
	//private Department department;
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getDepartment() {
		return departmentCode;
	}
	public void setDepartment(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
}
