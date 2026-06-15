package com.example.demo.Article;

import java.time.LocalDateTime;

public class Article {
    private static Long followingId = 1L;

    private final Long id;
    private String title;
    private String description;
    private final LocalDateTime LDT;
    private final Long memberId;
    private final Long boardId;
    private LocalDateTime lastModifiedTime;

    public Article(String title, String description, Long memberId, Long boardId) {
        this.id = followingId++;
        this.title = title;
        this.description = description;
        this.memberId = memberId;
        this.boardId = boardId;
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

    public Long getMemberId() {
        return memberId;
    }

    public Long getBoardId() {
        return boardId;
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
