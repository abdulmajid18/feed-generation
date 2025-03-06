package io.github.abdulmajid18.feedgeneration.server.service.impl;

import io.github.abdulmajid18.feedgeneration.server.dtos.PostCreate;
import io.github.abdulmajid18.feedgeneration.server.models.Post;
import io.github.abdulmajid18.feedgeneration.server.service.PostService;

import java.time.LocalDateTime;
import java.util.UUID;

public class PostServiceImpl implements PostService {
    private static final PostServiceImpl INSTANCE = new PostServiceImpl();

    public static PostServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public Post createPost(PostCreate postCreate) {
        return new Post(
                UUID.fromString("f47ac10b-58cc-4372-a567-0e02b2c3d479"), // Default UUID
                postCreate.getContent(),
                LocalDateTime.now(), // Created timestamp using LocalDateTime
                LocalDateTime.now(), // Updated timestamp using LocalDateTime
                postCreate.getUserId()
        );
    }
}
