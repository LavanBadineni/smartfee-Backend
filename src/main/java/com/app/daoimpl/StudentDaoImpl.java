package com.app.daoimpl;

import com.app.beans.StudentCreatedResponse;
import com.app.dao.StudentDao;
import com.app.entity.Student;
import com.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentCreatedResponse save(Student student) {

        Student std = studentRepository.save(student);

        StudentCreatedResponse response = new StudentCreatedResponse();

        response.setMessage("Student details created Successfully");
        response.setResponseCode(200);




        return response;
    }

    @Override
    public ResponseEntity<List<Student>> getAllStudent() {

        List<Student> allStudents = studentRepository.findAll();


        return new ResponseEntity<List<Student>>(allStudents , HttpStatus.OK);
    }

    @Override
    public Student saveOrUpdate(Student student) {

        Student studentAfterUpdate = studentRepository.save(student);

        return studentAfterUpdate;
    }

    @Override
    public Student getStudentById(String Id) {

        Optional<Student> student = studentRepository.findById(Id);

        return student.get();
    }

    @Override
    public void deleteStudentById(String Id) {

        studentRepository.deleteById(Id);

    }
}
