package com.example.blog.models;

import com.example.blog.models.Post;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Categories {
    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;



    //TODO: Many to many relationship between Posts and Categories
    @ManyToMany(mappedBy = "categories")
    private List<Post> posts;



    public Categories() {
    }

    public Categories(String name, List<Post> posts) {
        this.name = name;
        this.posts = posts;
    }

    public Categories(long id, String name, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.posts = posts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
