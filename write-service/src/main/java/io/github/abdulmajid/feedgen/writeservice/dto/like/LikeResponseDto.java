package io.github.abdulmajid.feedgen.writeservice.dto.like;


import lombok.*;

import java.util.UUID;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class LikeResponseDto {
    private UUID entityId;
    private String entityType;
    private UUID userId;
}

