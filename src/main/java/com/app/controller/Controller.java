package com.app.controller;

import com.app.beans.*;
import com.app.entity.FeeDetails;
import com.app.entity.Student;
import com.app.service.AdminService;
import com.app.service.FeeDetailsService;
import com.app.service.StudentService;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class Controller {
    @Autowired
    StudentService studentService;

    @PostMapping("/createStudent")
    @CrossOrigin
   public ResponseEntity<StudentCreatedResponse> createStudent(@RequestBody StudentVo studentVo){

       StudentCreatedResponse response = studentService.createStudent(studentVo);

       return new ResponseEntity(response, HttpStatus.OK);
   }

   @GetMapping("/getAllStudents")
   @CrossOrigin
    public ResponseEntity<List<Student>>  getAllStudents( ){
        return studentService.getAllStudents();

    }

    @GetMapping("/getStudentById/{id}")
    @CrossOrigin
    public Student getStudentById(@PathVariable String id){
       return studentService.getStudentById(id);
    }

    @PutMapping("/update-student-details")
    @CrossOrigin
    public ResponseEntity<String> updateStudentsDetails(@RequestBody StudentUpdateRequestVo request){

        return studentService.updateStudentDetails(request);

    }

    @DeleteMapping
    @CrossOrigin
    public ResponseEntity<String>  deleteStudentById(@PathVariable  String id){

       return  studentService.deleteStudentsById(id);

    }

    @PostMapping("/login-user")
    @CrossOrigin
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserCredentials userCredentials) {
        String id = userCredentials.getId();
        String name = userCredentials.getName();

        if (studentService.authenticateUser(id,name)) {
            // Login successful
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Login successful!");
            return ResponseEntity.ok(response);
        } else {
            // Invalid credentials
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Invalid credentials!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @Autowired
    AdminService adminService;

    @PostMapping("/admin-login")
    @CrossOrigin
    public ResponseEntity<Map<String, Object>> adminLogin(@RequestBody UserCredentials userCredentials){
        String id = userCredentials.getId();
        String name = userCredentials.getName();

        if(adminService.authenticateUser(id,name)){
            Map<String,Object> response = new HashMap<>();
            response.put("success",true);
            response.put("message","Login Successful !");
            return ResponseEntity.ok(response);
        }else{
            Map<String,Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Invalid credentials!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @PostMapping("/create-admin")
    @CrossOrigin
    public ResponseEntity<StudentCreatedResponse> createAdmin(@RequestBody AdminVo adminVo){

        StudentCreatedResponse response = adminService.createAdmin(adminVo);

        return new ResponseEntity<>(response,HttpStatus.CREATED);

    }


    @Autowired
    FeeDetailsService feeDetailsService;


    @GetMapping("/feeDetails/{studentId}")
    public List<FeeDetails> getFeeDetailsByStudentId(@PathVariable String studentId) {
        return feeDetailsService.getFeeDetailsByStudentId(studentId);
    }

    @PostMapping("/add")
    public FeeDetails addFeeDetailsAndUpdateStudentStatus(@RequestBody FeeDetails feeDetails) {
        return feeDetailsService.addFeeDetailsAndUpdateStudentStatus(feeDetails);
    }

    @PostMapping("/createFeeDetails")
    public StudentCreatedResponse createFeedetails(@RequestBody FeeDetailsVo feeDetailsVo) {
        return feeDetailsService.createFeeDetails(feeDetailsVo);
    }


}
