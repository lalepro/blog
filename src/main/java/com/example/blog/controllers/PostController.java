package com.example.blog.controllers;

import com.example.blog.models.Post;
import com.example.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostService postSvc;

    public PostController(PostService postSvc) {
        this.postSvc = postSvc;
    }

    @GetMapping("/posts")
    public String index( Model model){
//                List<Post> posts = new ArrayList<>();
//        Post post1 = new Post(1, "first title", "first body");
//        Post post2 = new Post(2, "second title", "second body");
//        posts.add(post1);
//        posts.add(post2);
        model.addAttribute("posts", postSvc.findAll());
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable Integer id, Model model){
//        Post post = new Post(1,"first post title", "first post body");
        model.addAttribute("post", postSvc.findOne(id));
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String create(Model model){
        Post post = new Post();
        model.addAttribute("post", post);
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String insert( @ModelAttribute Post post){
        postSvc.save(post);
        return "redirect:/posts";
    }
}
