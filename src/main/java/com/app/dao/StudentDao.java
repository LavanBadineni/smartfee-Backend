package com.app.dao;

import com.app.beans.StudentCreatedResponse;
import com.app.entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentDao {

    public StudentCreatedResponse save(Student student);

    public ResponseEntity<List<Student>> getAllStudent();

    public Student saveOrUpdate(Student student);

    public Student getStudentById(String Id);

    public void deleteStudentById(String Id);


}
