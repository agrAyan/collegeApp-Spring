package com.collegeapp.model;

import java.util.List;
import java.util.Set;

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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}

	@Id
	@GeneratedValue(generator = "department_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "department_gen", sequenceName = "department_seq", initialValue = 1, allocationSize = 1)
	private Integer departmentId;
	private String departmentName;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name= "department_id")
	@JsonIgnore
	Set<Teacher> teacherList;

	@ManyToOne
	@JoinColumn(name="college_id")
	College college;

	public Department(String departmentName, Set<Teacher> teacherList) {
		super();
		this.departmentName = departmentName;
		this.teacherList = teacherList;
	}

	public Department(String departmentName) {
		super();
		this.departmentName = departmentName;
	}

}
