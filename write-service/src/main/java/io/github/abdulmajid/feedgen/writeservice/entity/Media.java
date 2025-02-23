package io.github.abdulmajid.feedgen.writeservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;
import java.time.Instant;
import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.*;

@Table("media")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Media {

    @PrimaryKeyClass
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MediaKey implements Serializable {
        private static final long serialVersionUID = 1L;

        @PrimaryKeyColumn(name = "entity_id", type = PARTITIONED)
        private UUID entityId;

        @PrimaryKeyColumn(name = "entity_type", type = PARTITIONED)
        private String entityType;

        @PrimaryKeyColumn(name = "id", type = CLUSTERED, ordering = Ordering.ASCENDING)
        private UUID id;
    }

    @PrimaryKey
    private MediaKey key;

    @Column("media_url")
    private String mediaUrl;

    @Column("created_at")
    private Instant createdAt;
}
