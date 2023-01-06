package com.kgisl.boot.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kgisl.boot.college.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login,Integer> {
    @Query("from Login where u_name=?1 and pass=?2")
    public List<Login> loginValidate(String name,String pass) ;
    
}

