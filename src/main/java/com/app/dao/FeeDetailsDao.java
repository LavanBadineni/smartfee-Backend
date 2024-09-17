package com.app.dao;

import com.app.beans.FeeDetailsVo;
import com.app.beans.StudentCreatedResponse;
import com.app.entity.FeeDetails;
import com.app.repository.FeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeeDetailsDao {

    public List<FeeDetails> getFeeDetailsByStudentId(String studentId) ;

    public FeeDetails addFeeDetails(FeeDetails feeDetails) ;

    public StudentCreatedResponse createFeeDetails(FeeDetails feeDetails);
}
