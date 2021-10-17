package com.collegeapp.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.collegeapp.model.Teacher;

public interface ITeacherService {
	List<Teacher> showTeacherByDepartment(String departmentName);

	List<Teacher> showTeacherBySubject(String subject);

	String applyLeave(LocalDate date, int teacherId);

	Teacher getById(int teacherId);

	List<Teacher> getByTeacherName(String teacherName);

	List<Teacher> getAll();

	List<Teacher> showBySubjectAndDept(String subject, String departmentName);

	List<String> showFirstLecFreeTeacher(LocalDate date);

	List<String> showSecondLecFreeTeacher(LocalDate date);

	List<String> showThirdLecFreeTeacher(LocalDate date);

	HashMap<String, List<String>> showTeachersFreeLectures(LocalDate date, int teacherId);

	Teacher addTeacher(Teacher teacher);

	Teacher updateTeacher(Teacher teacher);

}
