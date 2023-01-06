package com.kgisl.boot.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kgisl.boot.college.entity.Signup;
@Repository
public interface Signuprepository extends JpaRepository<Signup,Integer> {
    @Modifying
     @Query(nativeQuery = true,value = "DELETE FROM Signup WHERE u_name =?1")
    void deletebyname(String uname);
   


   
    
}