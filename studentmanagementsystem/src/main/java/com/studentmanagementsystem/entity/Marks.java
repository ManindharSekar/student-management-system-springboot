package com.studentmanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Marks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String semester;
	int mark1;
	int mark2;
	int mark3;
	int mark4;
	int mark5;
	int total;
	
	@ManyToOne
	Students studentId;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public int getMark1() {
		return mark1;
	}

	public void setMark1(int mark1) {
		this.mark1 = mark1;
	}

	public int getMark2() {
		return mark2;
	}

	public void setMark2(int mark2) {
		this.mark2 = mark2;
	}

	public int getMark3() {
		return mark3;
	}

	public void setMark3(int mark3) {
		this.mark3 = mark3;
	}

	public int getMark4() {
		return mark4;
	}

	public void setMark4(int mark4) {
		this.mark4 = mark4;
	}

	public int getMark5() {
		return mark5;
	}

	public void setMark5(int mark5) {
		this.mark5 = mark5;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Students getStudentId() {
		return studentId;
	}

	public void setStudentId(Students studentId) {
		this.studentId = studentId;
	}

	

}
