package com.satish.production_ready_features.production_ready_features.services;

import com.satish.production_ready_features.production_ready_features.dtos.PostDTO;
import com.satish.production_ready_features.production_ready_features.entities.PostEntity;
import com.satish.production_ready_features.production_ready_features.exceptions.ResourceNotFoundException;
import com.satish.production_ready_features.production_ready_features.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostServiceImp  implements PostService{
    private final PostRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<PostDTO> getAllPosts() {
        return repository.findAll().
                stream().map(
                        postEntity -> mapper.map(postEntity,PostDTO.class)
                ).toList();
    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost) {
        return mapper.map(repository.save(mapper.map(inputPost, PostEntity.class)),PostDTO.class);
    }

    public PostDTO getPostById(Long postId) {
        return mapper
                .map(repository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post not found with id "+postId)),PostDTO.class);
    }
}
