package com.example.blog.daos;

import com.example.blog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostsRepository extends CrudRepository<Post, Long> {
}