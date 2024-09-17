package com.app.service;

import com.app.beans.StudentCreatedResponse;
import com.app.beans.StudentUpdateRequestVo;
import com.app.beans.StudentVo;
import com.app.entity.Student;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public StudentCreatedResponse createStudent(StudentVo studentVo);

    public ResponseEntity<List<Student>> getAllStudents();

    public Student getStudentById(String Id);

    public ResponseEntity<String> updateStudentDetails(StudentUpdateRequestVo request);



    public ResponseEntity<String>  deleteStudentsById(String Id);
    public boolean authenticateUser(String id , String name);


}
