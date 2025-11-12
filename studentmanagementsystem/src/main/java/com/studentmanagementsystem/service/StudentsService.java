package com.studentmanagementsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.studentmanagementsystem.entity.Students;
import com.studentmanagementsystem.exception.RecordNotFoundException;
import com.studentmanagementsystem.repository.StudentsRepository;

@Service
public class StudentsService {

	@Autowired
	private StudentsRepository studentRepository;

	public ResponseEntity<String> addStudent(Students student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
		return new ResponseEntity<>("success", HttpStatus.CREATED);

	}

	public Students getStudent(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("no record found in this " + id));
	}

}
