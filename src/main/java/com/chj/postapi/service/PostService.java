package com.chj.postapi.service;

import com.chj.postapi.entity.Post;
import com.chj.postapi.entity.User;
import com.chj.postapi.entity.dto.PostRequestDto;
import com.chj.postapi.entity.dto.PostResponseDto;
import com.chj.postapi.entity.mapper.Mapper;
import com.chj.postapi.httpservice.HttpService;
import com.chj.postapi.repository.PostRepository;
import com.chj.postapi.util.JsonUtil;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PostService {

    private final HttpService httpService;
    private final PostRepository postRepository;
    private final UserService userService;
    private final Mapper mapper;

    public PostService(HttpService httpService, PostRepository postRepository, UserService userService,Mapper mapper) {
        this.httpService = httpService;
        this.postRepository = postRepository;
        this.userService = userService;
        this.mapper = mapper;
    }


    public List<Post> savefFromJson() {
        String json = httpService.httpGetMultiple();
        List<Post> list = JsonUtil.fromJsonToList(json, "posts", Post.class);
        postRepository.saveAll(list);
        return list;
    }

    public PostResponseDto savePost(PostRequestDto postDto, String email) {
        User user = userService.findByEmail(email);
        Post post  = mapper.postDtoToPost(postDto);
        post.setUser(user);
        postRepository.save(post);
        return mapper.postToPostResponseDto(post);
    }

    public List<PostResponseDto> findAllPostsByUser(String email) {
        User userExists = userService.findByEmail(email);
        List<Post> posts = postRepository.findAllByUser_Id(userExists.getId());

        return posts.stream().map(mapper::postToPostResponseDto).toList();
    }

    public void deleteAll(String email) {
        User userExists = userService.findByEmail(email);
        postRepository.deleteAllByUser_Id(userExists.getId());
    }

    public Post findByIdAndUser(Long postId,String email) {
        User userExists = userService.findByEmail(email);
        return postRepository.findByIdAndUser_Id(postId,userExists.getId()).orElseThrow(() -> new RuntimeException("Post  not found or User Not Found"));
    }

    public PostResponseDto updatePost(Long postId,PostRequestDto postDto, String email) {
        User existingUser = userService.findByEmail(email);
        Post postToUpdate = postRepository.findByIdAndUser_Id(postId,existingUser.getId()).orElseThrow(() -> new RuntimeException("Post Not Found"));

        postToUpdate.setTitle(postDto.getTitle());
        postToUpdate.setBody(postDto.getBody());

        Post updated  = postRepository.save(postToUpdate);
        return mapper.postToPostResponseDto(updated);
    }


}
