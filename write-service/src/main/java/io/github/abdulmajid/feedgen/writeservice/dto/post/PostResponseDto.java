package io.github.abdulmajid.feedgen.writeservice.dto.post;

import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class PostResponseDto {
    private UUID id;
    private String content;
    private Instant created;
    private Instant updated;
    private UUID userId;
}

