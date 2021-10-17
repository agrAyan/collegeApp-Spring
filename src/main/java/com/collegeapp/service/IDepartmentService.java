package com.collegeapp.service;

import java.util.List;

import com.collegeapp.model.Department;
import com.collegeapp.model.DepartmentDto;

public interface IDepartmentService {

	List<DepartmentDto> showDepartments();

	// String addDepartment(String departmentName);
	public DepartmentDto getById(int departmentId);

	public Department addDepartment(Department department);

	public Department getByDepartmentId(int departmentId);

	public List<Department> getAll();

	public Department updateDepartment(Department department);
}
