package com.challenge.creditscore.application.config;

import com.challenge.creditscore.adapters.out.CreateScoreCreditAdapter;
import com.challenge.creditscore.adapters.out.SendScoreCreditMessageAdapter;
import com.challenge.creditscore.application.core.usecase.CreateScoreCreditUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateScoreCreditConfig {

    @Bean
    public CreateScoreCreditUseCase createScoreCreditUseCase(CreateScoreCreditAdapter createScoreCreditAdapter, SendScoreCreditMessageAdapter sendScoreCreditMessageAdapter){
        return new CreateScoreCreditUseCase(createScoreCreditAdapter, sendScoreCreditMessageAdapter);
    }
}
