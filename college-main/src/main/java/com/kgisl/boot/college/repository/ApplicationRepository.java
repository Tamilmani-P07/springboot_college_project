package com.kgisl.boot.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kgisl.boot.college.dto.ApplicationDto;
import com.kgisl.boot.college.entity.Application;
@Repository
public interface ApplicationRepository extends JpaRepository<Application,Integer> {
    @Query(value="SELECT A.a_id ,S.s_name ,S.s_mark ,L.location_name FROM Application A JOIN Student S ON  A.s_id=S.s_id JOIN Location L ON S.location_id=L.location_id",nativeQuery = true)
    List<ApplicationDto> applicationjoins();
   
    
}
