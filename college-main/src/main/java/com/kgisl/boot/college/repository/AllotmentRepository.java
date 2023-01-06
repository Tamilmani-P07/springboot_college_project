package com.kgisl.boot.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kgisl.boot.college.dto.RejectedDto;
import com.kgisl.boot.college.dto.SelectedDto;
import com.kgisl.boot.college.entity.Allotment;
@Repository
public interface AllotmentRepository extends JpaRepository<Allotment,Integer>{
    @Query(value="SELECT a.a_id,s.S_NAME FROM Application a join Student s ON a.s_id=s.s_id WHERE a_id NOT IN (SELECT a_id FROM allotment)",nativeQuery = true)
    public List<RejectedDto> rejectejoin();
    @Query(value="SELECT S.s_name ,AL.allotment_id ,A.a_id ,c.c_name,CO.cour_name FROM Student S   JOIN Application A ON S.s_id=A.s_id JOIN Allotment AL ON  A.a_id=AL.a_id join Course_Selection cs ON cs.cs_id=AL.cs_id JOIN Course CO ON cs.course_id=CO.course_id JOIN college c  ON c.c_id=cs.c_id WHERE AL.a_id= A.a_id",nativeQuery = true)
    public List<SelectedDto> selectedjoin();  
}
