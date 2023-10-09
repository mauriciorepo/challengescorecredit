package com.challenge.creditscore.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class AssetsRequest {

  private String description;

  private String type;

  private BigDecimal value;

  private LocalDate purchase_date;
}
