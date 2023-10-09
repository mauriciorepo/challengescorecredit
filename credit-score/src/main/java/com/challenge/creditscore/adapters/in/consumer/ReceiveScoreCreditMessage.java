package com.challenge.creditscore.adapters.in.consumer;

import com.challenge.creditscore.adapters.in.consumer.mapper.ScoreCreditMessageMapper;
import com.challenge.creditscore.adapters.in.consumer.message.ScoreCreditMessage;
import com.challenge.creditscore.application.ports.in.CreateScoreCreditInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveScoreCreditMessage {

    @Autowired
    private ScoreCreditMessageMapper scoreCreditMessageMapper;
    @Autowired
    CreateScoreCreditInputPort createScoreCreditInputPort;

 @KafkaListener(topics = "tp-score-credit",groupId = "score")
 public void receive(ScoreCreditMessage scoreCreditMessage){
     var scoreCredit = scoreCreditMessageMapper.toScoreCredit(scoreCreditMessage);
     createScoreCreditInputPort.create(scoreCredit);
 }
}
