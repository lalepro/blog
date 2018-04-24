package com.example.blog.daos;

import com.example.blog.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<User, Long>{
    public User findByUsername(String username);
}
