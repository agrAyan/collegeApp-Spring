package com.collegeapp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Teacher {
	@Id
	@GeneratedValue(generator = "teacher_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "teacher_gen", sequenceName = "teacher_gen", initialValue = 1, allocationSize = 1)
	private Integer teacherId;
	private String teacherName;
	private String subject;
	private Integer totalEnagedLecture;
	private Integer leaves;
	@ManyToOne
	@JoinColumn(name="department_id")
	Department department;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="teacher_id")
	@JsonIgnore
	List<Lecture> lecture;

	public Teacher(String teacherName, String subject, Integer totalEnagedLecture, Integer leaves, List<Lecture> lecture) {
		super();
		this.teacherName = teacherName;
		this.subject = subject;
		this.totalEnagedLecture = totalEnagedLecture;
		this.leaves = leaves;
		this.lecture = lecture;
	}

	public Teacher(String teacherName, String subject, Integer totalEnagedLecture, Integer leaves,
			Department department) {
		super();
		this.teacherName = teacherName;
		this.subject = subject;
		this.totalEnagedLecture = totalEnagedLecture;
		this.leaves = leaves;
		this.department = department;
	}

	

	

	
	

	

	

	

}
