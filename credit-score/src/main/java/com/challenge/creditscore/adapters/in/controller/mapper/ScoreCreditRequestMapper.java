package com.challenge.creditscore.adapters.in.controller.mapper;

import com.challenge.creditscore.adapters.in.controller.request.ScoreCreditRequest;
import com.challenge.creditscore.application.core.domain.ScoreCredit;
import org.mapstruct.Mapper;

@Mapper( componentModel = "spring")
public interface ScoreCreditRequestMapper {

    ScoreCredit toScoreCredit(ScoreCreditRequest scoreCreditRequest);


}
