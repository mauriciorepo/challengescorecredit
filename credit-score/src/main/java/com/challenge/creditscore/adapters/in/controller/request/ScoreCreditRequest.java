package com.challenge.creditscore.adapters.in.controller.request;

import com.challenge.creditscore.adapters.out.repository.entity.AssetsEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
public class ScoreCreditRequest {

    @NotBlank
    @JsonDeserialize
    private String address;
    @JsonProperty("source_of_income")
    private String sourceOfIncome;
    @JsonProperty("assets")
    @JsonDeserialize
    List<AssetsRequest> assets;
   @JsonProperty("cpf")
   @JsonDeserialize
    private String cpf;
}
