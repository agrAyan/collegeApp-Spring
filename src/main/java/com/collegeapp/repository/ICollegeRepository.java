package com.collegeapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collegeapp.model.College;
@Repository
public interface ICollegeRepository extends JpaRepository<College, Integer> {
List<College> findByCity(String city);
List<College> findByFeesLessThan(double fees);
}
