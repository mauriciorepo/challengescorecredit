package com.challenge.creditscore.adapters.out;

import com.challenge.creditscore.adapters.out.repository.ScoreCreditRepository;
import com.challenge.creditscore.adapters.out.repository.entity.mapper.ScoreCreditEntityMapper;
import com.challenge.creditscore.application.core.domain.ScoreCredit;
import com.challenge.creditscore.application.ports.out.CreateScoreCreditOutputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
@Slf4j
public class CreateScoreCreditAdapter implements CreateScoreCreditOutputPort {
    @Autowired
    private ScoreCreditRepository scoreCreditRepository;
    @Autowired
    private ScoreCreditEntityMapper scoreCreditEntityMapper;
    @Override
    public void create(ScoreCredit scoreCredit) {
        var scoreCreditEntity = scoreCreditEntityMapper.toScoreCreditEntity(scoreCredit);
        try {
            scoreCreditRepository.save(scoreCreditEntity);

        }catch (Exception ex ){
            log.error("Erro ao inserir score data :"+scoreCredit.toString() + "Error: " + ex.getCause().getMessage());
        }

    }
}
