package io.github.abdulmajid18.feedgeneration.server.dtos;

public class BasicResponse {
    private String message;

    public BasicResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
