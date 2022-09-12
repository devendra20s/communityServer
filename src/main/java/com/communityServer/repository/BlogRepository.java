package com.communityServer.repository;

import com.communityServer.model.Blog;
import com.communityServer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends CrudRepository<Blog, Integer> {
    List<Blog> findAll();

    Optional<Blog> findByAuthor(String author);
}
