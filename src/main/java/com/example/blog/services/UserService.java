package com.example.blog.services;

import com.example.blog.models.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public boolean isLoggedIn(){
        boolean isAnonymous = SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken;
        return !isAnonymous;
    }

    public User loggedInUser() {
        if(!isLoggedIn()){
            return null;
        }
       return  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public boolean isLoggedInAndPostMatchesUser(User user){
        return isLoggedIn() && (loggedInUser().getId() == user.getId());
    }
}