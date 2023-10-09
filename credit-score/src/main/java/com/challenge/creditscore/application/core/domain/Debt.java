package com.challenge.creditscore.application.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Debt {

    public Debt(long id, LocalDateTime debtDueDate, BigDecimal originalValue, BigDecimal currentBalance, String typeOfDebt, String debtStatus) {
        this.id = id;
        this.debtDueDate = debtDueDate;
        this.originalValue = originalValue;
        this.currentBalance = currentBalance;
        this.typeOfDebt = typeOfDebt;
        this.debtStatus = debtStatus;
    }

    public Debt() {
    }

    private long id ;
    private LocalDateTime debtDueDate ;
    private BigDecimal originalValue;
    private BigDecimal currentBalance;
    private String typeOfDebt;
    private String debtStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDebtDueDate() {
        return debtDueDate;
    }

    public void setDebtDueDate(LocalDateTime debtDueDate) {
        this.debtDueDate = debtDueDate;
    }

    public BigDecimal getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(BigDecimal originalValue) {
        this.originalValue = originalValue;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getTypeOfDebt() {
        return typeOfDebt;
    }

    public void setTypeOfDebt(String typeOfDebt) {
        this.typeOfDebt = typeOfDebt;
    }

    public String getDebtStatus() {
        return debtStatus;
    }

    public void setDebtStatus(String debtStatus) {
        this.debtStatus = debtStatus;
    }
}
