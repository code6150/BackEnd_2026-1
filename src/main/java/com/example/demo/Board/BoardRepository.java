package com.example.demo.Board;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class BoardRepository {

    private final HashMap<Long, Board> articleBoards = new HashMap<>();
    public BoardRepository() {
        this.articleBoards.put(1L, new Board("자유게시판"));
    }

    public HashMap<Long, Board> findAll() {
        return articleBoards;
    }

}
