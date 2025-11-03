package com.chj.postapi.entity.mapper;


import com.chj.postapi.entity.Post;
import com.chj.postapi.entity.dto.PostRequestDto;
import com.chj.postapi.entity.dto.PostResponseDto;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@NoArgsConstructor
public class Mapper {


    public  Post postDtoToPost(PostRequestDto postDto){

         return  Post.builder()
                .title(postDto.getTitle())
                .body(postDto.getBody())
                .user(postDto.getUser())
                .build();

    }

    public PostResponseDto postToPostResponseDto(Post post) {
        return PostResponseDto.builder()
                .title(post.getTitle())
                .body(post.getBody())
                .userName(post.getUser().getFirstName())
                .build();
    }



}
