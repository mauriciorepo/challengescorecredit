package com.challenge.creditscore.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class TestFileLoader {

    @Setter
    String baseDirectory = "";
    @Setter
    ObjectMapper objectMapper;

    public InputStream loadStream(String filePath) {
        InputStream in = TestFileLoader.class.getResourceAsStream(baseDirectory + filePath);
        if (in == null) {
            throw new RuntimeException("File not found: " + filePath);
        }
        return in;
    }

    @SneakyThrows
    public String loadString(String filePath) {
        try (InputStream in = loadStream(filePath)) {
            return new String(in.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    @SneakyThrows
    public JsonNode loadJsonNode(String filePath) {
        return objectMapper.readTree(loadStream(filePath));
    }

    @SneakyThrows
    public <T> T loadObject(String filePath, Class<T> tClass) {
        return objectMapper.readValue(loadStream(filePath), tClass);
    }
}
