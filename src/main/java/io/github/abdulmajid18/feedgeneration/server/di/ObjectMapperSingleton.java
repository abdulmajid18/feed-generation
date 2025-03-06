package io.github.abdulmajid18.feedgeneration.server.di;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperSingleton {
    private static final ObjectMapper INSTANCE = new ObjectMapper();

    private ObjectMapperSingleton() {}

    public static ObjectMapper getInstance() {
        return INSTANCE;
    }
}