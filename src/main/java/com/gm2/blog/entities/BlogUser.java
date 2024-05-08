package com.gm2.blog.entities;

import com.gm2.blog.dto.BlogUserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "blogUser")
@Table(name = "blogUser")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blogUserId;
    private String username;
    private String password;
    private String email;
    private LocalDateTime registrationDate;

    public BlogUser(BlogUserDTO blogUserDTO) {
        this.username = blogUserDTO.username();
        this.password = blogUserDTO.password();
        this.email = blogUserDTO.email();
        this.registrationDate = LocalDateTime.now();
    }
}
