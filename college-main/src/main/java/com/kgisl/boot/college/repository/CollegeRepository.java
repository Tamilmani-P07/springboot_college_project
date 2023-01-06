package com.kgisl.boot.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kgisl.boot.college.dto.CollegeDto;
import com.kgisl.boot.college.dto.StatusDto;
import com.kgisl.boot.college.entity.College;

@Repository
public interface CollegeRepository extends JpaRepository<College,Integer> {
    @Query(value="SELECT co.c_name,c.cour_name ,co.c_id,COUNT(cs.c_id) as 'filledseats' ,c.total_seats-COUNT(cs.c_id) as 'remainingseats',c.total_seats FROM course c  JOIN course_selection cs  ON c.course_id=cs.course_id JOIN college co  ON cs.c_id=co.c_id WHERE co.c_id=?1 AND c.course_id=?2",nativeQuery = true)
    List<CollegeDto> seatlist(int c_id, int course_id);
     @Query(value="SELECT a.a_id ,s.S_NAME  ,al.ALLOTMENT_ID  FROM login l  join   student s ON l.u_name=s.s_name JOIN application a ON  s.S_ID=a.S_ID  join allotment al  ON a.A_ID=al.A_ID  WHERE s.s_name=?1 AND l.pass=?2",nativeQuery = true)
    List<StatusDto> statuslist1(String u_name, String pass);
    
}
