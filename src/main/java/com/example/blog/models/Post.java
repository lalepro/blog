package com.example.blog.controllers;

public class Post {
    private static String title;
    private static String body;

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        Post.title = title;
    }

    public static String getBody() {
        return body;
    }

    public static void setBody(String body) {
        Post.body = body;
    }
}
