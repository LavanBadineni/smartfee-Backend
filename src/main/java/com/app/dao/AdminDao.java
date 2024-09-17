package com.app.dao;

import com.app.beans.StudentCreatedResponse;
import com.app.entity.Admin;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {

    public StudentCreatedResponse save(Admin admin);


    public Admin getAdminById(String id);


}
