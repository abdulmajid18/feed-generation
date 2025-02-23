package io.github.abdulmajid.feedgen.writeservice.dto.comment;


import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class CommentResponseDto {
    private UUID postId;
    private UUID id;
    private String content;
    private Instant created;
    private UUID userId;
}
