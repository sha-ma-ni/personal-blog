package com.myblog.demo.repo;

import com.myblog.demo.models.Post;
import org.springframework.data.repository.CrudRepository; //встроенный интерфейс с функциями delete; update, create,

public interface PostRepository extends CrudRepository<Post, Long> {
}
