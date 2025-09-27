package com.satish.production_ready_features.production_ready_features.services;

import com.satish.production_ready_features.production_ready_features.dtos.PostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    List<PostDTO> getAllPosts();
    PostDTO  createNewPost(PostDTO inputPost);
}
