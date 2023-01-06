package com.kgisl.boot.college.contoller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kgisl.boot.college.dto.ApplicationDto;
import com.kgisl.boot.college.dto.CollegeDto;
import com.kgisl.boot.college.dto.RejectedDto;
import com.kgisl.boot.college.dto.SelectedDto;
import com.kgisl.boot.college.dto.StatusDto;
import com.kgisl.boot.college.entity.Course;
import com.kgisl.boot.college.entity.Login;
import com.kgisl.boot.college.entity.Seatlist;
import com.kgisl.boot.college.entity.Signup;
import com.kgisl.boot.college.service.LoginService;
@EnableAspectJAutoProxy(proxyTargetClass = true)
@RestController
@RequestMapping("/collage")
public class CollegeController {

    @Autowired
    private LoginService loginService;


    @RequestMapping(value = "/login", headers = "Accept=application/json")
    
    public ResponseEntity<?> login(@RequestBody Login login, HttpServletRequest request) {
        //System.out.println(login.getU_name() + " " + login.getPass());
        ModelAndView sen = loginService.checkUser(login.getU_name(), login.getPass());
        //System.out.println("success");
        return new ResponseEntity<>(sen, HttpStatus.CREATED);
    }

    @PutMapping(value = "/signup", headers = "Accept=application/json")
    public ResponseEntity<?> signup(@RequestBody Signup signup, HttpServletRequest request) {
        //System.out.println("signup " + signup.getCategory() + " " + signup.getU_name() + " " + signup.getPass());
        ModelAndView sen=new ModelAndView();
        if(signup.getCategory()!=null&&signup.getU_name()!=null&&signup.getPass()!=null){ sen = loginService.signup(signup);}
        else{
            sen.setViewName("signup.html");
        }
        return new ResponseEntity<>(sen, HttpStatus.CREATED);

    }

    @PostMapping("/course")

    public ResponseEntity<?> collegeseatlist() {

        List<Course> courList = loginService.courseDetails();
        return new ResponseEntity<>(courList, HttpStatus.CREATED);
    }
    @PostMapping("/rejected")

    public ResponseEntity<?> rejectedlist() {

        List<RejectedDto> rList1 = loginService.rejectedDetails();
       
        
        return new ResponseEntity<>(rList1, HttpStatus.CREATED);
    }
    @PostMapping("/selected")

    public ResponseEntity<?> selectedlist() {

        List<SelectedDto> rList1 = loginService.selectedDetails();
        
        return new ResponseEntity<>(rList1, HttpStatus.CREATED);
    }

    @PostMapping("/applicationlist")

    public ResponseEntity<?> applicationlist() {

        List<ApplicationDto> rList1 = loginService.applicationlist();
        
        return new ResponseEntity<>(rList1, HttpStatus.CREATED);
    }

    @GetMapping("/approval")
    public ResponseEntity<?> status_std(){
        List<Signup> aplist = loginService.stdApprovallist();
        //System.out.println(aplist);

        return new ResponseEntity<>(aplist, HttpStatus.CREATED);
        
    }
    @DeleteMapping(value = "/delete", headers = "Accept=application/json")
    public void delete_entity (@RequestBody Signup signup ){
      loginService.addtheuser(signup);
       
    }
    @PostMapping(value ="/accept",headers = "Accept=application/json")
    public ResponseEntity<?> insert_entity (@RequestBody Login login ){
        loginService.logintheuser(login);
        return new ResponseEntity<>(HttpStatus.CREATED);
        
    }
    @PostMapping(value = "/seats", headers = "Accept=application/json")
    public ResponseEntity<?> collegeseatlist(@RequestBody Seatlist seatlist) {
 
        //System.out.println(seatlist.getC_id()+"  "+seatlist.getCourse_id());
          List<CollegeDto> clistseats=loginService.collegeSeatList(seatlist.getC_id(),seatlist.getCourse_id());
        return new ResponseEntity<>(clistseats, HttpStatus.CREATED);

    }
    @PostMapping(value = "/status", headers = "Accept=application/json")
    public ResponseEntity<?> statusList(@RequestBody Login login) {
 
        //System.out.println(login.getU_name()+"  "+login.getPass());
          List<StatusDto> statuslis=loginService.status(login.getU_name(),login.getPass());
        return new ResponseEntity<>(statuslis, HttpStatus.CREATED);

    }


}
