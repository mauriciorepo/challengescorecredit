package com.challenge.usercriticaldata.adapters.out.repository;

import com.challenge.usercriticaldata.adapters.out.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {


    Optional<UserEntity> findByCpf(String cpf);
}
