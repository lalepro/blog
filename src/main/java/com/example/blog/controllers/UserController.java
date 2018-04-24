package com.example.blog.controllers;

import com.example.blog.daos.UsersRepository;
import com.example.blog.models.Post;
import com.example.blog.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    private UsersRepository usersDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UsersRepository usersDao, PasswordEncoder passwordEncoder) {
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignUpForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "user/sign-up";
    }

    @PostMapping("/sign-up")
    public String registerUser(@Valid User user, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute(user);
            return "user/sign-up";
        }
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        usersDao.save(user);
        return "redirect:/login";
    }
    @GetMapping("/login")
        public String showLoginForm(){
//            User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return "user/login";
        }


}
