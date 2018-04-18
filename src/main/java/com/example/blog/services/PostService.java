package com.example.blog.services;

import com.example.blog.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts;

    public PostService(){
        posts = new ArrayList<>();
        createAds();
    }
    public List<Post> findAll(){
        return posts;
    }

    public Post save(Post post){
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

    public Post findOne(int id){
        return posts.get(id -1);
    }

    private void createAds(){
        save(new Post("Great Day to Code", "Why Hike or Bike when you can trek in tech land"));
        save(new Post("Hump Day!", "When you want it to be Friday but it's not"));
        save(new Post("4 weeks to Capstone!", "I'm Fine! Fake it til ya make it!"));

    }
}
