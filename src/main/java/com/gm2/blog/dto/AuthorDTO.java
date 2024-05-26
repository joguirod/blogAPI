package com.gm2.blog.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthorDTO(
    @NotBlank
    String name,
    @NotBlank
    int blogUserId,
    String biography
){
};
