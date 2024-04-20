package com.gm2.blog.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record BlogUserDTO (
        @NotBlank
        Long id,
        @NotBlank
        String username,
        @NotBlank
        String password,
        @NotBlank
        String email,
        @NotBlank
        LocalDateTime registrationDate
){
};
