package com.app.beans;


import lombok.Data;

@Data
public class StudentVo {

    private String name;

    private String fatherName;
    private String email;
    private String phoneNumber;

    private String status = "fee pending";
}
