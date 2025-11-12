package com.studentmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagementsystem.entity.Marks;
import com.studentmanagementsystem.service.MarksService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/marks")
public class MarksController {
	@Autowired
	private MarksService marksService;
	
	@PostMapping("/addMark")
	public Marks addMarks(@RequestBody Marks marks) {
		
		return marksService.addMarks(marks) ;
		
	}
	
	@GetMapping("/getMark/{id}")
	public Marks getMark(@PathVariable Long id) {
		return marksService.getMarks(id);
	}
	
	@PutMapping("/updateMarks/{id}")
	public String updateMark(@PathVariable Long id, Marks marks) {
		marksService.updateMark(id, marks);
		return "Mark Updated";
	}
	
	@DeleteMapping("/deleteMapping/{id}")
	public String deleteMark(@PathVariable Marks id) {
		marksService.deleteMark(id);
		return "Mark deleted";
	}
	

}
