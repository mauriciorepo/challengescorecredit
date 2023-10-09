package com.challenge.creditscore.adapters.out.repository.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class AssetsEntity {
  private String description;
  private String type;
  private BigDecimal value;
  private LocalDate purchase_date;
}
