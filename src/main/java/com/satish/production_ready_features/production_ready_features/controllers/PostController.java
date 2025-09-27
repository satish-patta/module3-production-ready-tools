package com.satish.production_ready_features.production_ready_features.controllers;

import com.satish.production_ready_features.production_ready_features.dtos.PostDTO;
import com.satish.production_ready_features.production_ready_features.services.PostServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/posts")
public class PostController {

    private final PostServiceImp postServiceImp;

    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postServiceImp.getAllPosts();
    }

    @GetMapping(path = "/{postId}")
    public PostDTO getPostById(@PathVariable Long postId) {
        return postServiceImp.getPostById(postId);
    }

    @PostMapping
    public PostDTO createPost(@RequestBody PostDTO inputPostDto) {
        return postServiceImp.createNewPost(inputPostDto);
    }
}
