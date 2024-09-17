package com.app.daoimpl;

import com.app.beans.StudentCreatedResponse;
import com.app.dao.AdminDao;
import com.app.entity.Admin;
import com.app.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AdminDaoImpl implements  AdminDao{

    @Autowired
    AdminRepository adminRepository;


    @Override
    public StudentCreatedResponse save(Admin admin) {

        Admin adminDetails =  adminRepository.save(admin);
        StudentCreatedResponse response = new StudentCreatedResponse();
        response.setResponseCode(200);
        response.setMessage("Admin details created successfully");

        return response;
    }

    @Override
    public Admin getAdminById(String id) {
        Optional<Admin> admin = adminRepository.findById(id);

        return admin.get();
    }
}
