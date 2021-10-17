package com.collegeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegeapp.exception.DepartmentNotFoundException;
import com.collegeapp.exception.NoDepartmentFoundException;
import com.collegeapp.model.Department;
import com.collegeapp.model.DepartmentDto;
import com.collegeapp.repository.IDepartmentRepository;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	IDepartmentRepository departmentRepository;

	// show all the departments available in a college
	@Override
	public List<DepartmentDto> showDepartments() {
		List<DepartmentDto> allDepartment = departmentRepository.findAllProjectedBy();
		if (allDepartment.isEmpty())
			throw new NoDepartmentFoundException(" no department availables");
		return allDepartment;
	}

	// to get the details of the department by departmentId using projection
	@Override
	public DepartmentDto getById(int departmentId) {
		DepartmentDto department = departmentRepository.findByDepartmentId(departmentId);
		if (department == null)
			throw new DepartmentNotFoundException("no department at this id found");
		return department;
	}

	// to add a new Department
	@Override
	public Department addDepartment(Department department) {
		// TODO Auto-generated method stub
		Department departmentAdded = departmentRepository.save(department);
		if (departmentAdded == null)
			throw new DepartmentNotFoundException("cannot add department.. try again..");

		return departmentAdded;

	}

	// to find the department by Id
	@Override
	public Department getByDepartmentId(int departmentId) {
		// TODO Auto-generated method stub
		Department department = departmentRepository.findById(departmentId).get();
		if (department == null)
			throw new DepartmentNotFoundException("no department by this id found .. try again..");

		return department;
	}

	@Override
	public List<Department> getAll() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	// to update the department details
	@Override
	public Department updateDepartment(Department department) {
		// TODO Auto-generated method stub
		Department departmentUpdate = departmentRepository.save(department);
		if (departmentUpdate == null)
			throw new DepartmentNotFoundException("cannot update the department .. try again..");

		return departmentUpdate;

	}

}
