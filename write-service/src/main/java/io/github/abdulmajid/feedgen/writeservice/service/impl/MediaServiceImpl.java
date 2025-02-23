package io.github.abdulmajid.feedgen.writeservice.service.impl;

import io.github.abdulmajid.feedgen.writeservice.entity.Media;
import io.github.abdulmajid.feedgen.writeservice.repository.MediaRepository;
import io.github.abdulmajid.feedgen.writeservice.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService {

    private final MediaRepository mediaRepository;

    @Override
    public Media saveMedia(Media media) {
        return mediaRepository.save(media);
    }

    @Override
    public List<Media> getMediaByEntity(UUID entityId, String entityType) {
        return mediaRepository.findByKeyEntityIdAndKeyEntityType(entityId, entityType);
    }

    @Override
    public void deleteMedia(Media.MediaKey key) {
        mediaRepository.deleteById(key);
    }
}
