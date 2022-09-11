package com.communityServer.service;

import com.communityServer.exception.BlogNotFoundException;
import com.communityServer.model.Blog;
import com.communityServer.model.User;
import com.communityServer.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog getBlog(String user) {
        return blogRepository.findByAuthor(user).orElseThrow(() -> new BlogNotFoundException("NO Blog WITH THIS USERNAME  = " + user));
    }

    @Override
    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }

    @Override
    public Blog addBlog(Blog blog, String author) {
        blog.setAuthor(author);
        blogRepository.save(blog);
        return blog;
    }

    @Override
    public String updateBlog(Blog blog) {
        Blog existingBlog
                = blogRepository.findById(blog.getId())
                .orElse(null);
        if (existingBlog == null)
            throw new BlogNotFoundException(
                    "No Such Customer exists!!");
        else {
            existingBlog.setTitle(blog.getTitle());
            existingBlog.setContent(blog.getContent());
            existingBlog.setAuthor(blog.getAuthor());
            blogRepository.save(existingBlog);
            return "Record updated Successfully";
        }

    }


}
