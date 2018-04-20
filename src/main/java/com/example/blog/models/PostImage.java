package com.example.blog.daos;

import com.example.blog.models.Post;

import javax.persistence.*;

@Entity
@Table(name="post-images")
public class PostImage {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String path;

    @ManyToOne
    @JoinColumn (name = "post_id")
    private Post post;

    public PostImage() {
    }

    public PostImage(String path, Post post) {
        this.path = path;
        this.post = post;
    }

    public PostImage(long id, String path, Post post) {
        this.id = id;
        this.path = path;
        this.post = post;
    }
}
