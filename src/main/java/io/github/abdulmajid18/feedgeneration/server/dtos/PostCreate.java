package io.github.abdulmajid18.feedgeneration.server.dtos;

import java.util.UUID;

public class PostCreate {
    private String content;
    private UUID userId;

    public PostCreate() {};
    public PostCreate(String content, UUID userId) {
        this.content = content;
        this.userId = userId;
    }

    // Getters and setters
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Post{content='" + content + "', userId=" + userId + "}";
    }
}

