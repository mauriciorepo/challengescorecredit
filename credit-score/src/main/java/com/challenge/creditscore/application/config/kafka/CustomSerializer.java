package com.challenge.creditscore.application.config.kafka;

import com.challenge.creditscore.adapters.in.consumer.message.ScoreCreditMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.kafka.common.serialization.Serializer;

public class CustomSerializer implements Serializer<ScoreCreditMessage> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String s, ScoreCreditMessage scoreCreditMessage) {
        if(scoreCreditMessage == null){
            return null;
        }

        try {
            objectMapper.findAndRegisterModules();
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            return objectMapper.writeValueAsBytes(scoreCreditMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
