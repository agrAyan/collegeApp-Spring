package com.collegeapp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.collegeapp.model.Teacher;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {

	@Query("from Teacher t inner join t.department d where d.departmentName=?1")
	List<Teacher> showTeacherByDepartment(String departmentName);

	List<Teacher> findBySubject(String subject);

	@Modifying
	@Query(value = "update teacher set leaves=1 where teacher_id=?1", nativeQuery = true)
	void applyLeave(int teacherId);

	List<Teacher> findByTeacherName(String teacherName);

	List<Teacher> findBySubjectAndDepartmentDepartmentName(String subject, String departmentName);

	@Query(value = "select teacher_name from teacher t inner join lecture l on t.teacher_id=l.teacher_id where l.first_lecture='FREE' and l.date=?1", nativeQuery = true)
	List<String> showFirstLecFreeTeacher(LocalDate date);

	@Query(value = "select teacher_name from teacher t inner join lecture l on t.teacher_id=l.teacher_id where l.second_lecture='FREE' and l.date=?1", nativeQuery = true)
	List<String> showSecondLecFreeTeacher(LocalDate date);

	@Query(value = "select teacher_name from teacher t inner join lecture l on t.teacher_id=l.teacher_id where l.third_lecture='FREE' and l.date=?1", nativeQuery = true)
	List<String> showThirdLecFreeTeacher(LocalDate date);
}
