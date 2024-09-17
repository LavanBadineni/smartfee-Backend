package com.app.service;

import com.app.beans.AdminVo;
import com.app.beans.StudentCreatedResponse;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    public StudentCreatedResponse createAdmin(AdminVo adminVo);
    public  boolean authenticateUser(String id , String name);
}
