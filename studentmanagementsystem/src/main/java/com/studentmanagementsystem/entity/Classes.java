package com.studentmanagementsystem.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Classes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String classes;
	private String Section;
	private String Subject1;
	private String Subject2;
	private String Subject3;
	private String Subject4;
	private String Subject5;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getSubject1() {
		return Subject1;
	}

	public void setSubject1(String subject1) {
		Subject1 = subject1;
	}

	public String getSubject2() {
		return Subject2;
	}

	public void setSubject2(String subject2) {
		Subject2 = subject2;
	}

	public String getSubject3() {
		return Subject3;
	}

	public void setSubject3(String subject3) {
		Subject3 = subject3;
	}

	public String getSubject4() {
		return Subject4;
	}

	public void setSubject4(String subject4) {
		Subject4 = subject4;
	}

	public String getSubject5() {
		return Subject5;
	}

	public void setSubject5(String subject5) {
		Subject5 = subject5;
	}

	public String getSection() {
		return Section;
	}

	public void setSection(String section) {
		Section = section;
	}

}
