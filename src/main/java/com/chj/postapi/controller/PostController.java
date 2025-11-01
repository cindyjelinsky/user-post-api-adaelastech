package com.chj.postapi.controller;

import com.chj.postapi.entity.Post;
import com.chj.postapi.repository.PostRepository;
import com.chj.postapi.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Post> savePost(@RequestBody  Post post){
        return  ResponseEntity.ok(postService.savePost(post));
    }


}
