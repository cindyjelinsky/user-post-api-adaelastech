package com.chj.postapi.entity.dto;

import com.chj.postapi.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDto {

    @NotBlank
    private String title;
    @NotBlank
    private String body;

}
