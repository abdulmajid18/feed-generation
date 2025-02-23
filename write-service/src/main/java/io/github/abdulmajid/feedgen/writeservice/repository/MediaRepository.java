package io.github.abdulmajid.feedgen.writeservice.repository;

import io.github.abdulmajid.feedgen.writeservice.entity.Media;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepository extends CassandraRepository<Media, Media.MediaKey> {
}
