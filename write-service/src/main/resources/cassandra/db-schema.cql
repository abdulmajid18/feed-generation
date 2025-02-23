-- Create Keyspace if not exists
CREATE KEYSPACE IF NOT EXISTS instagram
WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 3};

-- Use the Keyspace
USE instagram;

-- Create Post Table
CREATE TABLE IF NOT EXISTS post (
    id UUID PRIMARY KEY,
    content TEXT,
    created TIMESTAMP,
    updated TIMESTAMP,
    user_id UUID
);

-- Create Comment Table (Partitioned by post_id for efficient retrieval)
CREATE TABLE IF NOT EXISTS comment_by_post (
    post_id UUID,
    id UUID,
    content TEXT,
    created TIMESTAMP,
    user_id UUID,
    PRIMARY KEY (post_id, id)
) WITH CLUSTERING ORDER BY (id ASC);

-- Create Likes Table (Supports both Post and Comment Likes)
CREATE TABLE IF NOT EXISTS like (
    entity_id UUID,         -- Post ID or Comment ID
    entity_type TEXT,       -- 'POST' or 'COMMENT'
    user_id UUID,           -- User who liked
    created TIMESTAMP,
    PRIMARY KEY ((entity_id, entity_type), user_id)
) WITH CLUSTERING ORDER BY (user_id ASC);

-- Create Media Table (Stores Media URLs separately for scalability)
CREATE TABLE IF NOT EXISTS media (
    id UUID PRIMARY KEY,
    entity_id UUID,        -- Post ID or Comment ID
    entity_type TEXT,      -- 'POST' or 'COMMENT'
    media_url TEXT,
    uploaded TIMESTAMP
);
