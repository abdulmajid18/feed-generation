package io.github.abdulmajid.feedgen.writeservice.dto.like;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class LikeCountResponseDto {
    private UUID entityId;
    private String entityType;
    private long count;
}
