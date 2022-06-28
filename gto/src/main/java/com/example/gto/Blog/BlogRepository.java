package com.example.gto.Blog;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BlogRepository extends MongoRepository<Blog, String> {
    List<Blog> findByTitleContaining(String title);

    Optional<Blog> findById(String id);

    @Query(value = "{'userId': ?0}")
    Optional<Blog> queryBlogByUser(@Param("id") String userId);

}
