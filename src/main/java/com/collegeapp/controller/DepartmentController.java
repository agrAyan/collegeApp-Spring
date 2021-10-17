package com.collegeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.collegeapp.model.College;
import com.collegeapp.model.Department;
import com.collegeapp.model.DepartmentDto;
import com.collegeapp.model.Teacher;
import com.collegeapp.service.IDepartmentService;
import com.collegeapp.service.ITeacherService;

@RestController
@RequestMapping("/department-service")
public class DepartmentController {
	
	@Autowired
	IDepartmentService departmentService;
	
	@Autowired
	ITeacherService teacherService;
	
	@PostMapping("/department")
	public Department addDepartment(@RequestBody Department department) {
		return departmentService.addDepartment(department);
	}
	
	@GetMapping("/department")
	List<DepartmentDto> showDepartments(){
		List<DepartmentDto> allDepartment=departmentService.showDepartments();
		return allDepartment;
	}
	@GetMapping("/department/showDeptTeacher/{departmentName}")
	List<Teacher> showTeacherByDepartment(@PathVariable("departmentName") String departmentName){
		List<Teacher> teacherByDepartment=teacherService.showTeacherByDepartment(departmentName);
		return teacherByDepartment;
	}
	@GetMapping("/department/showTeachers")
	List<Teacher> getAll(){
		return teacherService.getAll();
	}
	@GetMapping("/department/subject/{subject}/deptName/{departmentName}")
	List<Teacher> showBySubjectAndDept(@PathVariable("subject") String subject, @PathVariable("departmentName") String departmentName){
		List<Teacher> teacherBySubAndDept=teacherService.showBySubjectAndDept(subject, departmentName);
		return teacherBySubAndDept;
	}
	@GetMapping("/department/teacherId/{id}")
	Teacher getById(@PathVariable("id") int teacherId) {
		Teacher teacher= teacherService.getById(teacherId);
		return teacher;
	}
	@GetMapping("/department/teacherName/{teacherName}")
	List<Teacher> getByTeacherName(@PathVariable("teacherName") String teacherName){
		List<Teacher> teacherList=teacherService.getByTeacherName(teacherName);
		return teacherList;
	}
	@GetMapping("/department/id/{id}")
	 public DepartmentDto getByDepartmentId(@PathVariable("id") int departmentId) {
		 return departmentService.getById(departmentId);
	 }
	
	@PutMapping("/department/departmentId/{departmentId}/collegeId/{collegeId}")
	public Department assignDepartmentToCollege(@PathVariable("departmentId") int departmentId, @PathVariable("collegeId") int collegeId) {
		College college = new College();
		college.setCollegeId(collegeId);
		Department department = departmentService.getByDepartmentId(departmentId);
		department.setCollege(college);
		return departmentService.updateDepartment(department);
	}
	
	
	
	
}
