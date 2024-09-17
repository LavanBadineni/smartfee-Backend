package com.app.entity;

import com.app.Utilities.IdGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class FeeDetails {

    @Id
    private   String id;

    private String studentId;


    private BigDecimal amount;
    private Date paymentDate;

    public void generateCustomId() {
        this.id = IdGenerator.generateCustomId();
    }
}
