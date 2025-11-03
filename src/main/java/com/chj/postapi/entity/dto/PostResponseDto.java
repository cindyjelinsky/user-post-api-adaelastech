package com.chj.postapi.entity.dto;

import com.chj.postapi.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostResponseDto {

    private String title;
    private String body;
    private String userName;

}
