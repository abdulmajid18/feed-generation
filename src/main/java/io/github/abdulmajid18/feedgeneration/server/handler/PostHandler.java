package io.github.abdulmajid18.feedgeneration.server.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import io.github.abdulmajid18.feedgeneration.server.di.ObjectMapperSingleton;
import io.github.abdulmajid18.feedgeneration.server.dtos.PostCreate;
import io.github.abdulmajid18.feedgeneration.server.models.Post;
import io.github.abdulmajid18.feedgeneration.server.service.PostService;
import io.github.abdulmajid18.feedgeneration.server.service.impl.PostServiceImpl;
import io.github.abdulmajid18.feedgeneration.server.statuscodes.HttpStatus;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PostHandler extends AbstractHandler{
    private final ObjectMapper objectMapper = ObjectMapperSingleton.getInstance();

    private final PostService postService = PostServiceImpl.getInstance();

    @Override
    protected void handleRequest(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        if (requestMethod.equalsIgnoreCase("POST")){
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            InputStream inputStream = exchange.getRequestBody();
            String body =  readRequestBody(inputStream);

            try {
                PostCreate post = objectMapper.readValue(body, PostCreate.class);
                Post createdPost = postService.createPost(post);
                String jsonResponse = objectMapper.writeValueAsString(createdPost);
                exchange.sendResponseHeaders(HttpStatus.CREATED.getCode(), 0);
                try (OutputStream os = exchange.getResponseBody()){
                    os.write(jsonResponse.getBytes(StandardCharsets.UTF_8));
                }
            } catch (Exception e) {
                e.printStackTrace();
                exchange.sendResponseHeaders(HttpStatus.BAD_REQUEST.getCode(), 0);
            }

        }
    }

    String readRequestBody(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder body = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            body.append(line);
        }
        return body.toString();
    }
}
