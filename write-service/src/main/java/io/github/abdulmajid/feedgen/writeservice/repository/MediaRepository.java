package io.github.abdulmajid.feedgen.writeservice.repository;

import io.github.abdulmajid.feedgen.writeservice.entity.Media;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MediaRepository extends CassandraRepository<Media, Media.MediaKey> {
    List<Media> findByKeyEntityIdAndKeyEntityType(UUID entityId, String entityType);
}
