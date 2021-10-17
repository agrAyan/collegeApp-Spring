package com.collegeapp.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegeapp.exception.CollegeNotAddedException;
import com.collegeapp.exception.CollegeNotFoundException;
import com.collegeapp.model.College;
import com.collegeapp.repository.ICollegeRepository;

@Service
public class CollegeServiceImpl implements ICollegeService {

	@Autowired
	ICollegeRepository collegeRepository;

	// to add a college
	@Override
	public College addCollege(College college) {
		College collegeAdded = collegeRepository.save(college);
		if (collegeAdded == null) {
			throw new CollegeNotAddedException("cannot add college");
		}
		return collegeAdded;
	}

	// to update a college details
	@Override
	public College updateCollege(College college) {
		College collegeUpdate = collegeRepository.save(college);
		if (collegeUpdate == null) {
			throw new CollegeNotFoundException("college cannot be updated.. try again");
		}
		return collegeUpdate;
	}

	// to delete a college
	@Override
	public void deleteCollege(int collegeId) {
		collegeRepository.deleteById(collegeId);

	}

	// to get a college by city
	@Override
	public List<College> getByCity(String city) {
		List<College> collegeByCity = collegeRepository.findByCity(city);
		if (collegeByCity.isEmpty())
			throw new CollegeNotFoundException("no college found at the entered city.. try again...");

		return collegeByCity.stream().sorted(Comparator.comparing(College::getCollegeName))
				.collect(Collectors.toList());
	}

	// to get the college by less fees
	@Override
	public List<College> getByLessFees(double fees) {
		List<College> collegeByFees = collegeRepository.findByFeesLessThan(fees);
		if (collegeByFees.isEmpty())
			throw new CollegeNotFoundException("no college found at this lower price.. try again...");

		return collegeByFees.stream().sorted(Comparator.comparing(College::getCollegeName))
				.collect(Collectors.toList());
	}

	// search college by Id
	@Override
	public College getById(int id) {
		College college = collegeRepository.findById(id).get();
		if (college == null)
			throw new CollegeNotFoundException("no college found!! pls enter the correct id");
		return college;
	}

	// to get the list of All Colleges
	@Override
	public List<College> getAllCollege() {
		List<College> collegeList = collegeRepository.findAll();
		if (collegeList.isEmpty())
			throw new CollegeNotFoundException("no college registred.. try after some time..Thank you");
		return collegeList;
	}

}
