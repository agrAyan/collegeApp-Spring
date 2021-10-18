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
	
	
	// url to add a department
	@PostMapping("/department")
	public Department addDepartment(@RequestBody Department department) {
		return departmentService.addDepartment(department);
	}
	
	// url to get the list of all the departments
	@GetMapping("/department")
	List<DepartmentDto> showDepartments(){
		List<DepartmentDto> allDepartment=departmentService.showDepartments();
		return allDepartment;
	}
	
	// url to get the list of Teacher who is working inside one department
	@GetMapping("/department/showDeptTeacher/{departmentName}")
	List<Teacher> showTeacherByDepartment(@PathVariable("departmentName") String departmentName){
		List<Teacher> teacherByDepartment=teacherService.showTeacherByDepartment(departmentName);
		return teacherByDepartment;
	}
	
	// url to get the list of the teachers
	@GetMapping("/department/showTeachers")
	List<Teacher> getAll(){
		return teacherService.getAll();
	}
	
	// url to get the teacher list by subject he is and teaching and working inside one department
	@GetMapping("/department/subject/{subject}/deptName/{departmentName}")
	List<Teacher> showBySubjectAndDept(@PathVariable("subject") String subject, @PathVariable("departmentName") String departmentName){
		List<Teacher> teacherBySubAndDept=teacherService.showBySubjectAndDept(subject, departmentName);
		return teacherBySubAndDept;
	}
	
	// url to get the teacher details by teacherId
	@GetMapping("/department/teacherId/{id}")
	Teacher getById(@PathVariable("id") int teacherId) {
		Teacher teacher= teacherService.getById(teacherId);
		return teacher;
	}
	
	// url to get the teacher details by techerName
	@GetMapping("/department/teacherName/{teacherName}")
	List<Teacher> getByTeacherName(@PathVariable("teacherName") String teacherName){
		List<Teacher> teacherList=teacherService.getByTeacherName(teacherName);
		return teacherList;
	}
	
	// url to get the departement details by departmentId
	@GetMapping("/department/id/{id}")
	 public DepartmentDto getByDepartmentId(@PathVariable("id") int departmentId) {
		 return departmentService.getById(departmentId);
	 }
	
	// url to update the college Id after adding a new department 
	@PutMapping("/department/departmentId/{departmentId}/collegeId/{collegeId}")
	public Department assignDepartmentToCollege(@PathVariable("departmentId") int departmentId, @PathVariable("collegeId") int collegeId) {
		College college = new College();
		college.setCollegeId(collegeId);
		Department department = departmentService.getByDepartmentId(departmentId);
		department.setCollege(college);
		return departmentService.updateDepartment(department);
	}
	
	
	
	
}
