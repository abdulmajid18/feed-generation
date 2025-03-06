package io.github.abdulmajid18.feedgeneration.server.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Post {
    private UUID id;
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;
    private UUID userId;

    // Default constructor (needed for frameworks like Jackson, Hibernate)
    public Post() {
    }

    // Constructor with fields
    public Post(UUID id, String content, LocalDateTime created, LocalDateTime updated, UUID userId) {
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
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
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", userId=" + userId +
                '}';
    }
}
