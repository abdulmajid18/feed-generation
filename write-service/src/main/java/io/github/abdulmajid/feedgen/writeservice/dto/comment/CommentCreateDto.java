package io.github.abdulmajid.feedgen.writeservice.dto.comment;


import lombok.*;

import java.util.UUID;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class CommentCreateDto {
    private UUID postId;
    private String content;
    private UUID userId;
}
