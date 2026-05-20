package com.example.demo;

import java.time.LocalDateTime;

public class Article {
    private static Long followingId = 1L;

    private final Long id;
    private String title;
    private String description;
    private final LocalDateTime LDT;
    private final String member;
    private LocalDateTime lastModifiedTime;

    public Article(String title, String description, String member) {
        this.id = followingId++;
        this.title = title;
        this.description = description;
        this.member = member;
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

    public String getMember() {
        return member;
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
