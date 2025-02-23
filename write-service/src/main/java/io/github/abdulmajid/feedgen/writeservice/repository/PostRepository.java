package io.github.abdulmajid.feedgen.writeservice.repository;


import io.github.abdulmajid.feedgen.writeservice.entity.Post;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface PostRepository extends CassandraRepository<Post, UUID> {
}
