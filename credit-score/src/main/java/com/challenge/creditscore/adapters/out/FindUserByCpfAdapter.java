package com.challenge.creditscore.adapters.out;

import com.challenge.creditscore.adapters.out.client.FindUserByCpfClient;
import com.challenge.creditscore.adapters.out.client.mapper.UserResponseMapper;
import com.challenge.creditscore.application.core.domain.User;
import com.challenge.creditscore.application.ports.out.FindUserByCpfOutputPort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FindUserByCpfAdapter implements FindUserByCpfOutputPort {


    @Autowired
    private FindUserByCpfClient findUserByCpfClient;

    @Autowired
    private UserResponseMapper userResponseMapper;

    @Value("${user.access.token}")
    private String token;
    @Override
    public User find(String cpf) {
        var userResponse = findUserByCpfClient.find(cpf , token);
        return userResponseMapper.toUser(userResponse);
    }
}
