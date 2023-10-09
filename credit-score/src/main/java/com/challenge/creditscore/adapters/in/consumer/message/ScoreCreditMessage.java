package com.challenge.creditscore.adapters.in.consumer.message;

import com.challenge.creditscore.application.core.domain.Assets;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreCreditMessage {

    private String id;
    private String address;
    private String source_of_income;
    List<Assets> assets;
    private String cpf;
}
