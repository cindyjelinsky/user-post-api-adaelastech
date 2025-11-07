package com.chj.postapi.controller;

import com.chj.postapi.entity.Post;
import com.chj.postapi.entity.User;
import com.chj.postapi.entity.dto.PostRequestDto;
import com.chj.postapi.entity.dto.PostResponseDto;
import com.chj.postapi.entity.mapper.Mapper;
import com.chj.postapi.repository.PostRepository;
import com.chj.postapi.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
          }

    @PostMapping
    public ResponseEntity<PostResponseDto> savePost(@Valid @RequestBody PostRequestDto postRequestDto, @RequestParam("email") String email) {
        PostResponseDto responseDto = postService.savePost(postRequestDto,email);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDto>> getAllPostsByUser(@Valid @RequestParam("email") String email) {

        List<PostResponseDto> response =  postService.findAllPostsByUser(email);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllPost(@Valid @RequestParam("email") String email) {
        postService.deleteAll(email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @PutMapping("/{postId}")
    public ResponseEntity<PostResponseDto> updatePost( @Valid @RequestBody PostRequestDto postRequestDto, @RequestParam("email") String email, @PathVariable("postId") Long postId) {

        PostResponseDto updated = postService.updatePost(postId,postRequestDto,email);

        return ResponseEntity.ok(updated);

    }

}
