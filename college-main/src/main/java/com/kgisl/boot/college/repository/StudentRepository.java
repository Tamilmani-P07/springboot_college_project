package com.kgisl.boot.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.boot.college.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
   
    //SELECT new com.kgisl.boot.college.dto.RejectedDto(s.s_name)"+" FROM Application a JOIN Student s ON a.s_id=s.s_id
}
