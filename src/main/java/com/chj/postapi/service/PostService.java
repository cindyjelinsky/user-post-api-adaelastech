package com.chj.postapi.service;

import com.chj.postapi.entity.Post;
import com.chj.postapi.httpservice.HttpService;
import com.chj.postapi.repository.PostRepository;
import com.chj.postapi.util.JsonUtil;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PostService {

    private final HttpService httpService;
    private final PostRepository postRepository;

    public PostService(HttpService httpService, PostRepository postRepository) {
        this.httpService = httpService;
        this.postRepository = postRepository;
    }





    public Post savefFromHttp() {

        Post post = JsonUtil.fromJsonToEntity(httpService.httpGetSingle(), Post.class);
        postRepository.save(post);

        return post;
    }

    public List<Post> savefFromJson() {
        String json = httpService.httpGetMultiple();
        List<Post> list = JsonUtil.fromJsonToList(json, "posts", Post.class);
        postRepository.saveAll(list);
        return list;
    }


}
