package com.gm2.blog.dto;

import jakarta.validation.constraints.NotBlank;

public record PostDTO(

        @NotBlank
        Long authorId,

        @NotBlank
        String text

) {
}
