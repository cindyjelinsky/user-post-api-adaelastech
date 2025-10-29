package com.chj.postapi;

import com.chj.postapi.entity.Post;
import com.chj.postapi.httpservice.HttpService;
import com.chj.postapi.repository.PostRepository;
import com.chj.postapi.service.PostService;
import com.chj.postapi.util.JsonUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.http.HttpClient;

@SpringBootApplication
public class PostApiApplication {

    public static void main(String[] args){
        SpringApplication.run(PostApiApplication.class, args);


    }




}
