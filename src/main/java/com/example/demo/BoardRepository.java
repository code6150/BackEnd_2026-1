package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class BoardRepository {

    private final HashMap<Long, ArticleBoard> articleBoards = new HashMap<>();
    public BoardRepository() {
        this.articleBoards.put(1L, new ArticleBoard("자유게시판"));
    }

    public HashMap<Long,ArticleBoard> findAll() {
        return articleBoards;
    }

}
