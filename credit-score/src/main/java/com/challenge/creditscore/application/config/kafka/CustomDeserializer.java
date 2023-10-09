package com.challenge.creditscore.application.config.kafka;

import com.challenge.creditscore.adapters.in.consumer.message.ScoreCreditMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

public class CustomDeserializer implements Deserializer<ScoreCreditMessage> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ScoreCreditMessage deserialize(String topic, byte[] data) {
        try {
            if (data == null){
                return null;
            }
            objectMapper.findAndRegisterModules();
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            return objectMapper.readValue(new String(data, "UTF-8"), ScoreCreditMessage.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to ScoreCreditMessage");
        }
    }

}