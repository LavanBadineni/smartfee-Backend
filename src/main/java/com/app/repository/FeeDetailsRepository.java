package com.app.repository;

import com.app.entity.FeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeeDetailsRepository extends JpaRepository<FeeDetails, String> {

    List<FeeDetails> findByStudentId(String studentId);
}
