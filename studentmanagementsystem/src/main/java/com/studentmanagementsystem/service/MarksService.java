package com.studentmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.studentmanagementsystem.entity.Marks;
import com.studentmanagementsystem.exception.RecordNotFoundException;
import com.studentmanagementsystem.repository.MarksRepository;

@Service
public class MarksService {
	
	@Autowired
	private MarksRepository marksRepository;

	public Marks addMarks(Marks marks) {
		// TODO Auto-generated method stub
		int total=sumTotalMarks(marks.getMark1(),marks.getMark2(),marks.getMark3(),marks.getMark4(),marks.getMark5());
		marks.setTotal(total);
		
		return marksRepository.save(marks);
	}


	public Marks getMarks(Long id) {
		// TODO Auto-generated method stub
		return marksRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("Mark is not available in this "+id));
	}

	public ResponseEntity<String> updateMark(Long id, Marks marks) {
		Marks updateMark = marksRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("Mark is not available in this id="+id));
		updateMark.setMark1(marks.getMark1());
		updateMark.setMark2(marks.getMark2());
		updateMark.setMark3(marks.getMark3());
		updateMark.setMark4(marks.getMark4());
		updateMark.setMark5(marks.getMark5());
		updateMark.setSemester(marks.getSemester());
		updateMark.setYear(marks.getYear());
		int total=sumTotalMarks(marks.getMark1(),marks.getMark2(),marks.getMark3(),marks.getMark4(),marks.getMark5());
		updateMark.setTotal(total);
	    marksRepository.save(updateMark);
	    return new ResponseEntity<>("student updated",HttpStatus.OK);
		
	}
	
	private int sumTotalMarks(int mark1, int mark2, int mark3, int mark4, int mark5) {
		int total=mark1+mark2+mark3+mark4+mark5;
		return total;
	}


	public ResponseEntity<String> deleteMark(Marks id) {
		// TODO Auto-generated method stub
		marksRepository.delete(id);
		return new ResponseEntity<>("Mark deleted ",HttpStatus.OK);
		
	}
	
	

}
