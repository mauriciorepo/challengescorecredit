package com.challenge.creditscore.application.config;

import com.challenge.creditscore.application.core.usecase.CalculateScoreCreditUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculateScoreCreditConfig {
    @Bean
    public CalculateScoreCreditUseCase calculateScoreCreditUseCase(){
        return new CalculateScoreCreditUseCase();
    }


}
