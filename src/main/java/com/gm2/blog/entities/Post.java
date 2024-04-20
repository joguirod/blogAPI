package com.gm2.blog.entities;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "post")
@Table(name = "post")
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int postId;
    private String postText;
    private int upVotes;
    private int downVotes;
    private LocalDateTime postDate;

    @ManyToOne(fetch=FetchType.LAZY)
    private Author author;
}
