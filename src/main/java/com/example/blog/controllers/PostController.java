package com.example.blog.controllers;

import com.example.blog.daos.PostsRepository;
import com.example.blog.models.Post;
import com.example.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostService postSvc;
    private final PostsRepository postRepo;

    public PostController(PostService postSvc, PostsRepository postRepo) {
        this.postSvc = postSvc;
        this.postRepo = postRepo;
    }
    @GetMapping("/blog")
    public String blog(Model model){
        model.addAttribute("posts", postRepo.findAll());
        return "/posts/blog";
    }

    @GetMapping("/posts/titles")
    public String titles(Model model){
        model.addAttribute("posts", postRepo.findAll());
        return "/posts/titles";
    }

    @GetMapping("/posts/{id}/view")
    public String viewOne(@PathVariable long id, Model model){
        model.addAttribute("post", postRepo.findOne(id));
        return "/posts/view";
    }

    @GetMapping("/posts")
    public String index( Model model){
//                List<Post> posts = new ArrayList<>();
//        Post post1 = new Post(1, "first title", "first body");
//        Post post2 = new Post(2, "second title", "second body");
//        posts.add(post1);
//        posts.add(post2);
        model.addAttribute("posts", postRepo.findAll());
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model){
//        Post post = new Post(1,"first post title", "first post body");
        model.addAttribute("post", postRepo.findOne(id));
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String create(Model model){
        model.addAttribute("newPost", new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String insert(@ModelAttribute Post newPost){
        postRepo.save(newPost);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model model){
        model.addAttribute("editPost", postRepo.findOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String update(@ModelAttribute Post editPost){
        Post e = postRepo.findOne(editPost.getId());
        e.setTitle(editPost.getTitle());
        e.setBody(editPost.getBody());
        postRepo.save(e);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id){
        postRepo.delete(id);
        return "redirect:/posts";

    }
}
