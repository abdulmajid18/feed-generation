package io.github.abdulmajid.feedgen.writeservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.mapping.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.*;

@Table("likes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Likes {

    @PrimaryKeyClass
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LikesKey implements Serializable {
        private static final long serialVersionUID = 1L;  // Required for serialization

        @PrimaryKeyColumn(name = "entity_id", type = PARTITIONED)
        private UUID entityId;

        @PrimaryKeyColumn(name = "entity_type", type = PARTITIONED)
        private String entityType;

        @PrimaryKeyColumn(name = "user_id", type = CLUSTERED, ordering = Ordering.ASCENDING)
        private UUID userId;
    }

    @PrimaryKey
    private LikesKey key;

    @Column("created")
    private Instant created;
}
