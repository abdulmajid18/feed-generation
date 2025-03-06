package io.github.abdulmajid18.feedgeneration.server.di;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ObjectMapperSingleton {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        // Register the JavaTimeModule for handling LocalDateTime and other Java 8 Date/Time types
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // Disable timestamp serialization
    }

    public static ObjectMapper getInstance() {
        return objectMapper;
    }
}
