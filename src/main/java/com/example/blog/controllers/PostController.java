package com.example.blog.controllers;

import com.example.blog.daos.CategoriesRepository;
import com.example.blog.daos.PostsRepository;
import com.example.blog.daos.UsersRepository;
import com.example.blog.models.Category;
import com.example.blog.models.Post;
//import com.example.blog.models.PostDetails;
import com.example.blog.models.User;
import com.example.blog.services.PostService;
import com.example.blog.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PostController {
    private final PostService postSvc;
    private final PostsRepository postRepo;
    private final UsersRepository usersRepo;
    private final CategoriesRepository categoriesRepo;
    private final UserService userService;

    public PostController(PostService postSvc, PostsRepository postRepo, UsersRepository usersRepo, CategoriesRepository categoriesRepo, UserService userService) {
        this.postSvc = postSvc;
        this.postRepo = postRepo;
        this.usersRepo = usersRepo;
        this.categoriesRepo = categoriesRepo;
        this.userService = userService;
    }
    @GetMapping("/")
    public String blog(Model model){
        model.addAttribute("posts", postRepo.findAll());
        return "/posts/blog";
    }
    @GetMapping("/about")
    public String about(){
        return "/posts/about";
    }

    @GetMapping("/titles")
    public String titles(Model model){
//        User user = userService.loggedInUser();
//        System.out.println(user.getId());
        model.addAttribute("posts", postRepo.findAll());
        return "/posts/titles";
    }

//    @GetMapping("/posts/{id}/view")
//    public String viewOne(@PathVariable long id, Model model){
//        model.addAttribute("post", postRepo.findOne(id));
//        return "/posts/view";
//    }

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
        Post post = postRepo.findOne(id);
//        Post post = new Post(1,"first post title", "first post body");
        model.addAttribute("isPostOwner", userService.isLoggedInAndPostMatchesUser(post.getUser()));
        model.addAttribute("post", postRepo.findOne(id));
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String create(Model model){
        Post post = new Post();
        Iterable<Category> categories = categoriesRepo.findAll();
//        post.setPostDetails(new PostDetails());
        model.addAttribute("post", post);
        model.addAttribute("categories", categories);
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String insert(@Valid Post post, Errors errors, Model model){
//        post.setUser(usersRepo.findById(2l));
        if (post.getTitle().contains("fuck")) {
            errors.rejectValue("title", "bad-words", "Can't use curse words");
        }

        if(errors.hasErrors()){
            model.addAttribute(post);
                    return "/posts/create";
        }
        User user = userService.loggedInUser();
        System.out.println(user.getId());

//        System.out.println(user.getUsername());
        post.setUser(user);
        postRepo.save(post);
        return "redirect:/posts";
//        return "redirect:/posts" + newPost.getId();
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

    @GetMapping("posts/{id}/confirm-delete")
    public String confirmDelete(@PathVariable long id, Model model) {
        model.addAttribute("post", postRepo.findOne(id));
        return "posts/confirm-delete";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        postRepo.delete(id);
        return "redirect:/posts";
    }



//    @GetMapping("/posts/{id}/delete")
//    public String delete(@PathVariable long id){
//
//        postRepo.delete(id);
//        return "redirect:/posts";
//
//    }
//    @GetMapping("/posts/test")
//    public String test(){
//        Post p = new Post();
//        p.setTitle("Hello");
//        p.setBody("body");
//        p.setPostDetails(new PostDetails("jd", "asdf", "asdf"));
//        List<Category> cat = new ArrayList();
//        p.setCategories(cat);
//        postRepo.save(p);
//        return "redirect:/posts";
//    }
}

//test