package com.challenge.creditscore.adapters.out.repository;

import com.challenge.creditscore.adapters.out.repository.entity.ScoreCreditEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface ScoreCreditRepository extends MongoRepository<ScoreCreditEntity, String> {

    Optional<ScoreCreditEntity> findByCpf(String cpf);
}
