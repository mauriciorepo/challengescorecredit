package com.challenge.usercriticaldata.adapters.out;

import com.challenge.usercriticaldata.adapters.out.repository.UserRepository;
import com.challenge.usercriticaldata.adapters.out.repository.entity.mapper.UserEntityMapper;
import com.challenge.usercriticaldata.application.core.domain.User;
import com.challenge.usercriticaldata.application.ports.out.FindUserByCpfOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindUserByCpfAdapter implements FindUserByCpfOutputPort {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserEntityMapper userEntityMapper;

    @Override
    public Optional<User> find(String cpf) {

        var userEntity = userRepository.findByCpf(cpf);

        return userEntity.map(userEntityMapper::toUser);
    }
}
