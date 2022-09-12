package com.communityServer.exception;

public class BlogNotFoundException extends RuntimeException{
    private String message;
    public BlogNotFoundException() {}

    public BlogNotFoundException(String msg)
    {
        super(msg);
        this.message = msg;
    }

}
