package io.github.abdulmajid.feedgen.writeservice.service;


import io.github.abdulmajid.feedgen.writeservice.dto.like.LikeCreateDto;
import io.github.abdulmajid.feedgen.writeservice.dto.like.LikeResponseDto;
import io.github.abdulmajid.feedgen.writeservice.entity.Like;

import java.util.List;
import java.util.UUID;

public interface LikesService {
    LikeResponseDto addLike(LikeCreateDto likeCreateDto);
    List<LikeResponseDto> getLikesByEntity(UUID entityId, String entityType);
    void removeLike(UUID entityId, String entityType, UUID userId);
}
