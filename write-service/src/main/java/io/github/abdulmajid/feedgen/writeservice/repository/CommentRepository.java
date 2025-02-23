package io.github.abdulmajid.feedgen.writeservice.repository;

import io.github.abdulmajid.feedgen.writeservice.entity.Comment;
import io.github.abdulmajid.feedgen.writeservice.entity.Comment.CommentKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommentRepository extends CassandraRepository<Comment, CommentKey> {

    List<Comment> findByKeyPostId(UUID postId);

    void deleteByKeyPostIdAndKeyId(UUID postId, UUID id);
}
