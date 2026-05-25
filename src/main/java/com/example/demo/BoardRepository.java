package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class BoardRepository {

    private final ArrayList<ArticleBoard> articleBoards = new ArrayList<>();

    public BoardRepository() {
        this.articleBoards.add(new ArticleBoard("자유게시판"));
    }

    public ArrayList<ArticleBoard> findAll() {
        return articleBoards;
    }

}
