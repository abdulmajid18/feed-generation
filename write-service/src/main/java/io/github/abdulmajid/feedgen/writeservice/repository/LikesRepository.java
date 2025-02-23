package io.github.abdulmajid.feedgen.writeservice.repository;

import io.github.abdulmajid.feedgen.writeservice.entity.Like;
import io.github.abdulmajid.feedgen.writeservice.entity.Like.LikesKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LikesRepository extends CassandraRepository<Like, LikesKey> {

    List<Like> findByKeyEntityIdAndKeyEntityType(UUID entityId, String entityType);

    void deleteByKeyEntityIdAndKeyEntityTypeAndKeyUserId(UUID entityId, String entityType, UUID userId);
}
