package com.studentmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagementsystem.entity.Classes;
import com.studentmanagementsystem.exception.RecordNotFoundException;
import com.studentmanagementsystem.repository.ClassRepository;

@Service
public class ClassesService {
	@Autowired
	private ClassRepository classRepository;

	public Classes addClasses(Classes entity) {
		
		return classRepository.save(entity);
	}

	public Classes getClass(int id) {
		
		return classRepository.findById(id).orElseThrow(()->new RecordNotFoundException("No Class Present in this id "+id));
	}

	public List<Classes> getClasses() {
		return classRepository.findAll();
	}

	public Classes updateClass(int id, Classes update) {
		Classes findClass=classRepository.findById(id).orElseThrow((()->new RecordNotFoundException("No Class Present in this id "+id)));
		findClass.setSection(update.getSection());
		findClass.setClasses(update.getClasses());
		findClass.setSubject1(update.getSubject1());
		findClass.setSubject2(update.getSubject2());
		findClass.setSubject3(update.getSubject3());
		findClass.setSubject4(update.getSubject4());
		findClass.setSubject5(update.getSubject5());
		return classRepository.save(findClass);
	}

	public void deleteClass(int id) {
		classRepository.deleteById(id);
	}

}
