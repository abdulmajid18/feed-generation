package io.github.abdulmajid18.feedgeneration.server.dtos;

import java.time.Instant;
import java.util.UUID;

public class PostResponse {
    private UUID id;
    private String content;
    private Instant created;
    private Instant updated;
    private UUID userId;

    // Default constructor (required for Jackson)
    public PostResponse() {
    }

    // All-args constructor (for easier object creation)
    public PostResponse(UUID id, String content, Instant created, Instant updated, UUID userId) {
        this.id = id;
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.userId = userId;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getUpdated() {
        return updated;
    }

    public void setUpdated(Instant updated) {
        this.updated = updated;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PostResponseDto{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", userId=" + userId +
                '}';
    }
}
