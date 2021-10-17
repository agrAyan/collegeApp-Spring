package com.collegeapp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.collegeapp.model.Lecture;
@Repository
public interface ILectureRepository extends JpaRepository<Lecture, Integer> {
	
	@Modifying
	@Query(value="update lecture set teacher_id =?1 where lecture_id=?2", nativeQuery = true)
	void setTeacherId(int teacherId, int lectureId);
	
	@Query("from Lecture l inner join l.teacher t where t.teacherId=?1")
	List<Lecture> showTeacherSchedule(int teacherId);
	
	@Query("from Lecture l inner join l.teacher t where l.date=?1 and t.teacherId=?2")
	Lecture showTodayLecture(LocalDate date, int teacherId);
	@Modifying
	@Query(value="update lecture set first_lecture='FREE', second_lecture='FREE', third_lecture='FREE' where teacher_id=?1", nativeQuery = true)
	void leaveSoFree(int teacherId);
	
	@Query(value="select teacher_name from teacher t inner join lecture l on l.teacher_id=t.teacher_id where date=?1 and first_lecture=?2",nativeQuery = true)
	String showTeacherForFirstLec(LocalDate date, String className);
	
	@Query(value="select teacher_name from teacher t inner join lecture l on t.teacher_id=l.teacher_id where date=?1 and second_lecture=?2",nativeQuery = true)
	String showTeacherForSecondLec(LocalDate date, String className);
	
	@Query(value="select teacher_name from teacher t inner join lecture l on l.teacher_id=t.teacher_id where date=?1 and third_lecture=?2",nativeQuery = true)
	String showTeacherForThirdLec(LocalDate date, String className);
	
	@Modifying
	@Query(value="update lecture l set l.second_lecture=?1 where l.teacher_id=(select teacher_id from teacher where teacher_name=?2)", nativeQuery = true)
	void updateSecondLec(String secondLecture, String teacherName);
	
	@Modifying
	@Query(value="update lecture l set l.first_lecture=?1 where l.teacher_id=(select teacher_id from teacher where teacher_name=?2)", nativeQuery = true)
	void updateFirstLec(String secondLecture, String teacherName);
	
	@Modifying
	@Query(value="update lecture l set l.third_lecture=?1 where l.teacher_id=(select teacher_id from teacher where teacher_name=?2)", nativeQuery = true)
	void updateThirdLec(String secondLecture, String teacherName);
	
}
