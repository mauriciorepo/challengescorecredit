package com.challenge.usercriticaldata.application.ports.in;

import com.challenge.usercriticaldata.application.core.domain.User;

import java.util.Optional;

public interface FindUserByCpfInputPort {

    public User find(String cpf);
}
