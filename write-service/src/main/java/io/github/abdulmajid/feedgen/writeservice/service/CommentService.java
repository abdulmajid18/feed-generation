package io.github.abdulmajid.feedgen.writeservice.service;

import io.github.abdulmajid.feedgen.writeservice.dto.comment.CommentCreateDto;
import io.github.abdulmajid.feedgen.writeservice.dto.comment.CommentResponseDto;
import io.github.abdulmajid.feedgen.writeservice.entity.Comment;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    CommentResponseDto addComment(CommentCreateDto commentCreateDto);
    List<Comment> getCommentsByPost(UUID postId);
    void deleteComment(UUID postId, UUID commentId);
}
