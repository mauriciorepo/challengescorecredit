package com.challenge.creditscore.adapters.out;

import com.challenge.creditscore.adapters.in.consumer.mapper.ScoreCreditMessageMapper;
import com.challenge.creditscore.adapters.in.consumer.message.ScoreCreditMessage;
import com.challenge.creditscore.application.core.domain.ScoreCredit;
import com.challenge.creditscore.application.ports.out.SendScoreCreditMessageOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendScoreCreditMessageAdapter implements SendScoreCreditMessageOutputPort {

   @Autowired
   private KafkaTemplate kafkaTemplate;
   @Autowired
   private ScoreCreditMessageMapper scoreCreditMessageMapper;
    @Override
    public void send(ScoreCredit scoreCredit) {
        var scoreCreditMessage =scoreCreditMessageMapper.toScoreCreditMessage(scoreCredit);
        kafkaTemplate.send("tp-score-data-lake",scoreCreditMessage);
    }
}
