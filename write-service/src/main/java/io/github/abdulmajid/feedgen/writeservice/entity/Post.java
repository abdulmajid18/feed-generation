package io.github.abdulmajid.feedgen.writeservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("post")
public class Post {

    @PrimaryKey
    private UUID id;

    @Column("content")
    private String content;

    @Column("created")
    private Instant created;

    @Column("updated")
    private Instant updated;

    @Column("user_id")
    private UUID userId;
}
