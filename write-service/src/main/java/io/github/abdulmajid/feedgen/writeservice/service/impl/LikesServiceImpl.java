package io.github.abdulmajid.feedgen.writeservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.abdulmajid.feedgen.writeservice.dto.like.LikeCreateDto;
import io.github.abdulmajid.feedgen.writeservice.dto.like.LikeResponseDto;
import io.github.abdulmajid.feedgen.writeservice.entity.Like;
import io.github.abdulmajid.feedgen.writeservice.repository.LikesRepository;
import io.github.abdulmajid.feedgen.writeservice.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LikesServiceImpl implements LikesService {

    private final LikesRepository likesRepository;
    private final ObjectMapper objectMapper;

    @Override
    public LikeResponseDto addLike(LikeCreateDto likeCreateDto) {
        Like like = objectMapper.convertValue(likeCreateDto, Like.class);
        like.setCreated(Instant.now());
        return objectMapper.convertValue(likesRepository.save(like), LikeResponseDto.class);
    }

    @Override
    public List<LikeResponseDto> getLikesByEntity(UUID entityId, String entityType) {
        return likesRepository.findByKeyEntityIdAndKeyEntityType(entityId, entityType)
                .stream()
                .map(like -> objectMapper.convertValue(like, LikeResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void removeLike(UUID entityId, String entityType, UUID userId) {
        likesRepository.deleteByKeyEntityIdAndKeyEntityTypeAndKeyUserId(entityId, entityType, userId);
    }
}
