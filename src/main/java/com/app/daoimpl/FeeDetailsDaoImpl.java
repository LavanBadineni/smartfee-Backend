package com.app.daoimpl;

import com.app.beans.FeeDetailsVo;
import com.app.beans.StudentCreatedResponse;
import com.app.dao.FeeDetailsDao;
import com.app.entity.FeeDetails;
import com.app.repository.FeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FeeDetailsDaoImpl implements FeeDetailsDao {

    @Autowired
    FeeDetailsRepository feeDetailsRepository;

    @Override
    public List<FeeDetails> getFeeDetailsByStudentId(String studentId) {
        return feeDetailsRepository.findByStudentId(studentId);
    }

    @Override
    public FeeDetails addFeeDetails(FeeDetails feeDetails) {
        return feeDetailsRepository.save(feeDetails);
    }

    @Override
    public StudentCreatedResponse createFeeDetails(FeeDetails details) {
        FeeDetails feeDetails = feeDetailsRepository.save(details);
        StudentCreatedResponse studentCreatedResponse = new StudentCreatedResponse();
        studentCreatedResponse.setMessage("FeeDetails Created Successfully");
        studentCreatedResponse.setResponseCode(200);
        return studentCreatedResponse;
    }
}
