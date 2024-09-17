package com.app.beans;


import lombok.Data;

@Data
public class StudentUpdateRequestVo {

    private String id;

    private String Name;

    private String fatherName;
    private String email;
    private String phoneNumber;

    private String status = "fee pending";
}
