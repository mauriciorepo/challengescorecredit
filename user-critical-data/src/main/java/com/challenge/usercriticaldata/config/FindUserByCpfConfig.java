package com.challenge.usercriticaldata.config;

import com.challenge.usercriticaldata.adapters.out.FindUserByCpfAdapter;
import com.challenge.usercriticaldata.application.core.usecase.FindUserByCpfUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindUserByCpfConfig {

    @Bean
    public FindUserByCpfUseCase findUserByCpfUseCase(FindUserByCpfAdapter findUserByCpfAdapter){
        return new FindUserByCpfUseCase(findUserByCpfAdapter);
    }
}
