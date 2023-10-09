package com.challenge.usercriticaldata.application.ports.out;

import com.challenge.usercriticaldata.application.core.domain.User;

import java.util.Optional;

public interface FindUserByCpfOutputPort {

    public Optional<User> find(String cpf);
}
