package com.challenge.creditscore.application.ports.out;

import com.challenge.creditscore.application.core.domain.ScoreCredit;

import java.util.Optional;

public interface FindScoreCreditOutputPort {

    public Optional<ScoreCredit> find(String cpf);
}
