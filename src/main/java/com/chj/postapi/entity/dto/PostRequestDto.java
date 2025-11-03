package com.chj.postapi.entity.dto;

import com.chj.postapi.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDto {

    private String title;
    private String body;
    private User user;


}
