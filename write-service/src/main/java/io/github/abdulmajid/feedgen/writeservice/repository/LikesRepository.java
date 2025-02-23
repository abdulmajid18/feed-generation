package io.github.abdulmajid.feedgen.writeservice.repository;

import io.github.abdulmajid.feedgen.writeservice.entity.Likes;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends CassandraRepository<Likes, Likes.LikesKey> {
}
