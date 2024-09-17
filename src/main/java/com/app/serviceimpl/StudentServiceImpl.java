package com.app.serviceimpl;

import com.app.Exceptions.InputInvalidException;
import com.app.Exceptions.StudentAccountNotFoundExceptions;
import com.app.beans.StudentCreatedResponse;
import com.app.beans.StudentUpdateRequestVo;
import com.app.beans.StudentVo;
import com.app.dao.StudentDao;
import com.app.entity.Student;
import com.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public StudentCreatedResponse createStudent(StudentVo studentVO) {

        Student student = new Student();

        student.generateCustomId();
        student.setName(studentVO.getName());
        student.setEmail(studentVO.getEmail());
        student.setFatherName(studentVO.getFatherName());
        student.setPhoneNumber(studentVO.getPhoneNumber());

        return studentDao.save(student) ;
    }

    @Override
    public ResponseEntity<List<Student>> getAllStudents() {


        return studentDao.getAllStudent();
    }

    @Override
    public Student getStudentById(String Id) {

        return studentDao.getStudentById(Id);
    }

    @Override
    public ResponseEntity<String> updateStudentDetails(StudentUpdateRequestVo request) {


        if(request.getId()==null){
                new InputInvalidException("please provide  proper Input values");
        }

        Student student = studentDao.getStudentById(request.getId());

        if(ObjectUtils.isEmpty(student)){
            new StudentAccountNotFoundExceptions("Invalid Student Id Number .");
        }


        if(request.getName() != null){
            student.setName(request.getName());
        }

        if(request.getEmail() != null){
            student.setEmail(request.getEmail());
        }

        if(request.getFatherName() != null){
            student.setFatherName(request.getFatherName());
        }

        if(request.getPhoneNumber() != null){
            student.setPhoneNumber(request.getPhoneNumber());
        }
        if (request.getStatus() != null){
            student.setStatus(request.getStatus());
        }

        Student studentAfterUpdate = studentDao.saveOrUpdate(student);


        if(studentAfterUpdate != null){
           return new ResponseEntity<String> ("Student Details Updated SuccesFully" , HttpStatus.OK);
        }




        return new ResponseEntity<String>("Error while updating student details .", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> deleteStudentsById(String id) {

        if(id == null){
          return   new ResponseEntity<String>("please provide proper input Values",HttpStatus.BAD_REQUEST);
        }

        try{
              studentDao.deleteStudentById(id);
        }catch (Exception e){

            return  new ResponseEntity<String>("Error While deleting",HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<String>("Deleted SuccesFully", HttpStatus.OK);
    }

    @Override
    public boolean authenticateUser(String id, String name) {
        Student std = studentDao.getStudentById(id);

        return std != null && std.getId().equals(id);
    }
}
