package com.communityServer.service;

import com.communityServer.model.Blog;
import com.communityServer.model.User;

import java.util.List;

public interface BlogService {
    Blog getBlog(String user);
    List<Blog> getAllBlog();

    Blog addBlog(Blog blog ,String author);

    String updateBlog(Blog blog);

}
