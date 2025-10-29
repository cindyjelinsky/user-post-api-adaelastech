package com.chj.postapi.util;

import com.chj.postapi.entity.Post;
import com.chj.postapi.entity.User;
import com.chj.postapi.service.PostService;
import com.chj.postapi.service.UserService;
import org.hibernate.annotations.Comment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component()
public class DataLoader implements CommandLineRunner {

    private final PostService postService;
    private final UserService userService;

    public DataLoader(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {


        User user =  userService.saveUserFromHttp();
        System.out.println("User saved on DB:" + user);

        List<User> users = userService.saveAllUserFromHttp();
        System.out.println("Users saved on DB:" + users);

        Post post = postService.savefFromHttp();
        System.out.println("Post saved on DB:" + post);

        List<Post> posts = postService.savefFromJson();
        System.out.println("Posts saved on DB:" + posts);


    }
}
