package com.gm2.blog.dto;

import jakarta.validation.constraints.NotBlank;

public record PostEditionDTO (

        @NotBlank
        Long postId,

        @NotBlank
        String text
){
}
