package io.github.abdulmajid.feedgen.writeservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.io.Serializable;
import java.util.UUID;
import java.time.Instant;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.mapping.*;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.*;

@Table("comment_by_post")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @PrimaryKeyClass
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CommentKey implements Serializable {  // Implementing Serializable
        private static final long serialVersionUID = 1L; // Best practice for Serializable

        @PrimaryKeyColumn(name = "post_id", type = PARTITIONED)
        private UUID postId;

        @PrimaryKeyColumn(name = "id", type = CLUSTERED, ordering = Ordering.ASCENDING)
        private UUID id;
    }

    @PrimaryKey
    private CommentKey key;

    @Column("content")
    private String content;

    @Column("created")
    private Instant created;

    @Column("user_id")
    private UUID userId;
}
