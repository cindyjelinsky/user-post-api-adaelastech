package com.chj.postapi.entity.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class PostDto {

    private String title;
    private String body;
    private int views;
    private Long userId;


}
