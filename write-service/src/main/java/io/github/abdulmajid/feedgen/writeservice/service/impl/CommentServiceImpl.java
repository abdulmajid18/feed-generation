package io.github.abdulmajid.feedgen.writeservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.abdulmajid.feedgen.writeservice.dto.comment.CommentCreateDto;
import io.github.abdulmajid.feedgen.writeservice.dto.comment.CommentResponseDto;
import io.github.abdulmajid.feedgen.writeservice.entity.Comment;
import io.github.abdulmajid.feedgen.writeservice.repository.CommentRepository;
import io.github.abdulmajid.feedgen.writeservice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ObjectMapper objectMapper;

    @Override
    public CommentResponseDto addComment(CommentCreateDto commentCreateDto) {
        Comment comment = new Comment();
        comment.setKey(new Comment.CommentKey(commentCreateDto.getPostId(), UUID.randomUUID()));
        comment.setContent(commentCreateDto.getContent());
        comment.setCreated(Instant.now());
        comment.setUserId(commentCreateDto.getUserId());

        Comment savedComment = commentRepository.save(comment);
        return objectMapper.convertValue(savedComment, CommentResponseDto.class);
    }

    @Override
    public List<Comment> getCommentsByPost(UUID postId) {
        return commentRepository.findByKeyPostId(postId);
    }

    @Override
    public void deleteComment(UUID postId, UUID commentId) {
        commentRepository.deleteByKeyPostIdAndKeyId(postId, commentId);
    }
}
