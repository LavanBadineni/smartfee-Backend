package com.app.serviceimpl;

import com.app.beans.AdminVo;
import com.app.beans.StudentCreatedResponse;
import com.app.dao.AdminDao;
import com.app.entity.Admin;
import com.app.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    AdminDao adminDao;

    @Override
    public StudentCreatedResponse createAdmin(AdminVo adminVo) {
        Admin admin = new Admin();
        admin.generateCustomId();
        admin.setName(adminVo.getName());
        return adminDao.save(admin);
    }

    @Override
    public boolean authenticateUser(String id, String name) {
        Admin admin = adminDao.getAdminById(id);

        return admin != null && admin.getId().equals(id);
    }
}
