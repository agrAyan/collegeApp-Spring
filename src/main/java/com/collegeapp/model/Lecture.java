package com.collegeapp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

public class Lecture {
	@Id
	@GeneratedValue(generator = "lecture_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "lecture_gen", sequenceName = "lecture_gen", initialValue = 1, allocationSize = 1)
	private Integer lectureId;
	LocalDate date;
	private Integer duration;
	private String firstLecture;
	private String secondLecture;
	private String thirdLecture;
	private LocalTime firstLectTime;
	private LocalTime secondLectTime;
	private LocalTime thirdLectTime;
	@ManyToOne
	@JoinColumn(name="teacher_id")
	Teacher teacher;
	public Lecture(LocalDate date, Integer duration, String firstLecture, String secondLecture, String thirdLecture,
			LocalTime firstLectTime, LocalTime secondLectTime, LocalTime thirdLectTime) {
		super();
		this.date = date;
		this.duration = duration;
		this.firstLecture = firstLecture;
		this.secondLecture = secondLecture;
		this.thirdLecture = thirdLecture;
		this.firstLectTime = firstLectTime;
		this.secondLectTime = secondLectTime;
		this.thirdLectTime = thirdLectTime;
	}

	

	

	
}
