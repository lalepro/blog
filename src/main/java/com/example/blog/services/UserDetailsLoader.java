package com.example.blog.services;

import com.example.blog.daos.UsersRepository;
import com.example.blog.models.User;
import com.example.blog.models.UserWithRoles;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService{
    private UsersRepository usersDao;

    public UserDetailsLoader(UsersRepository usersDao){
        this.usersDao = usersDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersDao.findByUsername(username);
         if(user == null){
             throw new UsernameNotFoundException(String.format("No Username: %s found", username));
         }
        UserWithRoles userWithRoles = new UserWithRoles(user);
        return userWithRoles;
    }
}
