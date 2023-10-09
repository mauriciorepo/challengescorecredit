package com.challenge.usercriticaldata.adapters.in.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebtRequest {
    private long id ;
    private LocalDateTime debtDueDate ;
    private BigDecimal originalValue;
    private BigDecimal currentBalance;
    private String typeOfDebt;
    private String debtStatus;

}
