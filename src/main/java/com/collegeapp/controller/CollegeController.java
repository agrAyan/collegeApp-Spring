package com.collegeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.collegeapp.model.College;
import com.collegeapp.service.ICollegeService;

@RestController
@RequestMapping("/college-service")
public class CollegeController {
	
	@Autowired
	ICollegeService collegeService;
	
	@GetMapping("/college/city/{city}")
	List<College> findByCity(@PathVariable("city") String city){
		List<College> collegeCity= collegeService.getByCity(city);
		return collegeCity;
	}
	@GetMapping("/college/fees/{fees}")
	List<College> findByFeesLessThan(@PathVariable("fees") double fees){
		List<College> collegeFees= collegeService.getByLessFees(fees);
		return collegeFees;
	}
	@DeleteMapping("/college/id/{id}")
	void deleteCollege(@PathVariable("id") int collegeId) {
		
		collegeService.deleteCollege(collegeId);
	}
	@GetMapping("/college/id/{id}")
	 College getById(@PathVariable("id") int id) {
		 College college= collegeService.getById(id);
		 return college;
	 }
	@PutMapping("/college")
	College updateCollege(@RequestBody College college) {
		return collegeService.updateCollege(college);
	}
	@GetMapping("/college")
	List<College> getAllCollege(){
		return collegeService.getAllCollege();
	}
	
}
