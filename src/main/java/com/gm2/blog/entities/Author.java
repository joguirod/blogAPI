package com.gm2.blog.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "author")
@Table(name = "author")
@Getter
@Setter
public class Author{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;
    private String name;
    private String biography;

    @OneToOne
    private BlogUser user;
    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Post> postList;
}
