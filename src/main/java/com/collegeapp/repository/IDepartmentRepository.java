package com.collegeapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.collegeapp.model.Department;
import com.collegeapp.model.DepartmentDto;
@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
	
	@Query(value="insert into department(department_name, college_id) values (?1,?2)",nativeQuery = true)
	int addDepartment(String departmentName, int collegeId);
	
	 List<DepartmentDto> findAllProjectedBy();
	 DepartmentDto findByDepartmentId(int departmentId);
}
