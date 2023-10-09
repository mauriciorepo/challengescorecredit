package com.challenge.usercriticaldata.adapters.out.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "debt")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DebtEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column(name = "debt_due_date")
    private LocalDateTime debtDueDate ;
    @Column(name = "original_value")
    private BigDecimal originalValue;
    @Column(name = "current_balance")
    private BigDecimal currentBalance ;
    @Column(name = "type_of_debt")
    private String typeOfDebt;
    @Column(name = "debt_status")
    private String debtStatus;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
