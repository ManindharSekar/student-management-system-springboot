package com.studentmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.studentmanagementsystem.entity.Classes;
import com.studentmanagementsystem.exception.RecordNotFoundException;
import com.studentmanagementsystem.repository.ClassRepository;

@Service
public class ClassesService {
	@Autowired
	private ClassRepository classRepository;

	public ResponseEntity<String> addClasses(Classes entity) {

		try {
			classRepository.save(entity);
			return new ResponseEntity<>("success", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("failure", HttpStatus.BAD_REQUEST);
		}
	}

	public Classes getClass(Long id) {

		return classRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("No Class Present in this id " + id));
	}

	public List<Classes> getClasses() {
		return classRepository.findAll();
	}

	public Classes updateClass(Long id, Classes update) {
		Classes findClass = classRepository.findById(id)
				.orElseThrow((() -> new RecordNotFoundException("No Class Present in this id " + id)));
		findClass.setSection(update.getSection());
		findClass.setClasses(update.getClasses());
		findClass.setSubject1(update.getSubject1());
		findClass.setSubject2(update.getSubject2());
		findClass.setSubject3(update.getSubject3());
		findClass.setSubject4(update.getSubject4());
		findClass.setSubject5(update.getSubject5());
		return classRepository.save(findClass);
	}

	public void deleteClass(Long id) {
		Classes findClass = classRepository.findById(id)
				.orElseThrow((() -> new RecordNotFoundException("No Class Present in this id " + id)));
		if (findClass != null) {
			classRepository.deleteById(id);
		}

	}

}
