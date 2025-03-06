package io.github.abdulmajid18.feedgeneration.server.service;

import io.github.abdulmajid18.feedgeneration.server.dtos.PostCreate;
import io.github.abdulmajid18.feedgeneration.server.models.Post;

public interface PostService {
    Post createPost(PostCreate postCreate);
}
