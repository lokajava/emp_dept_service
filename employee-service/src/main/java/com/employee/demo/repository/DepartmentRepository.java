package com.employee.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.demo.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	Department getByDepartmentCode(String departmentCode);
	Boolean existsByDepartmentCode(String departmentCode);
}
