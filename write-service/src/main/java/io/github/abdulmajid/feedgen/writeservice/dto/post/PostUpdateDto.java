package io.github.abdulmajid.feedgen.writeservice.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class PostUpdateDto {
    private UUID id;
    private String content;
    private Instant updated;
}
