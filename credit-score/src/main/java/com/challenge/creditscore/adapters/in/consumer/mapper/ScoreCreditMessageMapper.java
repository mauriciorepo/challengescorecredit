package com.challenge.creditscore.adapters.in.consumer.mapper;

import com.challenge.creditscore.adapters.in.consumer.message.ScoreCreditMessage;
import com.challenge.creditscore.application.core.domain.ScoreCredit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ScoreCreditMessageMapper {

    @Mapping( source = "source_of_income",target = "sourceOfIncome")
    ScoreCredit toScoreCredit(ScoreCreditMessage scoreCreditMessage);

    @Mapping( target = "source_of_income",source = "sourceOfIncome")
    ScoreCreditMessage toScoreCreditMessage(ScoreCredit scoreCredit);

}
