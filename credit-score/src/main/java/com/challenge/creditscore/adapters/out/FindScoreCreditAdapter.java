package com.challenge.creditscore.adapters.out;

import com.challenge.creditscore.adapters.out.repository.ScoreCreditRepository;
import com.challenge.creditscore.adapters.out.repository.entity.mapper.ScoreCreditEntityMapper;
import com.challenge.creditscore.application.core.domain.ScoreCredit;
import com.challenge.creditscore.application.ports.out.FindScoreCreditOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindScoreCreditAdapter implements FindScoreCreditOutputPort {

    @Autowired
    private ScoreCreditRepository scoreCreditRepository;
    @Autowired
    private ScoreCreditEntityMapper scoreCreditEntityMapper;
    @Override
    public Optional<ScoreCredit> find(String cpf) {

        var scoreCreditEntity = scoreCreditRepository.findByCpf(cpf);
        return scoreCreditEntity.map(scoreCreditEntityMapper::toScoreCredit);
    }
}
