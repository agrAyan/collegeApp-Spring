package com.collegeapp.service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegeapp.exception.DepartmentNotFoundException;
import com.collegeapp.exception.LectureNotFoundException;
import com.collegeapp.model.Lecture;
import com.collegeapp.model.Teacher;
import com.collegeapp.repository.ILectureRepository;

@Service
@Transactional
public class LectureServiceImpl implements ILectureService {

	@Autowired
	ILectureRepository lectureRepository;

	// this method returns the total lecture of the teacher that is assigned to him
	// in the upcoming days
	@Override
	public List<Lecture> showTeacherSchedule(int teacherId) {
		List<Lecture> teacherSchedule = lectureRepository.showTeacherSchedule(teacherId);
		if (teacherSchedule.isEmpty())
			throw new LectureNotFoundException("pls enter correct teacher Id or No Lecture Schedule.. try again...");

		return teacherSchedule.stream().sorted(Comparator.comparing(Lecture::getDate)).collect(Collectors.toList());
	}

	// this method returns the lecture object that is assigned to teacher on a
	// particular date
	@Override
	public Lecture showTodayLecture(LocalDate todayDate, int teacherId) {
		Lecture lecture = lectureRepository.showTodayLecture(todayDate, teacherId);
		if (lecture == null)
			throw new LectureNotFoundException("No Lecture Schedule.. try after some time");
		return lecture;
	}

	@Override
	// this method returns the teacherName whose is having first lecture in their
	// class
	public String getTeacherForFirstLec(LocalDate date, String className) {
		String teacherName = lectureRepository.showTeacherForFirstLec(date, className);
		if (teacherName == null)
			return "FREE";
		return teacherName;
	}

	// this method returns the teacherName whose is having second lecture in their
	// class
	@Override
	public String getTeacherForSecondLec(LocalDate date, String className) {
		String teacherName = lectureRepository.showTeacherForSecondLec(date, className);
		if (teacherName == null)
			return "FREE";
		return teacherName;
	}

	// this method returns the teacherName whose is having third lecture in their
	// class
	@Override
	public String getTeacherForThirdLec(LocalDate date, String className) {
		String teacherName = lectureRepository.showTeacherForThirdLec(date, className);
		if (teacherName == null)
			return "FREE";
		return teacherName;
	}

	// this method is to add a lecture
	@Override
	public Lecture addLecture(Lecture lecture) {
		// TODO Auto-generated method stub
		Lecture lectureAdded = lectureRepository.save(lecture);
		if (lectureAdded == null)
			throw new LectureNotFoundException("cannot add lecture.. try again");
		return lectureAdded;
	}

	// to get the lecture Details by Lecture Id
	@Override
	public Lecture getByLectureId(int lectureId) {
		// TODO Auto-generated method stub
		Lecture lecture = lectureRepository.findById(lectureId).get();
		if (lecture == null)
			throw new LectureNotFoundException("pls enter correct lectureId .. try again");
		return lecture;
	}

	// to update the lecture lecture details also used to assign lecture to Teacher
	@Override
	public Lecture updateLecture(Lecture lecture) {
		// TODO Auto-generated method stub
		Lecture lectureUpdated = lectureRepository.save(lecture);
		if (lectureUpdated == null)
			throw new LectureNotFoundException("cannot update lecture .. try again");
		return lectureUpdated;
	}

	// to get the list of all the lectures
	@Override
	public List<Lecture> getAllLectures() {
		// TODO Auto-generated method stub
		List<Lecture> lectureList = lectureRepository.findAll();
		if (lectureList.isEmpty())
			throw new LectureNotFoundException("no lecture Schedule");
		return lectureList;
	}

}
