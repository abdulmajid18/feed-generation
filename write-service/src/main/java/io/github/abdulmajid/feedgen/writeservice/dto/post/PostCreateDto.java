package io.github.abdulmajid.feedgen.writeservice.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class PostCreateDto {
    private String content;
    private UUID userId;
}
