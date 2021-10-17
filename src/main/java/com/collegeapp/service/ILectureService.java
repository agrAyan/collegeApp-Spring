package com.collegeapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.collegeapp.model.Lecture;

public interface ILectureService {
	List<Lecture> showTeacherSchedule(int teacherId);

	Lecture showTodayLecture(LocalDate todayDate, int teacherId);
	// select TEACHER_name from teacher t inner join lecture l on
	// l.teacher_id=t.teacher_id where first_lecture='CSE B10';

	String getTeacherForFirstLec(LocalDate date, String className);

	String getTeacherForSecondLec(LocalDate date, String className);

	String getTeacherForThirdLec(LocalDate date, String className);

	Lecture addLecture(Lecture lecture);

	Lecture getByLectureId(int lectureId);

	Lecture updateLecture(Lecture lecture);

	List<Lecture> getAllLectures();
}
