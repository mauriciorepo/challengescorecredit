package com.challenge.creditscore.adapters.in.consumer.message;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetsMessage {
    private String description;
    private String type;
    private BigDecimal value;

    private String purchase_date;
}
