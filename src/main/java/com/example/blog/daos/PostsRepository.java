package com.example.blog.daos;

import com.example.blog.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//TODO: JPA #4 Create an interface for posts that extends CrudRepository
@Repository
public interface PostsRepository extends CrudRepository<Post, Long> {
    Post findById(long id);
//    @Override
//    Iterable<Post> findAll(Iterable<Long> iterable);

//    Iterable<Post> findAllById(Iterable<Long> iterable);

}