package com.gm2.blog.entities;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

@Entity(name = "post")
@Table(name = "post")
@Getter
@Setter
@AllArgsConstructor
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

    public Post(){
        this.postDate = LocalDateTime.now();
    }
}
