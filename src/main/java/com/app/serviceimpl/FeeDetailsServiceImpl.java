package com.app.serviceimpl;

import com.app.beans.FeeDetailsVo;
import com.app.beans.StudentCreatedResponse;
import com.app.dao.FeeDetailsDao;
import com.app.entity.FeeDetails;
import com.app.entity.Student;
import com.app.service.FeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class FeeDetailsServiceImpl implements FeeDetailsService {
    @Autowired
    FeeDetailsDao feeDetailsDAO;

    @Override
    public List<FeeDetails> getFeeDetailsByStudentId(String studentId) {
        return feeDetailsDAO.getFeeDetailsByStudentId(studentId);
    }

    @Override
    public FeeDetails addFeeDetailsAndUpdateStudentStatus(FeeDetails feeDetails) {
        feeDetails.setPaymentDate(new Date());

        return feeDetailsDAO.addFeeDetails(feeDetails);
    }

    @Override
    public StudentCreatedResponse createFeeDetails(FeeDetailsVo feeDetailsVo) {
        FeeDetails feeDetails = new FeeDetails();

        feeDetails.generateCustomId();
        feeDetails.setStudentId(feeDetailsVo.getStudentId());
        feeDetails.setPaymentDate(feeDetailsVo.getPaymentDate());
        feeDetails.setAmount(feeDetailsVo.getAmount());

        return feeDetailsDAO.createFeeDetails(feeDetails);
    }
}
