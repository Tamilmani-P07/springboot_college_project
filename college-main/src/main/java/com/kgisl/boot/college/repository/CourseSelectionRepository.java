package com.kgisl.boot.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.boot.college.entity.CourseSelection;

@Repository
public interface CourseSelectionRepository extends JpaRepository<CourseSelection,Integer>{

    
}
