package com.example.demo;

public class Article {
    private static Long followingId = 1L;

    private final Long id;
    private final String description;

    public Article(String description) {
        this.id = followingId++;
        this.description = description;
    }


    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
