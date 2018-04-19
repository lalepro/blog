package com.example.blog.services;

import com.example.blog.daos.PostsRepository;
import com.example.blog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
//    TODO: Temporary Array before SQL hookup
    private List<Post> posts;

    public PostService(){
        posts = new ArrayList<>();
        createPosts();
    }
//    TODO:Hookup for SQL
    private  PostsRepository postDao;
    @Autowired
    public PostService(PostsRepository postDao){
        this.postDao = postDao;
    }

//    TODO:FindAll sends all posts to index
    public List<Post> findAll(){
        return posts;
    }

//    TODO FindOne allows you to find one post by its ID
    public Post findOne(long id){
        return posts.get((int) id -1);
    }

//    TODO:Used in the PostMapping Insert Method for creating a new post
    public void createNewPost(Post post){
        post.setId(posts.size());
        posts.add(post);
    }

//    TODO: Feeds our WORK until we have a SQL DB
    private void createPosts(){
        saveArray(new Post("Great Day to Code", "Why Hike or Bike when you can trek in tech land"));
        saveArray(new Post("Hump Day!", "When you want it to be Friday but it's not"));
        saveArray(new Post("4 weeks to Capstone!", "I'm Fine! Fake it til ya make it!"));

    }
//    TODO: save works for the createPosts method for creating an array
    public void saveArray(Post post){
        post.setId(posts.size() + 1);
        posts.add(post);
    }

//    TODO:PostRepo Methods

    public Iterable<Post> allPosts(){
        return postDao.findAll();
    }

    public Post findById(long id){
        return postDao.findOne(id);
    }

    public Post save(Post post) {
        postDao.save(post);
        return postDao.findOne(post.getId());
    }

    public void delete(long id){
        postDao.delete(id);
    }

}
