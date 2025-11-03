package com.chj.postapi.controller;

import com.chj.postapi.entity.Post;
import com.chj.postapi.entity.User;
import com.chj.postapi.entity.dto.PostRequestDto;
import com.chj.postapi.entity.dto.PostResponseDto;
import com.chj.postapi.entity.mapper.Mapper;
import com.chj.postapi.repository.PostRepository;
import com.chj.postapi.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private PostService postService;
    private final Mapper mapper;

    public PostController(PostService postService, Mapper mapper) {
        this.postService = postService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<Void> savePost(@RequestBody PostRequestDto postRequestDto) {
        Post post = mapper.postDtoToPost(postRequestDto);
        postService.savePost(post);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDto>> getAllPostsByUser(@RequestParam("email") String email) {

        List<Post> posts = postService.findPostByUser(email);
        List<PostResponseDto> response = posts.stream()
                .map(post -> mapper.postToPostResponseDto(post)).toList();
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }


}
