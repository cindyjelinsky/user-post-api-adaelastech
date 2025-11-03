package com.chj.postapi.service;

import com.chj.postapi.entity.Post;
import com.chj.postapi.entity.User;
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

    public PostService(HttpService httpService, PostRepository postRepository, UserService userService) {
        this.httpService = httpService;
        this.postRepository = postRepository;
        this.userService = userService;
    }


    public List<Post> savefFromJson() {
        String json = httpService.httpGetMultiple();
        List<Post> list = JsonUtil.fromJsonToList(json, "posts", Post.class);
        postRepository.saveAll(list);
        return list;
    }

    public Post savePost(Post post) {
        User user = userService.findByEmail(post.getUser().getEmail());
        post.setUser(user);
        return postRepository.save(post);
    }

    public List<Post> findPostByUser(String email) {
        User userExists = userService.findByEmail(email);
        return postRepository.findByUser(userExists);
    }


}
