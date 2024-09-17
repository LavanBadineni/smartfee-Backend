package com.app.beans;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class FeeDetailsVo {

    private String studentId;

    private BigDecimal amount;
    private Date paymentDate;
}
