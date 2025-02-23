package io.github.abdulmajid.feedgen.writeservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.abdulmajid.feedgen.writeservice.dto.post.PostCreateDto;
import io.github.abdulmajid.feedgen.writeservice.dto.post.PostResponseDto;
import io.github.abdulmajid.feedgen.writeservice.dto.post.PostUpdateDto;
import io.github.abdulmajid.feedgen.writeservice.entity.Post;
import io.github.abdulmajid.feedgen.writeservice.repository.PostRepository;
import io.github.abdulmajid.feedgen.writeservice.service.PostService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final ObjectMapper objectMapper;

    public PostServiceImpl(PostRepository postRepository, ObjectMapper objectMapper) {
        this.postRepository = postRepository;
        this.objectMapper = objectMapper;
    }

    public List<PostResponseDto> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(post -> objectMapper.convertValue(post, PostResponseDto.class))
                .collect(Collectors.toList());
    }

    // Get a single post by ID
    public Optional<PostResponseDto> getPostById(UUID postId) {
        return Optional.ofNullable(postRepository.findById(postId)
                .map(post -> objectMapper.convertValue(post, PostResponseDto.class))
                .orElseThrow(() -> new RuntimeException("Post not found")));
    }

    @Override
    public List<PostResponseDto> getPostsByUserId(UUID userId) {
        return postRepository.findAll()
                .stream()
                .map(post -> objectMapper.convertValue(post, PostResponseDto.class))
                .collect(Collectors.toList());
    }

    public PostResponseDto createPost(PostCreateDto postCreateDto) {
        Post post = objectMapper.convertValue(postCreateDto, Post.class);
        post.setId(UUID.randomUUID());
        post.setCreated(Instant.now());
        post.setUpdated(Instant.now());

        return objectMapper.convertValue(postRepository.save(post), PostResponseDto.class);
    }


    @Override
    public PostResponseDto updatePost(UUID id, PostUpdateDto postUpdateDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        post.setContent(postUpdateDto.getContent());
        post.setUpdated(Instant.now());

        return objectMapper.convertValue(postRepository.save(post), PostResponseDto.class);
    }

    @Override
    public void deletePost(UUID id) {
        if (!postRepository.existsById(id)) {
            throw new RuntimeException("Post not found");
        }
        postRepository.deleteById(id);
    }
}
