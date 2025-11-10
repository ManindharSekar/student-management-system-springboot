package com.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentmanagementsystem.entity.Marks;

public interface MarksRepository extends JpaRepository<Marks, Integer> {

}
