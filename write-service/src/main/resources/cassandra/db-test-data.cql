USE instagram;

-- Insert sample posts
INSERT INTO post (id, content, created, updated, user_id)
VALUES (uuid(), 'First post!', toTimestamp(now()), toTimestamp(now()), uuid());

-- Insert sample comments
INSERT INTO comment_by_post (post_id, id, content, created, user_id)
VALUES (uuid(), uuid(), 'Nice post!', toTimestamp(now()), uuid());

-- Insert sample likes
INSERT INTO likes (entity_id, entity_type, user_id, created)
VALUES (uuid(), 'POST', uuid(), toTimestamp(now()));
