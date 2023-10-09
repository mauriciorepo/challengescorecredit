package com.challenge.creditscore.application.ports.out;

import com.challenge.creditscore.application.core.domain.User;

public interface FindUserByCpfOutputPort {

    public User find(String cpf);
}
