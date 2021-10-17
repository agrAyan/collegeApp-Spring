package com.collegeapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@ToString
@Entity

public class College {
	@Id
	@GeneratedValue(generator = "college_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="college_gen",sequenceName = "college_seq",initialValue = 100,allocationSize = 1)
	private Integer collegeId;
	private String collegeName;
	private String city;
	private double fees;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="college_id")
	@JsonIgnore
	Set<Department> departmentList;

	public College(String collegeName, String city, double fees, Set<Department> departmentList) {
		super();
		this.collegeName = collegeName;
		this.city = city;
		this.fees = fees;
		this.departmentList = departmentList;
	}

	
	
	
	
}
