package com.challenge.creditscore.adapters.out.repository.entity.mapper;

import com.challenge.creditscore.adapters.in.controller.request.ScoreCreditRequest;
import com.challenge.creditscore.adapters.out.repository.entity.ScoreCreditEntity;
import com.challenge.creditscore.application.core.domain.ScoreCredit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScoreCreditEntityMapper {

    ScoreCredit toScoreCredit(ScoreCreditEntity scoreCreditEntity);

    ScoreCreditEntity toScoreCreditEntity(ScoreCredit scoreCredit);

}
