package com.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentmanagementsystem.entity.Classes;

public interface ClassRepository extends JpaRepository<Classes, Long> {

}
