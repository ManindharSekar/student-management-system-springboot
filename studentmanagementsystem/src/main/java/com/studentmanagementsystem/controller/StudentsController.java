package com.studentmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagementsystem.entity.Students;
import com.studentmanagementsystem.service.StudentsService;

@RestController
@RequestMapping("students")
public class StudentsController {
	@Autowired
	private StudentsService studentsService;
	
	@PostMapping("/addStudent")
	public ResponseEntity<String> addStudent(@RequestBody Students student ) {
		return studentsService.addStudent(student);
	}
	
	@GetMapping("/getStudent/{id}")
	public Students getStudent(@PathVariable Long id){
		return studentsService.getStudent(id);
	}
	
	@PutMapping("/updateStudent/{id}")
	public Students updateStudent(@PathVariable Long id, @RequestBody Students student) {
		return studentsService.updateStudent(id,student);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public  String deleteStudent(@PathVariable Students id) {
		 studentsService.deleteStudent(id);
		 return "student deleted";
	}
	
	@GetMapping("/searchByName")
	public List<Students> searchStudentByName(@RequestParam String name){
		return studentsService.searchStudentByName(name);
	}
	
	@GetMapping("/searchByRegNo")
	public ResponseEntity<Students> searchStudentByRegNo(@RequestParam String regNo) {
		return studentsService.searchStudentByRegNo(regNo);
	}
		
	
	
	
	

}
