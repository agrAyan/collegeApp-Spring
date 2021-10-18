package com.collegeapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collegeapp.model.Department;
import com.collegeapp.model.Lecture;
import com.collegeapp.model.Teacher;
import com.collegeapp.service.ILectureService;
import com.collegeapp.service.ITeacherService;

@RestController
@RequestMapping("teacher-service")
public class ITeacherController {
	
	@Autowired
	ILectureService lectureService;
	
	@Autowired
	ITeacherService teacherService;
	
	//url to add a teacher
	@PostMapping("/teacher")
	public Teacher addTeacher(@RequestBody Teacher teacher) {
		return teacherService.addTeacher(teacher);
	}
	
	// url to update the department id when a new Teacher added
	@PutMapping("/teacher/teacherId/{teacherId}/departmentId/{departmentId}")
	public Teacher updateTeacher(@PathVariable("teacherId")int teacherId, @PathVariable("departmentId") int departmentId){
		Department department = new Department();
		department.setDepartmentId(departmentId);
		Teacher teacher= teacherService.getById(teacherId);
		teacher.setDepartment(department);
		return teacherService.updateTeacher(teacher);
	}
	
	// url to get the teacher by Id
	@GetMapping("teacher/teacherId/{teacherId}")
	public Teacher getTeacherById(@PathVariable ("teacherId") int teacherId) {
		return teacherService.getById(teacherId);
	}
	
	// url to get the list of all the teachers
	@GetMapping("/teacher")
	public List<Teacher> getAll(){
		return teacherService.getAll();
	}
	
	// url to show the full teacher schedule that is assigned
	@GetMapping("teacher/schedule/{teacherId}")
	List<Lecture> showTeacherSchedule(@PathVariable("teacherId") int teacherId){
		return lectureService.showTeacherSchedule(teacherId);
	}
	
	// url to show the today teacher schedule that is assigned
	@GetMapping("teacher/todayschedule/date/{date}/teacherId/{teacherId}")
		Lecture showTodayLecture(@PathVariable("date") String date, @PathVariable("teacherId") int teacherId) {
		LocalDate date1= LocalDate.parse(date);	
		return lectureService.showTodayLecture(date1, teacherId);
		}
	
	// url to show the teacherName who is having first Lecture in thier class
	@GetMapping("teacher/firstLec/date/{date}/className/{className}")
		String showTeacherForFirstLec(@PathVariable("date") String date, @PathVariable("className") String className) {
		LocalDate date1= LocalDate.parse(date);		
		return lectureService.getTeacherForFirstLec(date1, className);
		}
	// url to show the teacherName who is having second Lecture in thier class
	@GetMapping("teacher/secondLec/date/{date}/className/{className}")
		String showTeacherForSecondLec(@PathVariable("date") String date, @PathVariable("className") String className) {
		LocalDate date1= LocalDate.parse(date);		
		return lectureService.getTeacherForSecondLec(date1, className);
		}
	// url to show the teacherName who is having third Lecture in thier class
	@GetMapping("teacher/thirdLec/date/{date}/className/{className}")
		String showTeacherForThirdLec(@PathVariable("date") String date, @PathVariable("className") String className) {
		LocalDate date1= LocalDate.parse(date);		
		return lectureService.getTeacherForThirdLec(date1, className);
		}
	// url for the teacher to apply for leaves
	@GetMapping("teacher/leave/date/{date}/teacherId/{teacherId}")
		String applyLeave(@PathVariable("date") String date, @PathVariable("teacherId") int teacherId) {
		LocalDate date1= LocalDate.parse(date);		
		teacherService.applyLeave(date1, teacherId);
		return "leave Granted";
		}
		
	// url to add a new Lecture
	@PostMapping("/teacher/lecture")
	public Lecture addLecture(@RequestBody Lecture lecture){
		return lectureService.addLecture(lecture);
	}
	// url to assign the lecture to the teacher
	@PutMapping("/teacher/lecture/lectureId/{lectureId}/teacherId/{teacherId}")
	public Lecture assignLectureToTeacher(@PathVariable("lectureId")int lectureId, @PathVariable("teacherId") int teacherId){
		Teacher teacher = new Teacher();
		teacher.setTeacherId(teacherId);
		Lecture lecture= lectureService.getByLectureId(lectureId);
		lecture.setTeacher(teacher);
		return lectureService.updateLecture(lecture);
	}
	// url to get all the lectures details
	@GetMapping("/teacher/lectures")
	public List<Lecture> getAllLectures(){
		return lectureService.getAllLectures();
	}
}
