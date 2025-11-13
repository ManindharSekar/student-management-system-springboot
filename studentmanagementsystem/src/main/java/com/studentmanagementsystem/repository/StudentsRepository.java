package com.studentmanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.studentmanagementsystem.entity.Students;

public interface StudentsRepository extends JpaRepository<Students, Long> {

	
	List<Students> findByNameContainingIgnoreCase(@Param("name") String name);
	


	Students findByRegNo(String regNo);

}
