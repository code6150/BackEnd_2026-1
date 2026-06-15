package com.example.demo.Board;

public class Board {

    private static Long followingId = 1L;

    private final Long id;
    private String boardName;

    public Board(String boardName) {
        this.id = followingId++;
        this.boardName = boardName;
    }

    public Long getId() {
        return id;
    }

    public String getBoardName() {
        return boardName;
    }

    public void modifyBoard(String modifiedBoardName) {
        boardName = modifiedBoardName;
    }
}
