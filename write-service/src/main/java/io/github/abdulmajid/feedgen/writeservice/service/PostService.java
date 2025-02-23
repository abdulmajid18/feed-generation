package io.github.abdulmajid.feedgen.writeservice.service;


import io.github.abdulmajid.feedgen.writeservice.dto.post.PostCreateDto;
import io.github.abdulmajid.feedgen.writeservice.dto.post.PostResponseDto;
import io.github.abdulmajid.feedgen.writeservice.dto.post.PostUpdateDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostService {
    List<PostResponseDto> getAllPosts();
    Optional<PostResponseDto> getPostById(UUID id);
    List<PostResponseDto> getPostsByUserId(UUID userId);
    PostResponseDto createPost(PostCreateDto postCreateDto);
    PostResponseDto updatePost(UUID id, PostUpdateDto postUpdateDto);
    void deletePost(UUID id);
}
