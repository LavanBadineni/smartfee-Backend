package com.app.service;

import com.app.beans.FeeDetailsVo;
import com.app.beans.StudentCreatedResponse;
import com.app.entity.FeeDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeeDetailsService {

    public List<FeeDetails> getFeeDetailsByStudentId(String studentId) ;

    public FeeDetails addFeeDetailsAndUpdateStudentStatus(FeeDetails feeDetails) ;

    public StudentCreatedResponse createFeeDetails(FeeDetailsVo feeDetailsVo);
}
