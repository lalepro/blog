package com.example.blog.daos;

import com.example.blog.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends CrudRepository<Category, Long> {
//    Category findById(long id);

}
