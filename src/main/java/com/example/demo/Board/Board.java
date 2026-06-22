package com.example.demo.Board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Board {

    private static Long followingId = 1L;

    private Long id;
    private String boardName;

    public Board(String boardName) {
        this.id = followingId++;
        this.boardName = boardName;
    }

    public void modifyBoard(String modifiedBoardName) {
        boardName = modifiedBoardName;
    }
}
