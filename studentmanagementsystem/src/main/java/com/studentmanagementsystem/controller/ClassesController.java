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
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagementsystem.entity.Classes;
import com.studentmanagementsystem.service.ClassesService;

@RestController
@RequestMapping("classes")
public class ClassesController {

	@Autowired
	private ClassesService classesService;

	@PostMapping("/addClass")
	public ResponseEntity<String> addClasses(@RequestBody Classes entity) {
		return classesService.addClasses(entity);
	}

	@GetMapping("/getClass/{id}")
	public Classes getClass(@PathVariable Long id) {
		return classesService.getClass(id);

	}

	@GetMapping("/getAllClasses")
	public List<Classes> getClasses() {
		return classesService.getClasses();
	}

	@PutMapping("/updateClass/{id}")
	public String updateClass(@PathVariable Long id, @RequestBody Classes classes) {
		classesService.updateClass(id, classes);
		return "Class Updated Successfully";
	}

	@DeleteMapping("/deleteClass/{id}")
	public String deleteClass(@PathVariable Long id) {
		classesService.deleteClass(id);
		return "class deleted successfully";
	}

}
