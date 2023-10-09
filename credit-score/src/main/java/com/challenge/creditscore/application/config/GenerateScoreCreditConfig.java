package com.challenge.creditscore.application.config;

import com.challenge.creditscore.adapters.out.FindScoreCreditAdapter;
import com.challenge.creditscore.adapters.out.FindUserByCpfAdapter;
import com.challenge.creditscore.application.core.usecase.CalculateScoreCreditUseCase;
import com.challenge.creditscore.application.core.usecase.GenerateScoreCreditUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenerateScoreCreditConfig {
    @Bean
    public GenerateScoreCreditUseCase generateScoreCreditUseCase(FindUserByCpfAdapter findUserByCpfAdapter,
                                                                 FindScoreCreditAdapter findScoreCreditAdapter,
                                                                 CalculateScoreCreditUseCase calculateScoreCreditUseCase
                                                                 ){
        return  new GenerateScoreCreditUseCase(findUserByCpfAdapter,
                    findScoreCreditAdapter,
                    calculateScoreCreditUseCase
                );
    }

}
