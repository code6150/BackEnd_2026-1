package com.example.demo;

public class ArticleBoard {

    private static Long followingId;

    private final Long id;
    private final String boardName;

    public ArticleBoard(String boardName) {
        this.id = followingId++;
        this.boardName = boardName;
    }

    public Long getId() {
        return id;
    }

    public String getBoardName() {
        return boardName;
    }
}
