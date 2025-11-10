package com.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentmanagementsystem.entity.Students;

public interface StudentsRepository extends JpaRepository<Students, Integer> {

}
