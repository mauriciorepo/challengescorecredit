package com.challenge.creditscore.adapters.out.repository.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "scorecredit")
@Data
public class ScoreCreditEntity {

    private String id;
    private String address;
    private String sourceOfIncome;
    List<AssetsEntity> assets;
    private String cpf;
}
