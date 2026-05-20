package com.example.demo;

import java.time.LocalDateTime;

public class Article {
    private static Long followingId = 1L;

    private final Long id;
    private String title;
    private String description;
    private final LocalDateTime LDT;
    private LocalDateTime lastModifiedTime;

    public Article(String title, String description) {
        this.id = followingId++;
        this.title = title;
        this.description = description;
        this.LDT = LocalDateTime.now();
        lastModifiedTime = null;
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getLDT() {
        return LDT;
    }

    public LocalDateTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLastModifiedTime(LocalDateTime lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }
}
