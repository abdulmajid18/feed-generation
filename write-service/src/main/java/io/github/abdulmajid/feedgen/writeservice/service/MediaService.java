package io.github.abdulmajid.feedgen.writeservice.service;

import io.github.abdulmajid.feedgen.writeservice.entity.Media;

import java.util.List;
import java.util.UUID;

public interface MediaService {
    Media saveMedia(Media media);
    List<Media> getMediaByEntity(UUID entityId, String entityType);
    void deleteMedia(Media.MediaKey key);
}
