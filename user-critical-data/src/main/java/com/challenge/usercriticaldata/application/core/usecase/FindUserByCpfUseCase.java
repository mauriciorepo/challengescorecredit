package com.challenge.usercriticaldata.application.core.usecase;

import com.challenge.usercriticaldata.application.core.domain.User;
import com.challenge.usercriticaldata.application.core.exception.UserNotFoundException;
import com.challenge.usercriticaldata.application.ports.in.FindUserByCpfInputPort;
import com.challenge.usercriticaldata.application.ports.out.FindUserByCpfOutputPort;

public class FindUserByCpfUseCase implements FindUserByCpfInputPort {

    private final FindUserByCpfOutputPort findUserByCpfOutputPort;

    public FindUserByCpfUseCase(FindUserByCpfOutputPort findUserByCpfOutputPort) {
        this.findUserByCpfOutputPort = findUserByCpfOutputPort;
    }

    @Override
    public User find(String cpf) {
        var user = findUserByCpfOutputPort.find(cpf).orElseThrow(()-> new UserNotFoundException("User with cpf:"+cpf+" not found"));
        return user;
    }
}
