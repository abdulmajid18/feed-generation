package io.github.abdulmajid18.feedgeneration.server.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import io.github.abdulmajid18.feedgeneration.server.di.ObjectMapperSingleton;
import io.github.abdulmajid18.feedgeneration.server.dtos.BasicResponse;
import io.github.abdulmajid18.feedgeneration.server.statuscodes.HttpStatus;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class HomeHandler extends AbstractHandler{
    private final ObjectMapper objectMapper = ObjectMapperSingleton.getInstance();
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        BasicResponse response;
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        if (!requestMethod.equalsIgnoreCase("GET")){
            response = new BasicResponse(HttpStatus.METHOD_NOT_ALLOWED.getMessage());
            exchange.sendResponseHeaders(HttpStatus.METHOD_NOT_ALLOWED.getCode(), 0);
        } else {
            response = new BasicResponse("Welcome home!");
            exchange.sendResponseHeaders(HttpStatus.OK.getCode(), 0);
        }
        String jsonResponse = objectMapper.writeValueAsString(response);
        try (OutputStream os = exchange.getResponseBody()){
            os.write(jsonResponse.getBytes(StandardCharsets.UTF_8));
        }
    }
}
