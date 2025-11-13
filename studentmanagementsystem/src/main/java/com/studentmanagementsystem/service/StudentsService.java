package com.studentmanagementsystem.service;

import java.util.List;
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
				.orElseThrow(() -> new RecordNotFoundException("no student found in this id=" + id));
	}

	public Students updateStudent(Long id, Students student) {
		// TODO Auto-generated method stub
		Students updateStudent = studentRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("no student fount in this id=" + id));
		updateStudent.setRegNo(student.getRegNo());
		updateStudent.setName(student.getName());
		updateStudent.setAge(student.getAge());
		updateStudent.setAddress(student.getAddress());
		updateStudent.setGender(student.getGender());
		updateStudent.setFatherName(student.getFatherName());
		updateStudent.setMotherName(student.getMotherName());
		updateStudent.setDateOfBirth(student.getDateOfBirth());
		updateStudent.setPhoneNo(student.getPhoneNo());

		return studentRepository.save(updateStudent);
	}

	public ResponseEntity<Students> deleteStudent(Students id) {
		// TODO Auto-generated method stub
		studentRepository.delete(id);

		return new ResponseEntity("student deleted", HttpStatus.OK);
	}

	public List<Students> searchStudentByName(String name) {
		// TODO Auto-generated method stub
		return studentRepository.findByNameContainingIgnoreCase(name);
		
	}

	public ResponseEntity<Students> searchStudentByRegNo(String regNo) {
		// TODO Auto-generated method stub
		Students student = studentRepository.findByRegNo(regNo);
		
		if(student==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(student);
	}

}
