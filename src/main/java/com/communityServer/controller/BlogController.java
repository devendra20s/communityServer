package com.communityServer.controller;

import com.communityServer.exception.BlogNotFoundException;
import com.communityServer.exception.ErrorResponse;
import com.communityServer.model.Blog;
import com.communityServer.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/getAllBlog")
    public List<Blog> getAllBlog() {
        return blogService.getAllBlog();
    }
    @GetMapping("/blog")
    public Blog getBlog(Authentication authentication) {
        System.out.println(authentication.getClass().getName());
        return blogService.getBlog(authentication.getClass().getName());
    }

    @PostMapping("/addBlog")
    public ResponseEntity addBlog(@RequestBody Blog blog) {
        return ResponseEntity.status(HttpStatus.CREATED).body(blogService.addBlog(blog,"devendra"));
    }
    @PostMapping("/updateBlog")
    public ResponseEntity updateBlog(@RequestBody Blog blog) {
        return ResponseEntity.status(HttpStatus.CREATED).body(blogService.updateBlog(blog));
    }







    @ExceptionHandler(value
            = BlogNotFoundException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse BlogNotFoundException(BlogNotFoundException ex) {
        return new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
    }
}

