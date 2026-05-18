package com.example.demo;

public class Article {
    private final int id;
    private final String description;

    public Article(int id, String description) {
        this.id = id;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
