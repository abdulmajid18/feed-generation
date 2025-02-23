package io.github.abdulmajid.feedgen.writeservice.repository;


import io.github.abdulmajid.feedgen.writeservice.entity.Comment;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CassandraRepository<Comment, Comment.CommentKey> {
}
