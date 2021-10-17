package com.collegeapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class DepartmentDto {
//	Integer getDepartmentId();
//	 String getDepartmentName();
	
	private Integer departmentId;
	private String departmentName;
}
