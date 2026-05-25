package com.example.demo;

import java.util.ArrayList;

public class BoardRepository {

    private final ArrayList<ArticleBoard> articleBoards = new ArrayList<>();

    public BoardRepository() {
        this.articleBoards.add(new ArticleBoard("자유게시판"));
    }

    public ArrayList<ArticleBoard> findAll() {
        return articleBoards;
    }

}
