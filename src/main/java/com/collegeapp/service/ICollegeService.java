package com.collegeapp.service;

import java.util.List;

import com.collegeapp.model.College;

public interface ICollegeService {
	College addCollege(College college);

	College updateCollege(College college);

	void deleteCollege(int collegeId);

	College getById(int id);

	List<College> getByCity(String city);

	List<College> getByLessFees(double fees);

	List<College> getAllCollege();
}
