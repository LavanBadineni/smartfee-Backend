package com.app.entity;

import com.app.Utilities.IdGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {

    @Id
    private String id;

    private String name;
    private String fatherName;
    private String email;
    private String phoneNumber;

    private String status = "fee pending";

    public void generateCustomId() {
        this.id = IdGenerator.generateCustomId();
    }
}
