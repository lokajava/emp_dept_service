package com.employee.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
	List<Employee> getEmployeeByDepartmentCode(String departmentCode);

}
