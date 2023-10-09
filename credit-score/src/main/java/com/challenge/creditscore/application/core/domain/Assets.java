package com.challenge.creditscore.application.core.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Assets {

  public Assets(String description, String type, BigDecimal value, LocalDate purchase_date) {
    this.description = description;
    this.type = type;
    this.value = value;
    this.purchase_date = purchase_date;
  }

  public Assets() {
  }

  private String description;
  private String type;
  private BigDecimal value;
  private LocalDate purchase_date;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public LocalDate getPurchase_date() {
    return purchase_date;
  }

  public void setPurchase_date(LocalDate purchase_date) {
    this.purchase_date = purchase_date;
  }
}
