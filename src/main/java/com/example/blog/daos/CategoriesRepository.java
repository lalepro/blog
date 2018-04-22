package com.example.blog.daos;

import com.example.blog.models.Categories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends CrudRepository<Categories, Long> {
    Categories findById(long id);
}
