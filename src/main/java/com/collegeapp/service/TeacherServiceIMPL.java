package com.collegeapp.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegeapp.exception.DepartmentNotFoundException;
import com.collegeapp.exception.TeacherNotFoundException;
import com.collegeapp.model.Lecture;
import com.collegeapp.model.Teacher;
import com.collegeapp.repository.ILectureRepository;
import com.collegeapp.repository.ITeacherRepository;

@Service
@Transactional
public class TeacherServiceIMPL implements ITeacherService {

	@Autowired
	ITeacherRepository teacherRepository;

	@Autowired
	ILectureRepository lectureRepository;

	List<String> firstLecture = new ArrayList<>();
	List<String> secondLecture = new ArrayList<>();
	List<String> thirdLecture = new ArrayList<>();
	int totalEngage = 0;
	HashMap<String, List<String>> teacherLecture = new HashMap<>();
	Lecture lecture1 = null;
	Teacher teacher = null;
	Lecture lecture2 = null;

	// this method returns the list of teacher who is working inside one department
	@Override
	public List<Teacher> showTeacherByDepartment(String departmentName) {

		List<Teacher> teacherByDept = teacherRepository.showTeacherByDepartment(departmentName);
		if (teacherByDept.isEmpty())
			throw new DepartmentNotFoundException("no department found.. try again...");

		return teacherByDept.stream().sorted(Comparator.comparing(Teacher::getTeacherName))
				.collect(Collectors.toList());
	}

	// this method returns the list of teacher who is teaching a particular subject
	@Override
	public List<Teacher> showTeacherBySubject(String subject) {
		List<Teacher> teacherBySubject = teacherRepository.findBySubject(subject);
		if (teacherBySubject.isEmpty())
			throw new DepartmentNotFoundException("pls enter correct subject name.. try again...");

		return teacherBySubject.stream().sorted(Comparator.comparing(Teacher::getTeacherName))
				.collect(Collectors.toList());
	}

	// this method returns the HashMap whose first lecture, second lecture, third
	// Lecture is free
	public HashMap<String, List<String>> showTeachersFreeLectures(LocalDate date, int teacherId) {

		firstLecture = teacherRepository.showFirstLecFreeTeacher(date);
		teacherLecture.put("First Lecture Free", firstLecture);

		secondLecture = teacherRepository.showSecondLecFreeTeacher(date);
		teacherLecture.put("Second Lecture Free", secondLecture);

		thirdLecture = teacherRepository.showThirdLecFreeTeacher(date);
		teacherLecture.put("Third Lecture Free", thirdLecture);

		return teacherLecture;
	}

	// this method check weather the teacher should be assigned or not by checking
	// the availability of other teacher free lecture
	// this method also set the teacher lecture to free to the date the teacher is
	// applying for leave
	// this method also check if no teacher lecture is schedule on this date then he
	// will insert a data with this date by setting all the lectures free
	@Override
	public String applyLeave(LocalDate date, int teacherId) {
		showTeachersFreeLectures(date, teacherId);
		Lecture lecture = lectureRepository.showTodayLecture(date, teacherId);
		System.out.println(lecture);
		if (lecture == null) {
			lecture1 = new Lecture();
			lecture1.setDate(date);
			lecture1.setDuration(40);
			lecture1.setFirstLecture("FREE");
			lecture1.setSecondLecture("FREE");
			lecture1.setThirdLecture("FREE");
			lecture1.setFirstLectTime(LocalTime.of(10, 30, 00));
			lecture1.setSecondLectTime(LocalTime.of(11, 30, 00));
			lecture1.setThirdLectTime(LocalTime.of(12, 30, 00));
			lecture2 = lectureRepository.save(lecture1);
			System.out.print("hii Ayan" + lecture2.getFirstLecture());
			System.out.print(lecture2.getLectureId());
			System.out.print(teacherId);

			lectureRepository.setTeacherId(teacherId, lecture2.getLectureId());
			teacherRepository.applyLeave(teacherId);
			return "leave granted";
		} else {
			String firstLec = lecture.getFirstLecture();
			if (!firstLec.equals("FREE"))
				lectureRepository.updateFirstLec(firstLec, firstLecture.get(0));
			String secondLec = lecture.getSecondLecture();
			if (!secondLec.equals("FREE"))
				lectureRepository.updateSecondLec(secondLec, secondLecture.get(0));
			String thirdLec = lecture.getThirdLecture();
			if (!thirdLec.equals("FREE"))
				lectureRepository.updateThirdLec(thirdLec, thirdLecture.get(0));
			teacherRepository.applyLeave(teacherId);
			lectureRepository.leaveSoFree(teacherId);
			return "leave granted";

		}

	}

	// this method returns the teacher details by its id
	@Override
	public Teacher getById(int teacherId) {
		Teacher teacher = teacherRepository.findById(teacherId).get();
		if (teacher == null)
			throw new TeacherNotFoundException("pls entered correct teacher Id.. try Again");
		return teacher;
	}

	// this method returns the teacher details by its Name
	@Override
	public List<Teacher> getByTeacherName(String teacherName) {
		List<Teacher> teacherByName = teacherRepository.findByTeacherName(teacherName);
		if (teacherByName.isEmpty())
			throw new DepartmentNotFoundException("no teacher Name found.. try again...");

		return teacherByName.stream().sorted(Comparator.comparing(Teacher::getTeacherName))
				.collect(Collectors.toList());

	}

//  this method returns all the teacher details
	@Override
	public List<Teacher> getAll() {
		List<Teacher> allTeacher = teacherRepository.findAll();
		if (allTeacher.isEmpty())
			throw new TeacherNotFoundException("no teacher found... try again...");

		return allTeacher.stream().sorted(Comparator.comparing(Teacher::getTeacherName)).collect(Collectors.toList());
	}

	// this method returns the list of teacher who work under one department and
	// teach the subject
	@Override
	public List<Teacher> showBySubjectAndDept(String subject, String departmentName) {
		// TODO Auto-generated method stub
		return teacherRepository.findBySubjectAndDepartmentDepartmentName(subject, departmentName);
	}

	// this method List of teacher whose first lecture is free at a particular date
	@Override
	public List<String> showFirstLecFreeTeacher(LocalDate date) {
		// TODO Auto-generated method stub
		return teacherRepository.showFirstLecFreeTeacher(date);
	}

//  this method List of teacher whose second lecture is free at a particular date
	@Override
	public List<String> showSecondLecFreeTeacher(LocalDate date) {
		// TODO Auto-generated method stub
		return teacherRepository.showSecondLecFreeTeacher(date);
	}

//  this method List of teacher whose third lecture is free at a particular date
	@Override
	public List<String> showThirdLecFreeTeacher(LocalDate date) {
		// TODO Auto-generated method stub
		return teacherRepository.showThirdLecFreeTeacher(date);
	}

	// this method is to add a teacher
	@Override
	public Teacher addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherRepository.save(teacher);
	}

	// this method is used to update the teacher Details and also to assign the
	// department to the teacher after adding
	@Override
	public Teacher updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherRepository.save(teacher);
	}
}
